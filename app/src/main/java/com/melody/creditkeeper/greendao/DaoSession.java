package com.melody.creditkeeper.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.melody.creditkeeper.beans.BillBean;
import com.melody.creditkeeper.beans.CreditCardBean;
import com.melody.creditkeeper.beans.bank.BankBean;

import com.melody.creditkeeper.greendao.BillBeanDao;
import com.melody.creditkeeper.greendao.CreditCardBeanDao;
import com.melody.creditkeeper.greendao.BankBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig billBeanDaoConfig;
    private final DaoConfig creditCardBeanDaoConfig;
    private final DaoConfig bankBeanDaoConfig;

    private final BillBeanDao billBeanDao;
    private final CreditCardBeanDao creditCardBeanDao;
    private final BankBeanDao bankBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        billBeanDaoConfig = daoConfigMap.get(BillBeanDao.class).clone();
        billBeanDaoConfig.initIdentityScope(type);

        creditCardBeanDaoConfig = daoConfigMap.get(CreditCardBeanDao.class).clone();
        creditCardBeanDaoConfig.initIdentityScope(type);

        bankBeanDaoConfig = daoConfigMap.get(BankBeanDao.class).clone();
        bankBeanDaoConfig.initIdentityScope(type);

        billBeanDao = new BillBeanDao(billBeanDaoConfig, this);
        creditCardBeanDao = new CreditCardBeanDao(creditCardBeanDaoConfig, this);
        bankBeanDao = new BankBeanDao(bankBeanDaoConfig, this);

        registerDao(BillBean.class, billBeanDao);
        registerDao(CreditCardBean.class, creditCardBeanDao);
        registerDao(BankBean.class, bankBeanDao);
    }
    
    public void clear() {
        billBeanDaoConfig.clearIdentityScope();
        creditCardBeanDaoConfig.clearIdentityScope();
        bankBeanDaoConfig.clearIdentityScope();
    }

    public BillBeanDao getBillBeanDao() {
        return billBeanDao;
    }

    public CreditCardBeanDao getCreditCardBeanDao() {
        return creditCardBeanDao;
    }

    public BankBeanDao getBankBeanDao() {
        return bankBeanDao;
    }

}
