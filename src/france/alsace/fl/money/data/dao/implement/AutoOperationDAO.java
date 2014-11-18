/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.dao.implement;

import france.alsace.fl.money.data.component.AutoOperation;
import france.alsace.fl.money.data.dao.IAutoOperationDAO;
import france.alsace.fl.money.data.mapper.factory.MapperFactory;
import france.alsace.fl.money.data.utils.RequestBuilder;
import france.alsace.fl.money.data.utils.RequestExecutor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florent
 */
public class AutoOperationDAO implements IAutoOperationDAO {

    @Override
    public boolean save(AutoOperation autoOperation) {
        RequestBuilder rb = new RequestBuilder();
        rb.append("INSERT INTO auto_operation(aop_amount, aop_description, aop_date_action, aop_comment, aop_typ_id, aop_sty_id, aop_per_id) " +
                  "VALUES (:aop_amount, :aop_description, :aop_date_action, :aop_comment, :aop_typ_id, :aop_sty_id, :aop_per_id);");
        
        rb.setParameter("aop_amount", autoOperation.getAmount());
        rb.setParameter("aop_description", autoOperation.getDescription());
        rb.setParameter("aop_comment", autoOperation.getComment());
        rb.setParameter("aop_typ_id", autoOperation.getType().getId());
        rb.setParameter("aop_sty_id", autoOperation.getSubtype().getId());
        rb.setParameter("aop_per_id", autoOperation.getPeriod().getId());
        
        if(autoOperation.getDateAction()== null) {
            rb.setParameterWithoutQuote("aop_date_action", "datetime('now','localtime')");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            rb.setParameter("aop_date_action",sdf.format(autoOperation.getDateAction()));
        }
        
        return RequestExecutor.executeUpdate(rb.toString());
    }

    @Override
    public AutoOperation findById(int id) {
         RequestBuilder rb = new RequestBuilder();
        rb.append("SELECT aop_id, aop_amount, aop_description, aop_date_action, aop_comment, aop_typ_id, aop_sty_id, aop_per_id from auto_operation " +
                  "WHERE aop_id=:aop_id;");
        rb.setParameter("aop_id", id);
        
        ResultSet rs = RequestExecutor.executeQuery(rb.toString());
        AutoOperation autoOperation = (AutoOperation) MapperFactory.getMapper(AutoOperation.class).map(rs);
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutoOperationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return autoOperation;
    }

    @Override
    public List<AutoOperation> getAll() {
        List<AutoOperation> list = new ArrayList<>();
        
        RequestBuilder rb = new RequestBuilder();
        rb.append("SELECT aop_id, aop_amount, aop_description, aop_date_action, aop_comment, aop_typ_id, aop_sty_id, aop_per_id from auto_operation;");
        
        ResultSet rs = RequestExecutor.executeQuery(rb.toString());
        
        try {
            while(rs.next()) {
                list.add((AutoOperation) MapperFactory.getMapper(AutoOperation.class).map(rs));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutoOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }

    @Override
    public List<AutoOperation> getAll(int number, int offset) {
        List<AutoOperation> list = new ArrayList<>();
        
        RequestBuilder rb = new RequestBuilder();
        rb.append("SELECT aop_id, aop_amount, aop_description, aop_date_action, aop_comment, aop_typ_id, aop_sty_id, aop_per_id from auto_operation "
                + "LIMIT :count OFFSET :skip;");
        rb.setParameter("count", number);
        rb.setParameter("skip", offset);
        
        ResultSet rs = RequestExecutor.executeQuery(rb.toString());
        
        try {
            while(rs.next()) {
                list.add((AutoOperation) MapperFactory.getMapper(AutoOperation.class).map(rs));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
}
