package com.melody.creditkeeper.beans.bank;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 银行
 *
 * @Id：主键 Long 型，可以通过@Id(autoincrement = true)设置自增长
 * @Property：设置一个非默认关系映射所对应的列名，默认是使用字段名，例如：@Property(nameInDb = "name")
 * @NotNull：设置数据库表当前列不能为空
 * @Transient：添加此标记后不会生成数据库表的列
 */
@Entity
public class BankBean {

    @Id(autoincrement = true)
    private Long id;
    private String name;

    public BankBean() {
    }

    @Generated(hash = 135651676)
    public BankBean(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
