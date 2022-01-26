package com.webproject.onlineorder.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Table;


@Entity
@Table(name = "authorities")
public class Authorities implements Serializable {
    // UID是一个随机数，为了区分每个版本不一样。
    // 自己找个随机数就行
    private static final long serialVersionUID = 8734140534986494039L;



    @Id
    private String email;


    private String authorities;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }










}
