package com.ams.carsys.user.service.bo;

import com.ams.carsys.order.service.bo.Order;


import java.util.List;

/**
 * @author FYY
 * @date 2019/11/9 0009 上午 9:56
 */

public class User {

    private int id;
    private String tel;
    private String password;
    private String email;
    private String invitation;
    private List<Order> order;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInvitation() {
        return invitation;
    }

    public void setInvitation(String invitation) {
        this.invitation = invitation;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", tel='" + tel + '\'' +
                ", password='" + password + '\'' +
                ", Email='" + email + '\'' +
                ", invitation='" + invitation + '\'' +
                ", order=" + order +
                '}';
    }
}
