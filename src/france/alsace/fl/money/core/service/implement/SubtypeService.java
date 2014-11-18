/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.core.service.implement;

import france.alsace.fl.money.core.service.ISubtypeService;
import france.alsace.fl.money.core.service.factory.ServiceFactory;
import france.alsace.fl.money.data.component.Subtype;
import france.alsace.fl.money.data.dao.ISubtypeDAO;
import france.alsace.fl.money.data.dao.factory.DAOFactory;
import java.util.List;

/**
 *
 * @author Florent
 */
public class SubtypeService implements ISubtypeService {

    private ISubtypeDAO subtypeDAO = DAOFactory.getSubtypeInstance();
    
    @Override
    public boolean save(Subtype subtype) {
        return subtypeDAO.save(subtype);
    }

    @Override
    public Subtype findById(int id) {
        return subtypeDAO.findById(id);
    }

    @Override
    public List<Subtype> getAll() {
        return subtypeDAO.getAll();
    }

    @Override
    public List<Subtype> getAll(int number, int offset) {
        return subtypeDAO.getAll(number, offset);
    }
    
}
