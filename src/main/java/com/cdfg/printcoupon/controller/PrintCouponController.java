package com.cdfg.printcoupon.controller;

import cn.cdfg.exceptionHandle.PrintCouponNotFoundException;
import com.cdfg.printcoupon.pojo.dto.User;
import com.cdfg.printcoupon.pojo.untill.Print;
import com.cdfg.printcoupon.pojo.untill.Result;
import com.cdfg.printcoupon.service.PrintCouponService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.cdfg.printcoupon.pojo.untill.Constant.*;

@Controller
@RequestMapping("/cdfg")
@CrossOrigin
public class PrintCouponController {

    @Autowired
    PrintCouponService pcervice = null;

    Logger logger = Logger.getLogger(PrintCouponController.class);

    @PostMapping("/insertPrintCoupon")
    @ResponseBody
    public Result<String> insertVipTime(@RequestBody User user) {
        if (user == null) {
            logger.error("传入的对象值为null");
            throw new PrintCouponNotFoundException(errCode26,errMsg26);
        }
        logger.info("取到领券用户的值："+user.getName()+user.getCard_id());
        int res = pcervice.insert(user);
        if (res == 0) {
            logger.info(user.getName()+"&"+user.getCard_id()+"领取成功，开始打印");
            String cardId = user.getCard_id();
            String name = user.getName();
            Print pm = new Print(user.getCard_id(),user.getName());// 实例化打印类
            pm.pageSize = 1;//打印两页
            pm.starPrint();
            return new Result<String>(sucCode,sucMsg,"");
        }else {
            logger.error("顾客："+user.getName()+"&"+user.getCard_id()+"领取信息写入失败");
            throw new PrintCouponNotFoundException(errCode,errMsg);
        }
    }
}

