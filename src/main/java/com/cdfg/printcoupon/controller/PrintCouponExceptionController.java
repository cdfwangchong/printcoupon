package com.cdfg.printcoupon.controller;

import cn.cdfg.exceptionHandle.PrintCouponNotFoundException;
import com.cdfg.printcoupon.pojo.untill.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@ControllerAdvice
public class PrintCouponExceptionController {

    @ExceptionHandler(value = PrintCouponNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @RequestMapping(produces="json/html; charset=UTF-8")
    @ResponseBody
    public Result<String> exception (PrintCouponNotFoundException exception){
        System.out.println(exception.getMsg());
        return new Result<String>(exception.getResultCode(),exception.getMsg(),"");
    }
}
