package com.webproject.onlineorder.entity;

import javax.persistence.*;


@Entity
@Table(name = "customers")
public class Customer {
    private static final long serialVersionUID = 2652327633296064143L;

    @Id
    private String email;

    private String firstName;
    private String lastName;
    private String password;
    // enabled 和 cart 不是前端能发送的值
    private boolean enabled;




    @OneToOne(cascade = CascadeType.ALL)
    // unique = true 不会出现重复值
    // joinColunm用来对外键进行约束
    @JoinColumn(unique = true)
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return  enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


}
