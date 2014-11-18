/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.core.service.implement;

import france.alsace.fl.money.core.service.IOperationService;
import france.alsace.fl.money.data.component.Operation;
import france.alsace.fl.money.data.dao.IOperationDAO;
import france.alsace.fl.money.data.dao.factory.DAOFactory;
import java.util.List;

/**
 *
 * @author Florent
 */
public class OperationService implements IOperationService {

    private IOperationDAO operationDAO = DAOFactory.getOperationInstance();
    
    @Override
    public boolean save(Operation operation) {
        return operationDAO.save(operation);
    }

    @Override
    public Operation findById(int id) {
        return operationDAO.findById(id);
    }

    @Override
    public List<Operation> getAll() {
        return operationDAO.getAll();
    }

    @Override
    public List<Operation> getAll(int number, int offset) {
        return operationDAO.getAll(number, offset);
    }
    
}
