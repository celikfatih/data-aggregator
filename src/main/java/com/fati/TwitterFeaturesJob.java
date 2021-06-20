/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fati;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.mapping.Mapper;
import com.fati.join.*;
import com.fati.map.*;
import com.fati.model.TwitterExtractedFeatures;
import com.fati.model.TwitterTweet;
import com.fati.model.TwitterUser;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple10;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple25;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.batch.connectors.cassandra.CassandraPojoInputFormat;
import org.apache.flink.batch.connectors.cassandra.CassandraPojoOutputFormat;
import org.apache.flink.streaming.connectors.cassandra.ClusterBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Skeleton for a Flink Batch Job.
 *
 * <p>For a tutorial how to write a Flink batch application, check the
 * tutorials and examples on the <a href="https://flink.apache.org/docs/stable/">Flink Website</a>.
 *
 * <p>To package your application into a JAR file for execution,
 * change the main class in the POM.xml file to this class (simply search for 'mainClass')
 * and run 'mvn clean package' on the command line.
 */
public class TwitterFeaturesJob {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterFeaturesJob.class);

    public static final String TWEET_QUERY = "select * from letterboxd.twittertweet";
    public static final String USER_QUERY = "select * from letterboxd.twitteruser";
    public static final String CASSANDRA_HOST = "127.0.0.1";

    public static void main(String[] args) throws Exception {

        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        env.setParallelism(3);

        ClusterBuilder clusterBuilder = new ClusterBuilder() {
            private static final long serialVersionUID = 6729991447575940534L;

            @Override
            protected Cluster buildCluster(Cluster.Builder builder) {
                return builder.addContactPoints(CASSANDRA_HOST).build();
            }
        };

        final DataSet<TwitterTweet> tweetInputs = env.createInput(
                new CassandraPojoInputFormat<>(TWEET_QUERY, clusterBuilder, TwitterTweet.class),
                TypeInformation.of(TwitterTweet.class)
        );

        final DataSet<TwitterUser> userInputs = env.createInput(
                new CassandraPojoInputFormat<>(USER_QUERY, clusterBuilder, TwitterUser.class),
                TypeInformation.of(TwitterUser.class)
        );

        // Early birds
        DataSet<Tuple3<String, String, Integer>> earlyBirds = tweetInputs
                .flatMap(new EarlyBirds())
                .groupBy(0, 1)
                .sum(2)
                .groupBy(0)
                .maxBy(2);

        // Hashtags
        DataSet<Tuple2<String, Integer>> hashtags = tweetInputs.flatMap(new Hashtags())
                .groupBy(0)
                .sum(1);

        // Most used source
        DataSet<Tuple3<String, String, Integer>> mostUsedSources = tweetInputs.flatMap(new MostUsedSource())
                .groupBy(0, 1)
                .sum(2)
                .groupBy(0)
                .maxBy(2);

        // Preferred day
        DataSet<Tuple3<String, Integer, Integer>> preferredDays = tweetInputs.flatMap(new PreferredDay())
                .groupBy(0, 1)
                .sum(2)
                .groupBy(0)
                .maxBy(2);

        // Preferred hour
        DataSet<Tuple3<String, Integer, Integer>> preferredHours = tweetInputs.flatMap(new PreferredTimeOfDay())
                .groupBy(0, 1)
                .sum(2)
                .groupBy(0)
                .maxBy(2);

        // Retweeter
        DataSet<Tuple3<String, Boolean, Integer>> retweetter = tweetInputs.flatMap(new Retweetter())
                .groupBy(0, 1)
                .sum(2)
                .groupBy(0)
                .maxBy(2);

        // Total interactions
        DataSet<Tuple2<String, Integer>> totalInteractions = tweetInputs.flatMap(new TotalInteractions())
                .groupBy(0)
                .sum(1);

        // User mentions
        DataSet<Tuple2<String, Integer>> userMentions = tweetInputs.flatMap(new UserMentions())
                .groupBy(0)
                .sum(1);

        // Weekday tweeter
        DataSet<Tuple3<String, String, Integer>> weekdayTweeters = tweetInputs.flatMap(new WeekdayTweeter())
                .groupBy(0, 1)
                .sum(2)
                .groupBy(0)
                .maxBy(2);

        // User features
        DataSet<Tuple10<String, Boolean, Integer, Integer, Integer, Integer, Integer, Integer, Boolean, Boolean>> userFeatures =
                userInputs.flatMap(new UserFeatures());

        DataSet<Tuple25<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Boolean, Integer, Integer, Integer, String, Integer, Boolean, Integer, Integer, Integer, Integer, Integer, Integer, Boolean, Boolean>> features =
                earlyBirds.join(hashtags)
                        .where(0)
                        .equalTo(0)
                        .with(new EarlyBirdHashtagsJoin())
                        .join(mostUsedSources)
                        .where(0)
                        .equalTo(0)
                        .with(new MostUsedSourceJoin())
                        .join(preferredDays)
                        .where(0)
                        .equalTo(0)
                        .with(new PreferredDayJoin())
                        .join(preferredHours)
                        .where(0)
                        .equalTo(0)
                        .with(new PreferredTimeOfDayJoin())
                        .join(retweetter)
                        .where(0)
                        .equalTo(0)
                        .with(new RetweetterJoin())
                        .join(totalInteractions)
                        .where(0)
                        .equalTo(0)
                        .with(new TotalInteractionsJoin())
                        .join(userMentions)
                        .where(0)
                        .equalTo(0)
                        .with(new UserMentionsJoin())
                        .join(weekdayTweeters)
                        .where(0)
                        .equalTo(0)
                        .with(new WeekdayTweeterJoin())
                        .join(userFeatures)
                        .where(0)
                        .equalTo(0)
                        .with(new UserFeaturesJoin());

        DataSet<TwitterExtractedFeatures> extractedFeatures = features.flatMap(new Tuple2POJO());

        CassandraPojoOutputFormat<TwitterExtractedFeatures> outputFormat = new CassandraPojoOutputFormat<>(clusterBuilder,
                TwitterExtractedFeatures.class, () -> new Mapper.Option[]{Mapper.Option.saveNullFields(true)});
        outputFormat.configure(null);
        outputFormat.open(1, 1);
        extractedFeatures.collect()
                    .forEach(ef -> {
                        try {
                            outputFormat.writeRecord(ef);
                        } catch (IOException e) {
                            LOG.error("An error occurred data write to Cassandra. UserId: {}. Exception: {}", ef.getId(), e);
                        }
                    });
    }
}
