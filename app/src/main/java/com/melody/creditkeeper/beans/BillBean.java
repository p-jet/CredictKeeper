package com.melody.creditkeeper.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 账单 实体类
 */
@Entity
public class BillBean {

    @Id(autoincrement = true)
    private Long id;

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

    //分期利率
    private double stageRate;

    //备注
    private String remark;

    @Generated(hash = 335728223)
    public BillBean(Long id, String usage, double amount, Date billDate,
            boolean isStage, int volume, double stageRate, String remark) {
        this.id = id;
        this.usage = usage;
        this.amount = amount;
        this.billDate = billDate;
        this.isStage = isStage;
        this.volume = volume;
        this.stageRate = stageRate;
        this.remark = remark;
    }

    @Generated(hash = 562884989)
    public BillBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public boolean isStage() {
        return isStage;
    }

    public void setStage(boolean stage) {
        isStage = stage;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getStageRate() {
        return stageRate;
    }

    public void setStageRate(double stageRate) {
        this.stageRate = stageRate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean getIsStage() {
        return this.isStage;
    }

    public void setIsStage(boolean isStage) {
        this.isStage = isStage;
    }
}
