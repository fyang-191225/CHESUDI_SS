package com.ams.carsys.user.view;

import com.ams.carsys.info.service.bo.Resort;
import com.ams.carsys.user.service.IUserService;
import com.ams.carsys.user.service.bo.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author FYY
 * @date 2019/11/9 0009 上午 9:56
 */

@Controller
@RequestMapping("/user")
public class userController {

    private static final Logger logger = LogManager.getLogger(userController.class);

    @Autowired
    private IUserService userService;

    /**
     * 登录验证
     *
     * @param user    从前段获取的数据
     * @param session session 用来创建session,并把查询到的数据放在session中
     * @param model   用来向前端传送数据
     * @return 返回前端接受数据的内容
     */
    @RequestMapping("/loginDo")
    @ResponseBody
    public Resort loginDo(User user, HttpSession session, Model model) {
        Resort resort = new Resort();
        User userLogin = userService.login(user);
        if (userLogin != null && user.getPassword().equals(userLogin.getPassword())) {
            /* 把通过login()方法获取到的数据放到session中，命名为currentUser */
            session.setAttribute("currentUser", userLogin);
            resort.setInfo("登录成功");
            resort.setCode(1);
            return resort;
        } else {
            String msg = "用户名或者密码错误";
            resort.setInfo(msg);
            model.addAttribute("msg", msg);
            resort.setCode(0);
            return resort;

        }

    }

    /**
     * 添加新用户,注册新用户
     *
     * @param user 从前端获取的user对象
     * @return 返回响应的内容
     *              1.info
     *              2.code
     */
    @RequestMapping("/add")
    @ResponseBody
    public Resort add(User user, HttpSession session) {
        Resort resort = new Resort();
        /* 获取存放在session中的数据 ,验证码*/
        String num = (String) session.getAttribute("num");
        logger.info(num);
        session.invalidate();
        // 判断从前端获取的数据即验证码,与存放在session中的验证码是否一致,一致表示可以注
        // 册,不一致,表示验证码错粗,不能注册
        if (user.getInvitation() != null && user.getInvitation().equals(num)) {
            userService.insertUser(user);
            resort.setCode(1);
            return resort;
        } else {
            resort.setInfo("密码不一致或验证码输入错误");
            resort.setCode(0);
            return resort;
        }
    }

    @RequestMapping("/tel")
    @ResponseBody
    public Resort tel(String tel) {
        logger.info(tel);
        Resort resort = new Resort();
        int i = userService.allTel(tel);
        if (i != 0) {
            resort.setCode(0);
        }
        return resort;
    }

    /**
     * 修改信息
     *
     * @param user 从前端获取的数据,密码.与要修改的账户
     * @param session 用来创建session,并把查询到的数据放在session中
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Resort update(User user, HttpSession session) {
        Resort resort = new Resort();
        // 获取登录时存放在session中的关于用户的信息
        User user1 = (User) session.getAttribute("currentUser");
        // 从session中获取的密码
        String oldPassword = user1.getPassword();
        // 从前端获取的密码
        String newPassword = user.getPassword();
        // 判断前端输入密码,是否与session中的密码是否一致
        if (oldPassword.equals(newPassword)) {
            // 把数据放到hashMap中,
            Map<String, String> condition = new HashMap<>();
            condition.put("password", newPassword);
            condition.put("tel", user.getTel());
            int i = userService.updateUser(condition);
            if (i == 0) {
                resort.setInfo("密码错误");
                resort.setCode(0);
                return resort;
            } else {
                resort.setCode(1);
                return resort;
            }
        } else {
            resort.setInfo("密码错误");
            resort.setCode(0);
            return resort;
        }
    }


    @RequestMapping("/denglu")
    @ResponseBody
    public Resort denglu(HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        Resort resort = new Resort();
        User user = userService.getUserId(currentUser.getId());
        HashMap<Object, Object> map = new HashMap<>();
        map.put("tel", user.getTel());
        map.put("email", user.getEmail());
        map.put("password", user.getPassword());
        if (currentUser != null) {
            resort.setInfo(map);
            resort.setCode(1);
            return resort;
        } else {
            resort.setInfo("未登录");
            resort.setCode(0);
            return resort;
        }
    }

}
