package com.melody.creditkeeper.beans;

import com.melody.creditkeeper.beans.bank.BankBean;
import com.melody.creditkeeper.beans.bank.BankBeanCover;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 信用卡实体类
 */
@Entity
public class CreditCardBean {

    @Id(autoincrement = true)
    private Long id;
    //卡名
    private String cardName;
    //银行
    @Convert(converter = BankBeanCover.class, columnType = String.class)
    private BankBean bank;
    //卡片号码
    private String cardNum;
    //额度
    private double amount;

    //剩余额度
    private double surpulsAmount;

    //是否限额
    private boolean isQuota;
    //限额
    private double quota;

    //有效期开始时间
    private Date validDataStart;
    //有效期结束时间
    private Date validDataEnd;

    //账单日
    private int billDate;
    //还款日
    private int repaymentDate;

    //开卡人电话
    private String phone;
    //开卡人姓名
    private String name;

    //备注
    private String remark;

    public CreditCardBean() {
    }

    @Generated(hash = 722369484)
    public CreditCardBean(Long id, String cardName, BankBean bank, String cardNum,
            double amount, double surpulsAmount, boolean isQuota, double quota,
            Date validDataStart, Date validDataEnd, int billDate, int repaymentDate,
            String phone, String name, String remark) {
        this.id = id;
        this.cardName = cardName;
        this.bank = bank;
        this.cardNum = cardNum;
        this.amount = amount;
        this.surpulsAmount = surpulsAmount;
        this.isQuota = isQuota;
        this.quota = quota;
        this.validDataStart = validDataStart;
        this.validDataEnd = validDataEnd;
        this.billDate = billDate;
        this.repaymentDate = repaymentDate;
        this.phone = phone;
        this.name = name;
        this.remark = remark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public BankBean getBank() {
        return bank;
    }

    public void setBank(BankBean bank) {
        this.bank = bank;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getSurpulsAmount() {
        return surpulsAmount;
    }

    public void setSurpulsAmount(double surpulsAmount) {
        this.surpulsAmount = surpulsAmount;
    }

    public boolean isQuota() {
        return isQuota;
    }

    public void setQuota(boolean quota) {
        isQuota = quota;
    }

    public double getQuota() {
        return quota;
    }

    public void setQuota(double quota) {
        this.quota = quota;
    }

    public Date getValidDataStart() {
        return validDataStart;
    }

    public void setValidDataStart(Date validDataStart) {
        this.validDataStart = validDataStart;
    }

    public Date getValidDataEnd() {
        return validDataEnd;
    }

    public void setValidDataEnd(Date validDataEnd) {
        this.validDataEnd = validDataEnd;
    }

    public int getBillDate() {
        return billDate;
    }

    public void setBillDate(int billDate) {
        this.billDate = billDate;
    }

    public int getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(int repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean getIsQuota() {
        return this.isQuota;
    }

    public void setIsQuota(boolean isQuota) {
        this.isQuota = isQuota;
    }
}
