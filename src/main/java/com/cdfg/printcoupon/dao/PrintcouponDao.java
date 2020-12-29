package com.cdfg.printcoupon.dao;

import com.cdfg.printcoupon.pojo.dto.User;
import org.springframework.stereotype.Repository;

@Repository
public interface PrintcouponDao {
    int insert(User record);

    int selectByPrimaryKey(String cardId);
}