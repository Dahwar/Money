/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.dao.implement;

import france.alsace.fl.money.data.component.Operation;
import france.alsace.fl.money.data.component.Period;
import france.alsace.fl.money.data.component.Type;
import france.alsace.fl.money.data.dao.IPeriodDAO;
import france.alsace.fl.money.data.mapper.factory.MapperFactory;
import france.alsace.fl.money.data.utils.RequestBuilder;
import france.alsace.fl.money.data.utils.RequestExecutor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florent
 */
public class PeriodDAO implements IPeriodDAO {

    @Override
    public boolean save(Period period) {
        RequestBuilder rb = new RequestBuilder();
        rb.append("INSERT INTO period(per_name) " +
                  "VALUES (:per_name);");

        rb.setParameter("per_name", period.getName());
        
        return RequestExecutor.executeUpdate(rb.toString());
    }

    @Override
    public Period findById(int id) {
        RequestBuilder rb = new RequestBuilder();
        rb.append("SELECT per_id, per_name from period " +
                  "WHERE per_id=:per_id;");
        rb.setParameter("per_id", id);
        
        ResultSet rs = RequestExecutor.executeQuery(rb.toString());
        Period period = (Period) MapperFactory.getMapper(Period.class).map(rs);
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PeriodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return period;
    }

    @Override
    public List<Period> getAll() {
        List<Period> list = new ArrayList<>();
        
        RequestBuilder rb = new RequestBuilder();
        rb.append("SELECT per_id, per_name from period;");
        
        ResultSet rs = RequestExecutor.executeQuery(rb.toString());
        
        try {
            while(rs.next()) {
                list.add((Period) MapperFactory.getMapper(Period.class).map(rs));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Period.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }

    @Override
    public List<Period> getAll(int number, int offset) {
        List<Period> list = new ArrayList<>();
        
        RequestBuilder rb = new RequestBuilder();
        rb.append("SELECT per_id, per_name from period "
                + "LIMIT :count OFFSET :skip;");
        rb.setParameter("count", number);
        rb.setParameter("skip", offset);
        
        ResultSet rs = RequestExecutor.executeQuery(rb.toString());
        
        try {
            while(rs.next()) {
                list.add((Period) MapperFactory.getMapper(Period.class).map(rs));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Period.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
}
