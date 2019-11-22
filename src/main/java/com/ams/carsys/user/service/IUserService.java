package com.ams.carsys.user.service;

import com.ams.carsys.city.service.bo.City;
import com.ams.carsys.user.service.bo.User;

import java.util.List;
import java.util.Map;

/**
 * @author FYY
 * @date 2019/11/9 0009 上午 9:55
 */

public interface IUserService {

    /* 注册新用户 */
    public int insertUser(User user);

    /* 用来进行登录验证判断*/
    public User login(User user);


    public int allTel(String tel);


    public int updateUser(Map<String, String> condition);


    public User getUserId(int id);




}
