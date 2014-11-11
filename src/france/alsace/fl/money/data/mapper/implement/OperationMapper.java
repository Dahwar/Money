/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.mapper.implement;

import france.alsace.fl.money.core.service.ISubtypeService;
import france.alsace.fl.money.core.service.ITypeService;
import france.alsace.fl.money.core.service.factory.ServiceFactory;
import france.alsace.fl.money.data.component.Operation;
import france.alsace.fl.money.data.mapper.IMapper;
import france.alsace.fl.money.data.utils.annotation.AutoJoin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florent
 */
public class OperationMapper implements IMapper<Operation> {

    private ITypeService typeService = ServiceFactory.getTypeInstance();
    private ISubtypeService subtypeService = ServiceFactory.getSubtypeInstance();
    
    @Override
    public Operation map(ResultSet rs) {
        Operation operation = new Operation();
        try {
            operation.setId(rs.getInt("ope_id"));
            operation.setAmount(rs.getDouble("ope_amount"));
            operation.setDescription(rs.getString("ope_description"));
            operation.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("ope_date")));
            operation.setComment(rs.getString("ope_comment"));
            operation.setCheck(rs.getBoolean("ope_check"));
            
            int ope_typ_id = rs.getInt("ope_typ_id");
            int ope_sty_id = rs.getInt("ope_sty_id");
            
            AutoJoin autoJoinType = Operation.class.getDeclaredField("type").getAnnotation(AutoJoin.class);
            if(autoJoinType.value()) {
                operation.setType(typeService.findById(ope_typ_id));
            } else {
                operation.setType(null);
            }
            
            AutoJoin autoJoinSubtype = Operation.class.getDeclaredField("subtype").getAnnotation(AutoJoin.class);
            if(autoJoinSubtype.value()) {
                operation.setSubtype(subtypeService.findById(ope_sty_id));
            } else {
                operation.setSubtype(null);
            }
            
            rs.close();
            
        } catch (SQLException | ParseException | NoSuchFieldException | SecurityException ex) {
            Logger.getLogger(OperationMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operation;
    }
    
}
