package com.ams.carsys.car.view;

import com.ams.carsys.car.service.ICarService;
import com.ams.carsys.car.service.bo.Car;
import com.ams.carsys.info.service.bo.Resort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author FYY
 * @date 2019/11/12 0012 上午 9:19
 */
@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private ICarService carService;

    private static final Logger logger = LogManager.getLogger(CarController.class);


    @RequestMapping("/getByprice")
    @ResponseBody
    public Resort getByprice(int getid){
        Resort resort = new Resort();

        try {
            List<Car> cars = carService.selectByPrice(getid);
            resort.setInfo(cars);
            resort.setCode(1);
            return resort;
        } catch (Exception e) {
            resort.setInfo("系统繁忙，请联系管理员！！！");
            resort.setCode(0);
            return resort;
        }
    }

    @RequestMapping("/getByNum")
    @ResponseBody
    public Resort getByNum(int getid){
        Resort resort = new Resort();

        try {
            List<Car> cars = carService.selectByNum(getid);
            resort.setCode(1);
            resort.setInfo(cars);
            return resort;
        } catch (Exception e) {
            resort.setCode(0);
            return resort;
        }
    }

    @RequestMapping("/getByCar")
    @ResponseBody
    public Resort getByCar(int cid){

        Resort resort = new Resort();
        try {
            Car byId = carService.getById(cid);
            resort.setInfo(byId);
            resort.setCode(1);
            return resort;
        }catch (Exception e){
            resort.setInfo("系统繁忙，请联系管理员！！！");
            resort.setCode(0);
            return resort;
        }
    }
}
