/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.core.service.implement;

import france.alsace.fl.money.core.service.IAutoOperationService;
import france.alsace.fl.money.data.component.AutoOperation;
import france.alsace.fl.money.data.dao.IAutoOperationDAO;
import france.alsace.fl.money.data.dao.factory.DAOFactory;

/**
 *
 * @author Florent
 */
public class AutoOperationService implements IAutoOperationService {

    private IAutoOperationDAO autoOperationDAO = DAOFactory.getAutoOperationInstance();
    
    @Override
    public boolean save(AutoOperation autoOperation) {
        return autoOperationDAO.save(autoOperation);
    }

    @Override
    public AutoOperation findById(int id) {
        return autoOperationDAO.findById(id);
    }
    
}
