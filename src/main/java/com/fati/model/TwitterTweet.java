package com.fati.model;

import com.datastax.driver.mapping.annotations.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * author @ fati
 * created @ 10.06.2021
 */

@Table(keyspace = "letterboxd", name = "twittertweet")
public class TwitterTweet implements Serializable {
    private static final long serialVersionUID = 7541746956626879099L;

    private String id;
    private Date createdAt;
    private String text;
    private String source;
    private Boolean truncated;
    private String userId;
    private Integer retweetCount;
    private Integer favoriteCount;
    private Set<String> hashtags;
    private Integer userMentionsCount;
    private Boolean retweet;
    private Boolean retweeted;
    private Boolean possiblySensitive;
    private String lang;
    private Boolean favorited;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getTruncated() {
        return truncated;
    }

    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(Integer retweetCount) {
        this.retweetCount = retweetCount;
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public Set<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(Set<String> hashtags) {
        this.hashtags = hashtags;
    }

    public Integer getUserMentionsCount() {
        return userMentionsCount;
    }

    public void setUserMentionsCount(Integer userMentionsCount) {
        this.userMentionsCount = userMentionsCount;
    }

    public Boolean getRetweet() {
        return retweet;
    }

    public void setRetweet(Boolean retweet) {
        this.retweet = retweet;
    }

    public Boolean getRetweeted() {
        return retweeted;
    }

    public void setRetweeted(Boolean retweeted) {
        this.retweeted = retweeted;
    }

    public Boolean getPossiblySensitive() {
        return possiblySensitive;
    }

    public void setPossiblySensitive(Boolean possiblySensitive) {
        this.possiblySensitive = possiblySensitive;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Boolean getFavorited() {
        return favorited;
    }

    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }
}
