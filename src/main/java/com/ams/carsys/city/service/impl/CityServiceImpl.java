package com.ams.carsys.city.service.impl;

import com.ams.carsys.city.service.ICityService;
import com.ams.carsys.city.service.bo.City;
import com.ams.carsys.city.service.bo.GetBackCity;
import com.ams.carsys.user.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FYY
 * @date 2019/11/11 0011 下午 19:16
 */

@Service
public class CityServiceImpl implements ICityService{

    @Autowired
    private IUserDao userDao;

    /**
     * 通过pid 获取符合条件的所有数据
     *         作用:
     *             选取取车城市 以及还车城市
     * @param pid
     * @return 返回一个list集合,符合条件的所有数据
     */
    @Override
    public List<City> getPid(int pid){
        return userDao.getPid(pid);
    }

    /**
     * 通过id 获取该条数据
     *
     * @param getid
     * @param backid
     * @return 返回一个对象
     */
    @Override
    public GetBackCity getId(int getid, int backid) {
        City getCity = userDao.getId(getid);
        City backCity = userDao.getId(backid);
        GetBackCity getBackCity = new GetBackCity();
        getBackCity.setGetCity(getCity);
        getBackCity.setBackCity(backCity);
        return getBackCity;
    }

}
