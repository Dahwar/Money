/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.core.service.implement;

import france.alsace.fl.money.core.service.IPeriodService;
import france.alsace.fl.money.data.component.Period;
import france.alsace.fl.money.data.dao.IPeriodDAO;
import france.alsace.fl.money.data.dao.factory.DAOFactory;

/**
 *
 * @author Florent
 */
public class PeriodService implements IPeriodService {

    private IPeriodDAO periodDAO = DAOFactory.getPeriodInstance();
    
    @Override
    public boolean save(Period period) {
        return periodDAO.save(period);
    }

    @Override
    public Period findById(int id) {
        return periodDAO.findById(id);
    }
    
}
