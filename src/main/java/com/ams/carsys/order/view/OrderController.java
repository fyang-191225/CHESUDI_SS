package com.ams.carsys.order.view;

import com.ams.carsys.info.service.bo.Page;
import com.ams.carsys.info.service.bo.Resort;
import com.ams.carsys.order.service.IOrderService;
import com.ams.carsys.order.service.bo.SelectOrder;
import com.ams.carsys.user.service.bo.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author FYY
 * @date 2019/11/12 0012 上午 11:51
 */

@Controller
@RequestMapping("/order")
public class OrderController {
    private static final Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    private IOrderService orderService;


    /**
     * 添加订单
     * @param getid 取车城市id
     * @param backid 还车城市id
     * @param cid
     * @param oprice 价格
     * @param session
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Resort add(Integer getid, Integer backid, Integer cid, double oprice, HttpSession session) {
        Resort resort = new Resort();
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            resort.setInfo("您未登录");
            resort.setCode(2);
            return resort;
        } else {
            try {
                orderService.addOrder(getid, backid, cid, currentUser.getId(), oprice);
                resort.setInfo("成功下单");
                resort.setCode(1);
                return resort;
            } catch (Exception e) {
                resort.setInfo("下单失败");
                resort.setCode(0);
                return resort;
            }
        }
    }

    @RequestMapping("/mymainJsp")
    public String mymainJsp() {

        return "mymain";
    }

//    @RequestMapping("/selectOrder")
//    @ResponseBody
//    public Resort selectOrder( HttpSession session){
//        Resort resort = new Resort();
//        User user = (User)session.getAttribute("currentUser");
//        int uid = user.getId();
//        logger.info(uid);
//        try {
//            List<SelectOrder> selectOrders = orderService.selectOrder(uid);
//            for (SelectOrder selectOrder : selectOrders) {
//                logger.info(selectOrder);
//            }
//            resort.setInfo(selectOrders);
//            resort.setCode(1);
//            return resort;
//        } catch (Exception e){
//            resort.setCode(0);
//            return resort;
//        }
//
//    }

    @RequestMapping("/selectOrder")
    @ResponseBody
    public Resort selectOrder(HttpSession session, int page) {
        Resort resort = new Resort();
        User user = (User) session.getAttribute("currentUser");
        Map<String, Integer> map = new HashMap<>();
        map.put("uid", user.getId());
        map.put("pageNum",page);
        try {
            Page page1 = orderService.selectOrder(map);
            HashMap<Object, Object> map1 = new HashMap<>();
            map1.put("result", page1.getResult());
            map1.put("total", page1.getTotal());
            resort.setInfo(map1);
            resort.setCode(1);
            return resort;
        } catch (Exception e) {
            resort.setInfo("订单出错，请联系管理员，或稍后重试！！！");
            resort.setCode(0);
            return resort;
        }
    }


    @RequestMapping("/delete")
    public String delete(int id){
        logger.info(id);
        orderService.delete(id);
        return "forward:/order/mymainJsp";
    }

}
