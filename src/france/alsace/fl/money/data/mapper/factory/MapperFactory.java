/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.mapper.factory;

import france.alsace.fl.money.data.component.Account;
import france.alsace.fl.money.data.component.AutoOperation;
import france.alsace.fl.money.data.component.Bank;
import france.alsace.fl.money.data.component.Operation;
import france.alsace.fl.money.data.component.Period;
import france.alsace.fl.money.data.component.Subtype;
import france.alsace.fl.money.data.component.Type;
import france.alsace.fl.money.data.mapper.IMapper;
import france.alsace.fl.money.data.mapper.implement.AccountMapper;
import france.alsace.fl.money.data.mapper.implement.AutoOperationMapper;
import france.alsace.fl.money.data.mapper.implement.BankMapper;
import france.alsace.fl.money.data.mapper.implement.OperationMapper;
import france.alsace.fl.money.data.mapper.implement.PeriodMapper;
import france.alsace.fl.money.data.mapper.implement.SubtypeMapper;
import france.alsace.fl.money.data.mapper.implement.TypeMapper;

/**
 *
 * @author Florent
 */
public class MapperFactory {
    
    private static IMapper accountMapper;
    private static IMapper bankMapper;
    private static IMapper operationMapper;
    private static IMapper typeMapper;
    private static IMapper subtypeMapper;
    private static IMapper autoOperationMapper;
    private static IMapper periodMapper;
    
    private static IMapper getAccountMapperInstance() {
        if(accountMapper == null) {
            accountMapper = new AccountMapper();
        }
        return accountMapper;
    }
    
    private static IMapper getBankMapperInstance() {
        if(bankMapper == null) {
            bankMapper = new BankMapper();
        }
        return bankMapper;
    }
    
    private static IMapper getOperationMapperInstance() {
        if(operationMapper == null) {
            operationMapper = new OperationMapper();
        }
        return operationMapper;
    }
    
    private static IMapper getTypeMapperInstance() {
        if(typeMapper == null) {
            typeMapper = new TypeMapper();
        }
        return typeMapper;
    }
    
    private static IMapper getSubtypeMapperInstance() {
        if(subtypeMapper == null) {
            subtypeMapper = new SubtypeMapper();
        }
        return subtypeMapper;
    }
    
    private static IMapper getAutoOperationMapperInstance() {
        if(autoOperationMapper == null) {
            autoOperationMapper = new AutoOperationMapper();
        }
        return autoOperationMapper;
    }
    
    private static IMapper getPeriodMapperInstance() {
        if(periodMapper == null) {
            periodMapper = new PeriodMapper();
        }
        return periodMapper;
    }
    
    public static IMapper getMapper(Class clazz) {
        if(clazz.equals(Bank.class)) {
            return getBankMapperInstance();
        } else if(clazz.equals(Account.class)) {
            return getAccountMapperInstance();
        } else if(clazz.equals(Operation.class)) {
            return getOperationMapperInstance();
        } else if(clazz.equals(Type.class)) {
            return getTypeMapperInstance();
        } else if(clazz.equals(Subtype.class)) {
            return getSubtypeMapperInstance();
        } else if(clazz.equals(AutoOperation.class)) {
            return getAutoOperationMapperInstance();
        } else if(clazz.equals(Period.class)) {
            return getPeriodMapperInstance();
        } else {
            return null;
        }
    }
}
