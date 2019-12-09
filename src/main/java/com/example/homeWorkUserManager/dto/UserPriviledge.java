package com.example.homeWorkUserManager.dto;

import com.example.homeWorkUserManager.model.Privileges;

import java.util.Set;

public class UserPriviledge {

   Long userId;

    boolean youtubeSubscription;

    public UserPriviledge(Long userId, Set<Privileges> privilegesList){
        this.userId = userId;
        youtubeSubscription = privilegesList.equals(Privileges.PRIVILEGE_YOUTUBE);

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isYoutubeSubscription() {
        return youtubeSubscription;
    }

    public void setYoutubeSubscription(boolean youtubeSubscription) {
        this.youtubeSubscription = youtubeSubscription;
    }
}
