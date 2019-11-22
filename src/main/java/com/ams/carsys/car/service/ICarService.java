package com.ams.carsys.car.service;

import com.ams.carsys.car.service.bo.Car;
import com.ams.carsys.city.service.bo.City;

import java.util.List;

/**
 * @author FYY
 * @date 2019/11/12 0012 上午 9:20
 */

public interface ICarService {

    public List<Car> selectByPrice(int cid);

    public List<Car> selectByNum(int cid);

    public Car getById(int id);
}
