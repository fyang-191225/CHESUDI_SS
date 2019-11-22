package com.ams.carsys.car.service.bo;

/**
 * @author FYY
 * @date 2019/11/11 0011 上午 11:24
 */

public class Car {
    private int id;
    private String name;
    private String type;
    private int sitnum;
    private int cid;
    private double price;
    private int number;
    private String picture;


    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSitnum() {
        return sitnum;
    }

    public void setSitnum(int sitnum) {
        this.sitnum = sitnum;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", sitnum=" + sitnum +
                ", cid=" + cid +
                ", price=" + price +
                ", number=" + number +
                ", picture='" + picture + '\'' +
                '}';
    }
}
