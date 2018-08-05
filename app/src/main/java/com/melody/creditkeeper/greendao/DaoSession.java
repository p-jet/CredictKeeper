package com.melody.creditkeeper.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.melody.creditkeeper.beans.bank.BankBean;
import com.melody.creditkeeper.beans.BillBean;
import com.melody.creditkeeper.beans.CreditCardBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig bankBeanDaoConfig;
    private final DaoConfig billBeanDaoConfig;
    private final DaoConfig creditCardBeanDaoConfig;

    private final BankBeanDao bankBeanDao;
    private final BillBeanDao billBeanDao;
    private final CreditCardBeanDao creditCardBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        bankBeanDaoConfig = daoConfigMap.get(BankBeanDao.class).clone();
        bankBeanDaoConfig.initIdentityScope(type);

        billBeanDaoConfig = daoConfigMap.get(BillBeanDao.class).clone();
        billBeanDaoConfig.initIdentityScope(type);

        creditCardBeanDaoConfig = daoConfigMap.get(CreditCardBeanDao.class).clone();
        creditCardBeanDaoConfig.initIdentityScope(type);

        bankBeanDao = new BankBeanDao(bankBeanDaoConfig, this);
        billBeanDao = new BillBeanDao(billBeanDaoConfig, this);
        creditCardBeanDao = new CreditCardBeanDao(creditCardBeanDaoConfig, this);

        registerDao(BankBean.class, bankBeanDao);
        registerDao(BillBean.class, billBeanDao);
        registerDao(CreditCardBean.class, creditCardBeanDao);
    }
    
    public void clear() {
        bankBeanDaoConfig.clearIdentityScope();
        billBeanDaoConfig.clearIdentityScope();
        creditCardBeanDaoConfig.clearIdentityScope();
    }

    public BankBeanDao getBankBeanDao() {
        return bankBeanDao;
    }

    public BillBeanDao getBillBeanDao() {
        return billBeanDao;
    }

    public CreditCardBeanDao getCreditCardBeanDao() {
        return creditCardBeanDao;
    }

}
