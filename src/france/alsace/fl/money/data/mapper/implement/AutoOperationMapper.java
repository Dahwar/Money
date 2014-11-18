/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.mapper.implement;

import france.alsace.fl.money.core.service.IPeriodService;
import france.alsace.fl.money.core.service.ISubtypeService;
import france.alsace.fl.money.core.service.ITypeService;
import france.alsace.fl.money.core.service.factory.ServiceFactory;
import france.alsace.fl.money.data.component.AutoOperation;
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
public class AutoOperationMapper implements IMapper<AutoOperation> {

    private ITypeService typeService = ServiceFactory.getTypeInstance();
    private ISubtypeService subtypeService = ServiceFactory.getSubtypeInstance();
    private IPeriodService periodService = ServiceFactory.getPeriodInstance();
    
    @Override
    public AutoOperation map(ResultSet rs) {
        AutoOperation autoOperation = new AutoOperation();
        try {
            autoOperation.setId(rs.getInt("aop_id"));
            autoOperation.setAmount(rs.getDouble("aop_amount"));
            autoOperation.setDescription(rs.getString("aop_description"));
            autoOperation.setDateAction(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("aop_date_action")));
            autoOperation.setComment(rs.getString("aop_comment"));
            
            int aop_typ_id = rs.getInt("aop_typ_id");
            int aop_sty_id = rs.getInt("aop_sty_id");
            int aop_per_id = rs.getInt("aop_per_id");
            
            AutoJoin autoJoinType = AutoOperation.class.getDeclaredField("type").getAnnotation(AutoJoin.class);
            if(autoJoinType.value()) {
                autoOperation.setType(typeService.findById(aop_typ_id));
            } else {
                autoOperation.setType(null);
            }
            
            AutoJoin autoJoinSubtype = AutoOperation.class.getDeclaredField("subtype").getAnnotation(AutoJoin.class);
            if(autoJoinSubtype.value()) {
                autoOperation.setSubtype(subtypeService.findById(aop_sty_id));
            } else {
                autoOperation.setSubtype(null);
            }
            
            AutoJoin autoJoinPeriod = AutoOperation.class.getDeclaredField("period").getAnnotation(AutoJoin.class);
            if(autoJoinPeriod.value()) {
                autoOperation.setPeriod(periodService.findById(aop_per_id));
            } else {
                autoOperation.setPeriod(null);
            }
            
        } catch (SQLException | ParseException | SecurityException | NoSuchFieldException ex) {
            Logger.getLogger(AutoOperationMapper.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return autoOperation;
    }
    
}
