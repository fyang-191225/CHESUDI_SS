package com.ams.carsys.car.service.impl;

import com.ams.carsys.car.service.ICarService;
import com.ams.carsys.car.service.bo.Car;
import com.ams.carsys.city.service.bo.City;
import com.ams.carsys.user.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FYY
 * @date 2019/11/12 0012 上午 9:21
 */
@Service
public class CarServiceImpl implements ICarService {
    @Autowired
    private IUserDao userDao;


    @Override
    public List<Car> selectByPrice(int cid) {
        return userDao.selectByPrice(cid);
    }



    @Override
    public Car getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public List<Car> selectByNum(int cid) {
        return userDao.selectByNum(cid);
    }
}
