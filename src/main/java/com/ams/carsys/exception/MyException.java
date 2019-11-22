package com.ams.carsys.exception;

import com.ams.carsys.info.service.bo.Resort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author FYY
 * @date 2019/11/14 0014 下午 17:20
 */

@ControllerAdvice
public class MyException {

    private static final Logger logger = LogManager.getLogger(MyException.class);


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Resort handleException(Exception ex){
        logger.error(ex.getMessage(),ex);
        Resort resort=new Resort();
        resort.setCode(0);
        resort.setInfo(ex.getMessage());

        return resort;
    }

}
