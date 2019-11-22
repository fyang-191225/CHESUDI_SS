package com.ams.carsys.user.dao;

import com.ams.carsys.car.service.bo.Car;
import com.ams.carsys.city.service.bo.City;
import com.ams.carsys.order.service.bo.Order;

import com.ams.carsys.order.service.bo.SelectOrder;
import com.ams.carsys.user.service.bo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author FYY
 * @date 2019/11/9 0009 上午 9:52
 */

@Repository
public interface IUserDao {
    /*-----------------------------------------------user---------------------------------------*/

    /* 注册新用户 */
    public int insertUser(User user);

    /*通过tel查询user表的个人信息 */
    public User getByTel(String tel);

    /* 通过id查询user表的个人信息
        作用：
            通过密码修改过个人信息后，通过id 获取全部信息，使修改过的信息显示出来 */
    public User getUserId(int id);

    /* 通过密码修改自己的个人账户或者邮箱，即tel or email */
    public int updateUser(Map<String, String> condition);



    public int allTel(String tel);

    /*-----------------------------------------------order---------------------------------------*/

    /**
     * 通过用户id 即order表中的 uid（用户id） 来查询order表的所有数据
     *
     * @param id
     * @return 返回符合条件的数据
     */
    public List<Order> orderId(int id);

    /**
     * 添加一条数据：作用：用来下订单 所需要的sql语句
     *
     * @param order 传入一个对象, 添加的元素
     * @return 返回值表示该sql语句影响的行数
     */
    public int addOrder(Order order);

    /**
     * 通过id来删除该条信息 作用：删除订单
     *
     * @param id 传入int 类型的参数, 订单的id
     * @return 返回操作的条数, 通过返回值来判断是否删除
     */
    public int delete(int id);

    /**
     * 联表查询; 通过用户id(uid) 来查出自己的订单具体数据;包括:(order 表中的订单号id, 价格price,
     * 状态status;car表中车型name; city表中的城市名[取车地,还车地,用order表中的getid和backid获取]  )  :
     *         left join 表名  on  连接的条件
     *         作用:
     *             获取自己的所有订单信息
     *         order by 按照什么排序
     *         include标签中的内容为limit( , ): 表示分页查询
     *
     * @param condition 传入的参数
     *                  1,uid 用户id
     *                  2,startIndex 分页查询需要的参数,表示每一页从那条数据开始
     *                  3,pageSize 每页有多少行
     * @return 返回符合条件的数据,list集合
     */
    public List<SelectOrder> page(Map<String,Integer> condition);

    /**
     * 和分页查询一起使用, 用与获取在分页查询条件下查到数据的总计
     *
     * @param condition 传入的参数
     *                  1,uid 用户id
     *
     * @return 返回符合条件的数据个数
     */
    public int pageCount(Map<String,Integer> condition);


    /*-----------------------------------------------city---------------------------------------*/

    /**
     * 通过id 获取该条数据
     *
     * @param getid 传入一个int 类型参数 id
     * @return 返回一个对象,一条数据
     */
    public City getId(int getid);


    /**
     * 通过pid 获取符合条件的所有数据
     *         作用:
     *             选取取车城市 以及还车城市
     * @param pid
     * @return 返回一个list集合,符合条件的所有数据
     */
    public List<City> getPid(int pid);

    /*-----------------------------------------------car---------------------------------------*/

    /**
     * 过cid 获取符合条件的所有的数据,并按价格的降序排列
     *         作用:
     *             通过城市的id 即car表中的cid 获取这个城市的所有车辆信息
     *
     * @param cid
     * @return 返回一个list集合,符合条件的所有数据
     */
    public List<Car> selectByPrice(int cid);

    /**
     * 通过cid 获取符合条件的所有的数据,并按数量的降序排列
     *         作用:
     *             通过城市的id 即car表中的cid 获取这个城市的所有车辆信息
     * @param cid
     * @return
     */
    public List<Car> selectByNum(int cid);
    /*  */
    public Car getById(int id);
}
