/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.dao.implement;

import france.alsace.fl.money.data.component.Period;
import france.alsace.fl.money.data.component.Type;
import france.alsace.fl.money.data.dao.IPeriodDAO;
import france.alsace.fl.money.data.mapper.factory.MapperFactory;
import france.alsace.fl.money.data.utils.RequestBuilder;
import france.alsace.fl.money.data.utils.RequestExecutor;
import java.sql.ResultSet;

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
        
        return (Period) MapperFactory.getMapper(Period.class).map(rs);
    }
    
}
