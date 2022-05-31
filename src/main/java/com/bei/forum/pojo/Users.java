package com.bei.forum.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Users {
    private Integer id;

    private String email;

    private String name;

    private Integer avatarOrder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAvatarOrder() {
        return avatarOrder;
    }

    public void setAvatarOrder(Integer avatarOrder) {
        this.avatarOrder = avatarOrder;
    }
}