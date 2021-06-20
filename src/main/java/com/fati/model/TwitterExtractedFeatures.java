package com.fati.model;

import com.datastax.driver.mapping.annotations.Table;

import java.io.Serializable;

/**
 * author @ fati
 * created @ 19.06.2021
 */

@Table(keyspace = "letterboxd", name = "twitterextractedfeatures")
public class TwitterExtractedFeatures implements Serializable {
    private static final long serialVersionUID = 2533109597240561118L;

    String id;

    String birdOrOwl;
    Integer birdOrOwlCount;
    Integer hashtagCount;
    String source;
    Integer mostUsedSourceCount;
    Integer preferredDay;
    Integer mostUsedPreferredDayCount;
    Integer preferredHour;
    Integer mostUsedPreferredHourCount;
    Boolean isRetweetter;
    Integer isRetweetterCount;
    Integer totalInteractionCount;
    Integer totalUserMentionCount;
    String weekdayOrWeekend;
    Integer weekdayOrWeekendCount;
    Boolean verified;
    Integer followersCount;
    Integer friendsCount;
    Integer listedCount;
    Integer favouritesCount;
    Integer statusesCount;
    Integer accountCreationYear;
    Boolean geoEnabled;
    Boolean contributorsEnabled;

    public TwitterExtractedFeatures(String id, String birdOrOwl, Integer birdOrOwlCount, Integer hashtagCount, String source,
                                    Integer mostUsedSourceCount, Integer preferredDay, Integer mostUsedPreferredDayCount,
                                    Integer preferredHour, Integer mostUsedPreferredHourCount, Boolean isRetweetter,
                                    Integer isRetweetterCount, Integer totalInteractionCount, Integer totalUserMentionCount,
                                    String weekdayOrWeekend, Integer weekdayOrWeekendCount, Boolean verified,
                                    Integer followersCount, Integer friendsCount, Integer listedCount, Integer favouritesCount,
                                    Integer statusesCount, Integer accountCreationYear, Boolean geoEnabled,
                                    Boolean contributorsEnabled) {
        this.id = id;
        this.birdOrOwl = birdOrOwl;
        this.birdOrOwlCount = birdOrOwlCount;
        this.hashtagCount = hashtagCount;
        this.source = source;
        this.mostUsedSourceCount = mostUsedSourceCount;
        this.preferredDay = preferredDay;
        this.mostUsedPreferredDayCount = mostUsedPreferredDayCount;
        this.preferredHour = preferredHour;
        this.mostUsedPreferredHourCount = mostUsedPreferredHourCount;
        this.isRetweetter = isRetweetter;
        this.isRetweetterCount = isRetweetterCount;
        this.totalInteractionCount = totalInteractionCount;
        this.totalUserMentionCount = totalUserMentionCount;
        this.weekdayOrWeekend = weekdayOrWeekend;
        this.weekdayOrWeekendCount = weekdayOrWeekendCount;
        this.verified = verified;
        this.followersCount = followersCount;
        this.friendsCount = friendsCount;
        this.listedCount = listedCount;
        this.favouritesCount = favouritesCount;
        this.statusesCount = statusesCount;
        this.accountCreationYear = accountCreationYear;
        this.geoEnabled = geoEnabled;
        this.contributorsEnabled = contributorsEnabled;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirdOrOwl() {
        return birdOrOwl;
    }

    public void setBirdOrOwl(String birdOrOwl) {
        this.birdOrOwl = birdOrOwl;
    }

    public Integer getBirdOrOwlCount() {
        return birdOrOwlCount;
    }

    public void setBirdOrOwlCount(Integer birdOrOwlCount) {
        this.birdOrOwlCount = birdOrOwlCount;
    }

    public Integer getHashtagCount() {
        return hashtagCount;
    }

    public void setHashtagCount(Integer hashtagCount) {
        this.hashtagCount = hashtagCount;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getMostUsedSourceCount() {
        return mostUsedSourceCount;
    }

    public void setMostUsedSourceCount(Integer mostUsedSourceCount) {
        this.mostUsedSourceCount = mostUsedSourceCount;
    }

    public Integer getPreferredDay() {
        return preferredDay;
    }

    public void setPreferredDay(Integer preferredDay) {
        this.preferredDay = preferredDay;
    }

    public Integer getMostUsedPreferredDayCount() {
        return mostUsedPreferredDayCount;
    }

    public void setMostUsedPreferredDayCount(Integer mostUsedPreferredDayCount) {
        this.mostUsedPreferredDayCount = mostUsedPreferredDayCount;
    }

    public Integer getPreferredHour() {
        return preferredHour;
    }

    public void setPreferredHour(Integer preferredHour) {
        this.preferredHour = preferredHour;
    }

    public Integer getMostUsedPreferredHourCount() {
        return mostUsedPreferredHourCount;
    }

    public void setMostUsedPreferredHourCount(Integer mostUsedPreferredHourCount) {
        this.mostUsedPreferredHourCount = mostUsedPreferredHourCount;
    }

    public Boolean getIsRetweetter() {
        return isRetweetter;
    }

    public void setIsRetweetter(Boolean retweetter) {
        isRetweetter = retweetter;
    }

    public Integer getIsRetweetterCount() {
        return isRetweetterCount;
    }

    public void setIsRetweetterCount(Integer isRetweetterCount) {
        this.isRetweetterCount = isRetweetterCount;
    }

    public Integer getTotalInteractionCount() {
        return totalInteractionCount;
    }

    public void setTotalInteractionCount(Integer totalInteractionCount) {
        this.totalInteractionCount = totalInteractionCount;
    }

    public Integer getTotalUserMentionCount() {
        return totalUserMentionCount;
    }

    public void setTotalUserMentionCount(Integer totalUserMentionCount) {
        this.totalUserMentionCount = totalUserMentionCount;
    }

    public String getWeekdayOrWeekend() {
        return weekdayOrWeekend;
    }

    public void setWeekdayOrWeekend(String weekdayOrWeekend) {
        this.weekdayOrWeekend = weekdayOrWeekend;
    }

    public Integer getWeekdayOrWeekendCount() {
        return weekdayOrWeekendCount;
    }

    public void setWeekdayOrWeekendCount(Integer weekdayOrWeekendCount) {
        this.weekdayOrWeekendCount = weekdayOrWeekendCount;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Integer getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(Integer friendsCount) {
        this.friendsCount = friendsCount;
    }

    public Integer getListedCount() {
        return listedCount;
    }

    public void setListedCount(Integer listedCount) {
        this.listedCount = listedCount;
    }

    public Integer getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(Integer favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public Integer getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(Integer statusesCount) {
        this.statusesCount = statusesCount;
    }

    public Integer getAccountCreationYear() {
        return accountCreationYear;
    }

    public void setAccountCreationYear(Integer accountCreationYear) {
        this.accountCreationYear = accountCreationYear;
    }

    public Boolean getGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(Boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    public Boolean getContributorsEnabled() {
        return contributorsEnabled;
    }

    public void setContributorsEnabled(Boolean contributorsEnabled) {
        this.contributorsEnabled = contributorsEnabled;
    }
}
