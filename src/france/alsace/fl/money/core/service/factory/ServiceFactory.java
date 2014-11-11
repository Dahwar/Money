/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.core.service.factory;

import france.alsace.fl.money.core.service.IAccountService;
import france.alsace.fl.money.core.service.IAutoOperationService;
import france.alsace.fl.money.core.service.IBankService;
import france.alsace.fl.money.core.service.IOperationService;
import france.alsace.fl.money.core.service.IPeriodService;
import france.alsace.fl.money.core.service.ISubtypeService;
import france.alsace.fl.money.core.service.ITypeService;
import france.alsace.fl.money.core.service.implement.AccountService;
import france.alsace.fl.money.core.service.implement.AutoOperationService;
import france.alsace.fl.money.core.service.implement.BankService;
import france.alsace.fl.money.core.service.implement.OperationService;
import france.alsace.fl.money.core.service.implement.PeriodService;
import france.alsace.fl.money.core.service.implement.SubtypeService;
import france.alsace.fl.money.core.service.implement.TypeService;

/**
 *
 * @author Florent
 */
public class ServiceFactory {
    private static IBankService bankService;
    private static IAccountService accountService;
    private static IOperationService operationService;
    private static ITypeService typeService;
    private static ISubtypeService subtypeService;
    private static IAutoOperationService autoOperationService;
    private static IPeriodService periodService;
    
    public static IBankService getBankInstance() {
        if(bankService == null) {
            bankService = new BankService();
        }
        return bankService;
    }
    
    public static IAccountService getAccountInstance() {
        if(accountService == null) {
            accountService = new AccountService();
        }
        return accountService;
    }
    
    public static IOperationService getOperationInstance() {
        if(operationService == null) {
            operationService = new OperationService();
        }
        return operationService;
    }
    
    public static ITypeService getTypeInstance() {
        if(typeService == null) {
            typeService = new TypeService();
        }
        return typeService;
    }
    
    public static ISubtypeService getSubtypeInstance() {
        if(subtypeService == null) {
            subtypeService = new SubtypeService();
        }
        return subtypeService;
    }
    
    public static IAutoOperationService getAutoOperationInstance() {
        if(autoOperationService == null) {
            autoOperationService = new AutoOperationService();
        }
        return autoOperationService;
    }
    
    public static IPeriodService getPeriodInstance() {
        if(periodService == null) {
            periodService = new PeriodService();
        }
        return periodService;
    }
    
}
