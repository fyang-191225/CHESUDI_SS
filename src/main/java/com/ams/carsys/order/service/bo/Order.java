package com.ams.carsys.order.service.bo;

import com.ams.carsys.car.service.bo.Car;
import com.ams.carsys.city.service.bo.City;

import java.util.List;

/**
 * @author FYY
 * @date 2019/11/9 0009 下午 19:32
 */

public class Order {
    private Integer id;
    private int cid ;
    private int uid ;
    private int getid ;
    private int  backid;
    private double oprice;
    private String status;
    private List<Car> car;
    private List<City> city;

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGetid() {
        return getid;
    }

    public void setGetid(int getid) {
        this.getid = getid;
    }

    public int getBackid() {
        return backid;
    }

    public void setBackid(int backid) {
        this.backid = backid;
    }

    public double getOprice() {
        return oprice;
    }

    public void setOprice(double oprice) {
        this.oprice = oprice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Car> getCar() {
        return car;
    }

    public void setCar(List<Car> car) {
        this.car = car;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", cid=" + cid +
                ", uid=" + uid +
                ", getid=" + getid +
                ", backid=" + backid +
                ", oprice=" + oprice +
                ", status='" + status + '\'' +
                ", car=" + car +
                ", city=" + city +
                '}';
    }
}
