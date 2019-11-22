package com.ams.carsys.order.service.bo;

import com.ams.carsys.car.service.bo.Car;
import com.ams.carsys.city.service.bo.City;

import java.util.List;

/**
 * @author FYY
 * @date 2019/11/12 0012 下午 19:47
 */

public class SelectOrder {
    private int oid;
    private double oprice;
    private String cname;
    private String getcity;
    private String backcity;
    private String ostatus;


    public SelectOrder() {
    }

    public SelectOrder(int oid, double oprice, String cname, String getcity, String backcity, String ostatus) {
        this.oid = oid;
        this.oprice = oprice;
        this.cname = cname;
        this.getcity = getcity;
        this.backcity = backcity;
        this.ostatus = ostatus;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public double getOprice() {
        return oprice;
    }

    public void setOprice(double oprice) {
        this.oprice = oprice;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getGetcity() {
        return getcity;
    }

    public void setGetcity(String getcity) {
        this.getcity = getcity;
    }

    public String getBackcity() {
        return backcity;
    }

    public void setBackcity(String backcity) {
        this.backcity = backcity;
    }

    public String getOstatus() {
        return ostatus;
    }

    public void setOstatus(String ostatus) {
        this.ostatus = ostatus;
    }

    @Override
    public String toString() {
        return "SelectOrder{" +
                "oid=" + oid +
                ", oprice=" + oprice +
                ", cname='" + cname + '\'' +
                ", getcity='" + getcity + '\'' +
                ", backcity='" + backcity + '\'' +
                ", ostatus='" + ostatus + '\'' +
                '}';
    }
}
