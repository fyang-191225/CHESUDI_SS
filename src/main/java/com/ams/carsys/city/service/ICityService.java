package com.ams.carsys.city.service;

import com.ams.carsys.city.service.bo.City;
import com.ams.carsys.city.service.bo.GetBackCity;

import java.util.List;

/**
 * @author FYY
 * @date 2019/11/11 0011 下午 19:14
 */

public interface ICityService {

    public List<City> getPid(int pid);

    public GetBackCity getId(int getid, int backid);
}
