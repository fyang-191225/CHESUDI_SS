package com.ams.carsys.mail.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

/**
 * @author FYY
 * @date 2019/11/13 0013 下午 21:12
 */

@Controller
@RequestMapping("/emailController")
public class EmailController {

    private static final Logger logger = LogManager.getLogger();

    private static ApplicationContext applicationContext;
    private static JavaMailSender javaMailSender;
    private static String mailSender ;


    static {
        applicationContext = new ClassPathXmlApplicationContext("spring1.xml");

        javaMailSender = (JavaMailSender) applicationContext.getBean("javaMailSender");

        Properties properties = new Properties();
        // 从配置文件中拿到发件人邮箱地址
        try {
            properties.load(EmailController.class.getResourceAsStream("/mail.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mailSender = properties.getProperty("spring.mail.username");
    }
    @RequestMapping("/mail")
    @ResponseBody
    public int mail(String email, HttpSession session){
        int ch = email.lastIndexOf("@");
        String suffix= email.substring(ch);
        if (!"@qq.com".equals(suffix)) {
            return 0;
        }else{
            String uuid = UUID.randomUUID().toString().replaceAll("_", "");
            String num = uuid.substring(0, 4);
            session.setAttribute("num", num);
            logger.info(email);
            try {
                SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                //邮件发送人
                simpleMailMessage.setFrom(mailSender);
                //邮件接收人
                simpleMailMessage.setTo(email);
                //邮件主题
                simpleMailMessage.setSubject("测试JavaMail");
                //邮件内容
                simpleMailMessage.setText(num);

                javaMailSender.send(simpleMailMessage);

                return 1;
            } catch (Exception e) {
                logger.error("邮件发送失败", e);
                return 2;
            }
        }
    }
}
