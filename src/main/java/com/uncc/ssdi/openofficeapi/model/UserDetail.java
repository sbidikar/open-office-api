package com.uncc.ssdi.openofficeapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetail {
    @JsonProperty
    private String userId;
    @JsonProperty
    private String userName;
    @JsonProperty
    private String userEmail;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
