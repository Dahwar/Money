/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.mapper.implement;

import france.alsace.fl.money.data.component.Period;
import france.alsace.fl.money.data.component.Type;
import france.alsace.fl.money.data.mapper.IMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florent
 */
public class PeriodMapper implements IMapper<Period> {

    @Override
    public Period map(ResultSet rs) {
        Period period = new Period();
        try {
            period.setId(rs.getInt("per_id"));
            period.setName(rs.getString("per_name"));
            
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Period.class.getName()).log(Level.SEVERE, null, ex);
        }
        return period;
    }
    
}
