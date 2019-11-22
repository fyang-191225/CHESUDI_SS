package com.ams.carsys.order.service.impl;

import com.ams.carsys.info.service.bo.Page;
import com.ams.carsys.order.service.IOrderService;
import com.ams.carsys.order.service.bo.Order;
import com.ams.carsys.order.service.bo.SelectOrder;
import com.ams.carsys.user.dao.IUserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author FYY
 * @date 2019/11/12 0012 上午 11:55
 */
@Service
public class OrderServiceImpl implements IOrderService {

    private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);

    @Autowired
    private IUserDao userDao;

    @Override
    public List<Order> orderId(int id) {
        return userDao.orderId(id);
    }

    @Override
    @Transactional
    public int delete(int id) {
        return userDao.delete(id);
    }

    /**
     * 添加订单
     *
     * @param getid
     * @param backid
     * @param cid
     * @param uid
     * @param oprice
     */
    @Override
    @Transactional
    public void addOrder(Integer getid, Integer backid, Integer cid, Integer uid, double oprice) {
        Order order = new Order();
        String status = "已预定";
        order.setCid(cid);
        order.setBackid(backid);
        order.setGetid(getid);
        order.setOprice(oprice);
        order.setUid(uid);
        order.setStatus(status);
        userDao.addOrder(order);
    }

//    @Override
//    public List<SelectOrder> selectOrder( int uid) {
//        return userDao.page(uid);
//    }

    @Override
    public Page selectOrder(Map<String, Integer> condition) {
        /*初始化pageNum,pageSize*/
        Integer pageNum = 1;
        Integer pageSize = 5;

        /* 判断前端是否传入了pageNum,如果传入，就应用传入值*/
        if (condition.containsKey("pageNum")) {
            pageNum = condition.get("pageNum");
        }
        /* 把pageNum 和pageSize 放入page 对象中计算出statIndex 的值*/
        Page page = new Page(pageNum, pageSize);

        /* 把 page 中计算出的 statIndex 和 初始化值 pageSize 放入condition 双边队列中 */
        condition.put("startIndex", page.getStartIndex());
        condition.put("pageSize", pageSize);

        /* 查询符合条件所对应的数据 ， 放入page 中的resoult 中*/
        page.setResult(userDao.page(condition));
        /* 查询符合条件所对应数据的个数 ，放入page total 中 */
        page.setTotal(userDao.pageCount(condition));
        return page;
    }
}
