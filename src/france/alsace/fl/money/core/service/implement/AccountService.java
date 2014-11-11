/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.core.service.implement;

import france.alsace.fl.money.core.service.IAccountService;
import france.alsace.fl.money.data.component.Account;
import france.alsace.fl.money.data.dao.IAccountDAO;
import france.alsace.fl.money.data.dao.factory.DAOFactory;

/**
 *
 * @author Florent
 */
public class AccountService implements IAccountService {
    
    private IAccountDAO accountDAO = DAOFactory.getAccountInstance();
    
    @Override
    public boolean save(Account account) {
        return accountDAO.save(account);
    }

    @Override
    public Account findById(int id) {
        return accountDAO.findById(id);
    }
}
