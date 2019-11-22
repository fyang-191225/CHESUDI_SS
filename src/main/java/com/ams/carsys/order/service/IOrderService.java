package com.ams.carsys.order.service;


import com.ams.carsys.info.service.bo.Page;
import com.ams.carsys.order.service.bo.Order;
import com.ams.carsys.order.service.bo.SelectOrder;


import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * @author FYY
 * @date 2019/11/12 0012 上午 11:56
 */

public interface IOrderService {

    public List<Order> orderId(int id);

    public void addOrder(Integer getid, Integer backid,Integer cid, Integer uid ,double opice );

   // public List<SelectOrder> selectOrder( int uid);
    public int delete(int id);

    public Page selectOrder(Map<String, Integer> condition);

}
