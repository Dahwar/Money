/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.core.service.implement;

import france.alsace.fl.money.core.service.ITypeService;
import france.alsace.fl.money.data.component.Type;
import france.alsace.fl.money.data.dao.ITypeDAO;
import france.alsace.fl.money.data.dao.factory.DAOFactory;

/**
 *
 * @author Florent
 */
public class TypeService implements ITypeService {

    private ITypeDAO typeDAO = DAOFactory.getTypeInstance();
    
    @Override
    public boolean save(Type type) {
        return typeDAO.save(type);
    }

    @Override
    public Type findById(int id) {
        return typeDAO.findById(id);
    }
    
}
