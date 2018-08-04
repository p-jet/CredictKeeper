package com.melody.creditkeeper.beans;

import java.sql.Date;

/**
 * 账单 实体类
 */
public class BillBean {

    private int id;

    //用途
    private String usage;

    //账单金额
    private double amount;

    //账单日期
    private Date billDate;

    //是否分期
    private boolean isStage;
    //期数
    private int volume;

    //备注
    private String remark;


}
