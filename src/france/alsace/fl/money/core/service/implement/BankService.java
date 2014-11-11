/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.core.service.implement;

import france.alsace.fl.money.core.service.IBankService;
import france.alsace.fl.money.data.component.Bank;
import france.alsace.fl.money.data.dao.factory.DAOFactory;
import france.alsace.fl.money.data.dao.IBankDAO;

/**
 *
 * @author Florent
 */
public class BankService implements IBankService {

    private IBankDAO bankDAO = DAOFactory.getBankInstance();
    
    @Override
    public boolean save(Bank bank) {
        return bankDAO.save(bank);
    }

    @Override
    public Bank findById(int id) {
        return bankDAO.findById(id);
    }
    
}
