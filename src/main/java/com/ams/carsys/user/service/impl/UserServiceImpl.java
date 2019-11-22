package com.ams.carsys.user.service.impl;

import com.ams.carsys.city.service.bo.City;
import com.ams.carsys.user.dao.IUserDao;
import com.ams.carsys.user.service.IUserService;
import com.ams.carsys.user.service.bo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author FYY
 * @date 2019/11/9 0009 上午 9:56
 */

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    /**
     * 注册新用户
     *
     * @param user 传入参数是一个user对象
     */
    @Override
    @Transactional
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    /**
     * 通过用户名获取该条数据，用来进行登录验证判断
     *
     * @param user 传入一个对象
     * @return 返回通过用户名获取该条数据 ，是个user对象
     */
    @Override
    public User login(User user) {
        return userDao.getByTel(user.getTel());
    }

    @Override
    public int allTel(String tel) {
        return userDao.allTel(tel);
    }

    /**
     * 通过id查询user表的个人信息
     * @param id
     * @return 返回一个user对象
     */
    @Override
    public User getUserId(int id) {
        return userDao.getUserId(id);
    }

    /**
     * 通过密码修改自己的个人账户或者邮箱，即tel or email
     *
     * @param condition 传入的参数,个人账户或者邮箱
     * @return 返回影响的行数
     */
    @Override
    @Transactional
    public int updateUser(Map<String, String> condition){
        return userDao.updateUser(condition);
    }
}
