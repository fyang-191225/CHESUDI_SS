package com.ams.carsys.sys.view;


import com.ams.carsys.car.service.bo.Car;
import com.ams.carsys.city.service.bo.City;
import com.ams.carsys.user.service.IUserService;
import com.ams.carsys.user.service.bo.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author FYY
 * @date 2019/11/7 0007 下午 15:14
 */
@Controller
public class ViewController {
    @Autowired
    private IUserService userService;

    private static final Logger logger = LogManager.getLogger(ViewController.class);

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping("/loginJsp")
    public String loginJsp() {

        return "login";
    }

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {

        return "index";
    }

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/indexJsp")
    public String indexJsp() {
        return "index";
    }

    /**
     * 注册页面
     *
     * @return
     */
    @RequestMapping("/registerJsp")
    public String registerJsp() {
        return "register";
    }

    /**
     * 登陆成功
     *
     * @return
     */
    @RequestMapping("/loginsuccessJsp")
    public String loginsuccessJsp() {

        return "loginsuccess";
    }


    /**
     * 个人信息
     *
     * @return
     */
    @RequestMapping("/myinfoJsp")
    public String myinfoJsp(User user, Model model) {
        logger.info(user);


        User user1 = userService.login(user);
        model.addAttribute("user1", user1);
        return "myinfo";
    }


    /**
     * 订单管理
     *
     * @return
     */
    @RequestMapping("/orderSubmitJsp")
    public String orderSubmitJsp() {
        return "ordersubmit";
    }

    /**
     * 判断是否登录
     *
     * @param session
     * @return
     */
    @RequestMapping("/middle")
    public String middle(HttpSession session) {
        Object currentUser = session.getAttribute("currentUser");
        if (currentUser != null) {
            return "forward:loginsuccessJsp";
        } else {
            return "forward:loginJsp";
        }
    }


    /**
     * 短租自驾
     *
     * @return
     */
    @RequestMapping("/shortrentJsp")
    public String shortRentJsp() {
        return "shortrent";
    }

    /**
     * 选车界面
     *
     * @param session
     * @return
     */
    @RequestMapping("/shortsortJsp")
    public String shortsort(HttpSession session) {
        Object currentUser = session.getAttribute("currentUser");
        if (currentUser != null) {
            return "shortsort";
        } else {
            return "forward:loginJsp";
        }
    }

    /**
     * 销毁session,退出,
     *
     * @param session
     * @return 返回index界面
     */
    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        session.invalidate();
        return "index";
    }
}
