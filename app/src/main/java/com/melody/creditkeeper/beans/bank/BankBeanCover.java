package com.melody.creditkeeper.beans.bank;

import com.alibaba.fastjson.JSON;

import org.greenrobot.greendao.converter.PropertyConverter;

public class BankBeanCover implements PropertyConverter<BankBean, String> {


    @Override
    public BankBean convertToEntityProperty(String databaseValue) {
        return JSON.parseObject(databaseValue, BankBean.class);
    }

    @Override
    public String convertToDatabaseValue(BankBean entityProperty) {
        return JSON.toJSONString(entityProperty);
    }
}
