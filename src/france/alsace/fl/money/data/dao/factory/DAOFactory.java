/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.dao.factory;

import france.alsace.fl.money.data.dao.IAccountDAO;
import france.alsace.fl.money.data.dao.IAutoOperationDAO;
import france.alsace.fl.money.data.dao.IBankDAO;
import france.alsace.fl.money.data.dao.IOperationDAO;
import france.alsace.fl.money.data.dao.IPeriodDAO;
import france.alsace.fl.money.data.dao.ISubtypeDAO;
import france.alsace.fl.money.data.dao.ITypeDAO;
import france.alsace.fl.money.data.dao.implement.AccountDAO;
import france.alsace.fl.money.data.dao.implement.AutoOperationDAO;
import france.alsace.fl.money.data.dao.implement.BankDAO;
import france.alsace.fl.money.data.dao.implement.OperationDAO;
import france.alsace.fl.money.data.dao.implement.PeriodDAO;
import france.alsace.fl.money.data.dao.implement.SubtypeDAO;
import france.alsace.fl.money.data.dao.implement.TypeDAO;

/**
 *
 * @author Florent
 */
public class DAOFactory {
    private static IBankDAO bankDAO;
    private static IAccountDAO accountDAO;
    private static IOperationDAO operationDAO;
    private static ITypeDAO typeDAO;
    private static ISubtypeDAO subtypeDAO;
    private static IAutoOperationDAO autoOperationDAO;
    private static IPeriodDAO periodDAO;
    
    public static IBankDAO getBankInstance() {
        if(bankDAO == null) {
            bankDAO = new BankDAO();
        }
        return bankDAO;
    }
    
    public static IAccountDAO getAccountInstance() {
        if(accountDAO == null) {
            accountDAO = new AccountDAO();
        }
        return accountDAO;
    }
    
    public static IOperationDAO getOperationInstance() {
        if(operationDAO == null) {
            operationDAO = new OperationDAO();
        }
        return operationDAO;
    }
    
    public static ITypeDAO getTypeInstance() {
        if(typeDAO == null) {
            typeDAO = new TypeDAO();
        }
        return typeDAO;
    }
    
    public static ISubtypeDAO getSubtypeInstance() {
        if(subtypeDAO == null) {
            subtypeDAO = new SubtypeDAO();
        }
        return subtypeDAO;
    }
    
    public static IAutoOperationDAO getAutoOperationInstance() {
        if(autoOperationDAO == null) {
            autoOperationDAO = new AutoOperationDAO();
        }
        return autoOperationDAO;
    }
    
    public static IPeriodDAO getPeriodInstance() {
        if(periodDAO == null) {
            periodDAO = new PeriodDAO();
        }
        return periodDAO;
    }
}
