package com.example.shriji.gitsquare.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SquareContribsModel {


    /**
     * login : JakeWharton
     * id : 66577
     * avatar_url : https://avatars0.githubusercontent.com/u/66577?v=4
     * gravatar_id :
     * url : https://api.github.com/users/JakeWharton
     * html_url : https://github.com/JakeWharton
     * followers_url : https://api.github.com/users/JakeWharton/followers
     * following_url : https://api.github.com/users/JakeWharton/following{/other_user}
     * gists_url : https://api.github.com/users/JakeWharton/gists{/gist_id}
     * starred_url : https://api.github.com/users/JakeWharton/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/JakeWharton/subscriptions
     * organizations_url : https://api.github.com/users/JakeWharton/orgs
     * repos_url : https://api.github.com/users/JakeWharton/repos
     * events_url : https://api.github.com/users/JakeWharton/events{/privacy}
     * received_events_url : https://api.github.com/users/JakeWharton/received_events
     * type : User
     * site_admin : false
     * contributions : 898
     */


    @SerializedName("login")
    @Expose
    private String mLogin;
    @SerializedName("id")
    @Expose
    private Integer mId;
    @SerializedName("avatar_url")
    @Expose
    private String mAvatarUrl;
    @SerializedName("gravatar_id")
    @Expose
    private String mGravatarId;
    @SerializedName("url")
    @Expose
    private String mUrl;
    @SerializedName("html_url")
    @Expose
    private String mHtmlUrl;
    @SerializedName("followers_url")
    @Expose
    private String mFollowersUrl;
    @SerializedName("following_url")
    @Expose
    private String mFollowingUrl;
    @SerializedName("gists_url")
    @Expose
    private String mGistsUrl;
    @SerializedName("starred_url")
    @Expose
    private String mStarredUrl;
    @SerializedName("subscriptions_url")
    @Expose
    private String mSubscriptionsUrl;
    @SerializedName("organizations_url")
    @Expose
    private String mOrganizationsUrl;
    @SerializedName("repos_url")
    @Expose
    private String mReposUrl;
    @SerializedName("events_url")
    @Expose
    private String mEventsUrl;
    @SerializedName("received_events_url")
    @Expose
    private String mReceivedEventsUrl;
    @SerializedName("type")
    @Expose
    private String mType;
    @SerializedName("site_admin")
    @Expose
    private Boolean mSiteAdmin;
    @SerializedName("contributions")
    @Expose
    private Integer mContributions;

    public SquareContribsModel(String login, Integer id, String avatarUrl,
                               String gravatarId, String url, String htmlUrl,
                               String followersUrl, String followingUrl,
                               String gistsUrl, String starredUrl, String subscriptionsUrl,
                               String organizationsUrl, String reposUrl, String eventsUrl,
                               String receivedEventsUrl, String type, Boolean siteAdmin,
                               Integer contributions) {
        mLogin = login;
        mId = id;
        mAvatarUrl = avatarUrl;
        mGravatarId = gravatarId;
        mUrl = url;
        mHtmlUrl = htmlUrl;
        mFollowersUrl = followersUrl;
        mFollowingUrl = followingUrl;
        mGistsUrl = gistsUrl;
        mStarredUrl = starredUrl;
        mSubscriptionsUrl = subscriptionsUrl;
        mOrganizationsUrl = organizationsUrl;
        mReposUrl = reposUrl;
        mEventsUrl = eventsUrl;
        mReceivedEventsUrl = receivedEventsUrl;
        mType = type;
        mSiteAdmin = siteAdmin;
        mContributions = contributions;
    }

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public String getGravatarId() {
        return mGravatarId;
    }

    public void setGravatarId(String gravatarId) {
        mGravatarId = gravatarId;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        mHtmlUrl = htmlUrl;
    }

    public String getFollowersUrl() {
        return mFollowersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        mFollowersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return mFollowingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        mFollowingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return mGistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        mGistsUrl = gistsUrl;
    }

    public String getStarredUrl() {
        return mStarredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        mStarredUrl = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return mSubscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        mSubscriptionsUrl = subscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return mOrganizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        mOrganizationsUrl = organizationsUrl;
    }

    public String getReposUrl() {
        return mReposUrl;
    }

    public void setReposUrl(String reposUrl) {
        mReposUrl = reposUrl;
    }

    public String getEventsUrl() {
        return mEventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        mEventsUrl = eventsUrl;
    }

    public String getReceivedEventsUrl() {
        return mReceivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        mReceivedEventsUrl = receivedEventsUrl;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public Boolean getSiteAdmin() {
        return mSiteAdmin;
    }

    public void setSiteAdmin(Boolean siteAdmin) {
        mSiteAdmin = siteAdmin;
    }

    public Integer getContributions() {
        return mContributions;
    }

    public void setContributions(Integer contributions) {
        mContributions = contributions;
    }
}
