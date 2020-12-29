package com.cdfg.printcoupon.service.impl;

import cn.cdfg.exceptionHandle.PrintCouponNotFoundException;
import com.cdfg.printcoupon.dao.PrintcouponDao;
import com.cdfg.printcoupon.pojo.dto.Printcoupon;
import com.cdfg.printcoupon.pojo.dto.User;
import com.cdfg.printcoupon.service.PrintCouponService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.cdfg.printcoupon.pojo.untill.Constant.*;

@Service
public class PrintCouponServiceImpl implements PrintCouponService {

    @Autowired
    PrintcouponDao pcDao = null;

    Logger logger = Logger.getLogger(PrintCouponServiceImpl.class);
    @Override
    public int insert(User user) {
        int count;
        int result;
        try {
            count = pcDao.selectByPrimaryKey(user.getCard_id());
        } catch (Exception e) {
            logger.error("查询顾客："+user.getName()+"&"+user.getCard_id()+"领取信息失败");
            throw new PrintCouponNotFoundException(errCode,errMsg);
        }
        if (count == 0) {
            try {
                result = pcDao.insert(user);
            } catch (Exception e) {
                logger.error("顾客："+user.getName()+"&"+user.getCard_id()+"领取信息写入失败");
                throw new PrintCouponNotFoundException(errCode,errMsg);
            }
        }else {
            logger.error("顾客："+user.getName()+"&"+user.getCard_id()+"已领用");
            throw new PrintCouponNotFoundException(errCode8,errMsg8);
        }
        if (result == 0) {
            logger.error("顾客："+user.getName()+"&"+user.getCard_id()+"领取信息写入返回值为0");
            throw new PrintCouponNotFoundException(errCode,errMsg);
        }else {
            logger.info("顾客："+user.getName()+"&"+user.getCard_id()+"领取信息写入成功");
            return 0;
        }
    }
}
