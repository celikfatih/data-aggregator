package com.fati.model;

import com.datastax.driver.mapping.annotations.Table;

import java.io.Serializable;
import java.util.Date;

/**
 * author @ fati
 * created @ 10.06.2021
 */

@Table(keyspace = "letterboxd", name = "twitteruser")
public class TwitterUser implements Serializable {
    private static final long serialVersionUID = 5882477328310729699L;

    private String id;

    private String name;
    private String screenName;
    private String location;
    private String url;
    private String description;
    private Boolean verified;
    private Integer followersCount;
    private Integer friendsCount;
    private Integer listedCount;
    private Integer favouritesCount;
    private Integer statusesCount;
    private Date createdAt;
    private Boolean geoEnabled;
    private String lang;
    private Boolean contributorsEnabled;
    private Boolean isTranslator;
    private Boolean defaultProfile;
    private Boolean defaultProfileImage;
    private String profileBackgroundColor;
    private Boolean profileBackgroundTiled;
    private Boolean profileUseBackgroundImage;
    private Boolean isVerified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(Boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Boolean getContributorsEnabled() {
        return contributorsEnabled;
    }

    public void setContributorsEnabled(Boolean contributorsEnabled) {
        this.contributorsEnabled = contributorsEnabled;
    }

    public Boolean getIsTranslator() {
        return isTranslator;
    }

    public void setIsTranslator(Boolean translator) {
        isTranslator = translator;
    }

    public Boolean getDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(Boolean defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    public Boolean getDefaultProfileImage() {
        return defaultProfileImage;
    }

    public void setDefaultProfileImage(Boolean defaultProfileImage) {
        this.defaultProfileImage = defaultProfileImage;
    }

    public String getProfileBackgroundColor() {
        return profileBackgroundColor;
    }

    public void setProfileBackgroundColor(String profileBackgroundColor) {
        this.profileBackgroundColor = profileBackgroundColor;
    }

    public Boolean getProfileBackgroundTiled() {
        return profileBackgroundTiled;
    }

    public void setProfileBackgroundTiled(Boolean profileBackgroundTiled) {
        this.profileBackgroundTiled = profileBackgroundTiled;
    }

    public Boolean getProfileUseBackgroundImage() {
        return profileUseBackgroundImage;
    }

    public void setProfileUseBackgroundImage(Boolean profileUseBackgroundImage) {
        this.profileUseBackgroundImage = profileUseBackgroundImage;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }
}
