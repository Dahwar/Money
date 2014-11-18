/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.mapper.implement;

import france.alsace.fl.money.core.service.ITypeService;
import france.alsace.fl.money.core.service.factory.ServiceFactory;
import france.alsace.fl.money.data.component.Subtype;
import france.alsace.fl.money.data.mapper.IMapper;
import france.alsace.fl.money.data.utils.annotation.AutoJoin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florent
 */
public class SubtypeMapper implements IMapper<Subtype> {

    private ITypeService typeService = ServiceFactory.getTypeInstance();
    
    @Override
    public Subtype map(ResultSet rs) {
        Subtype subtype = new Subtype();
        try {
            subtype.setId(rs.getInt("sty_id"));
            subtype.setText(rs.getString("sty_text"));
            
            int sty_typ_id = rs.getInt("sty_typ_id");
            
            AutoJoin autoJoin = Subtype.class.getDeclaredField("type").getAnnotation(AutoJoin.class);
            if(autoJoin.value()) {
                subtype.setType(typeService.findById(sty_typ_id));
            } else {
                subtype.setType(null);
            }
            
        } catch (SQLException | NoSuchFieldException | SecurityException ex) {
            Logger.getLogger(SubtypeMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subtype;
    }
    
}
