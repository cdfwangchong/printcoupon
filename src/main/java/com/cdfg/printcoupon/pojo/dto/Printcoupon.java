package com.cdfg.printcoupon.pojo.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * printcoupon
 * @author 
 */
@Data
public class Printcoupon implements Serializable {
    /**
     * 证件号
     */
    private String cardId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 是否领用
     */
    private String isly;

    /**
     * 发送时间
     */
    private Date fsdate;

    private static final long serialVersionUID = 1L;
}