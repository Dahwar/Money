/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.mapper.implement;

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
public class TypeMapper implements IMapper<Type> {
    
    @Override
    public Type map(ResultSet rs) {
        Type type = new Type();
        try {
            type.setId(rs.getInt("typ_id"));
            type.setText(rs.getString("typ_text"));
            
        } catch (SQLException ex) {
            Logger.getLogger(TypeMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return type;
    }
    
}
