package com.ams.carsys.city.view;

import com.ams.carsys.city.service.ICityService;
import com.ams.carsys.city.service.bo.City;
import com.ams.carsys.city.service.bo.GetBackCity;
import com.ams.carsys.info.service.bo.Resort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * @author FYY
 * @date 2019/11/11 0011 下午 19:21
 */

@Controller
@RequestMapping("/city")
public class CityController {

    private static final Logger logger = LogManager.getLogger(CityController.class);

    @Autowired
    private ICityService cityService;

    /**
     * 通过pid 获取符合条件的所有数据
     *         作用:
     *             选取取车城市 以及还车城市
     * @param pid
     * @return
     */
    @RequestMapping("/selectPid")
    @ResponseBody
    public Resort selectPid(int pid){
        List<City> pid1 = cityService.getPid(pid);

        Resort resort = new Resort();
        resort.setInfo(pid1);
        return resort;
    }

    /**
     *
     * @param getid
     * @param backid
     * @return
     */
    @RequestMapping("/citys")
    @ResponseBody
    public Resort citysDo(int getid, int backid){
        Resort resort = new Resort();

        try {
            GetBackCity getBackCity = cityService.getId(getid, backid);
            resort.setInfo(getBackCity);
            resort.setCode(1);
            return resort;
        } catch (Exception e) {
            resort.setInfo("系统异常，请联系管理员！！！");
            resort.setCode(1);
            return resort;
        }
    }

}
