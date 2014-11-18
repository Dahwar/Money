/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.dao.implement;

import france.alsace.fl.money.data.component.Bank;
import france.alsace.fl.money.data.component.Operation;
import france.alsace.fl.money.data.dao.IOperationDAO;
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
public class OperationDAO implements IOperationDAO {

    @Override
    public boolean save(Operation operation) {
        RequestBuilder rb = new RequestBuilder();
        rb.append("INSERT INTO operation(ope_amount, ope_description, ope_date, ope_comment, ope_check, ope_typ_id, ope_sty_id) " +
                  "VALUES (:ope_amount, :ope_description, :ope_date, :ope_comment, :ope_check, :ope_typ_id, :ope_sty_id);");

        rb.setParameter("ope_amount", operation.getAmount());
        rb.setParameter("ope_description", operation.getDescription());
        rb.setParameter("ope_comment", operation.getComment());
        rb.setParameter("ope_check", operation.isCheck());
        rb.setParameter("ope_typ_id", operation.getType().getId());
        rb.setParameter("ope_sty_id", operation.getSubtype().getId());
        
        if(operation.getDate() == null) {
            rb.setParameterWithoutQuote("ope_date", "datetime('now','localtime')");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            rb.setParameter("ope_date",sdf.format(operation.getDate()));
        }
        
        return RequestExecutor.executeUpdate(rb.toString());
    }

    @Override
    public Operation findById(int id) {
        RequestBuilder rb = new RequestBuilder();
        rb.append("SELECT ope_id, ope_amount, ope_description, ope_date, ope_comment, ope_check, ope_typ_id, ope_sty_id from operation " +
                  "WHERE ope_id=:ope_id;");
        rb.setParameter("ope_id", id);
        
        ResultSet rs = RequestExecutor.executeQuery(rb.toString());
        Operation operation = (Operation) MapperFactory.getMapper(Operation.class).map(rs);
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(OperationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return operation;
    }

    @Override
    public List<Operation> getAll() {
        List<Operation> list = new ArrayList<>();
        
        RequestBuilder rb = new RequestBuilder();
        rb.append("SELECT ope_id, ope_amount, ope_description, ope_date, ope_comment, ope_check, ope_typ_id, ope_sty_id from operation;");
        
        ResultSet rs = RequestExecutor.executeQuery(rb.toString());
        
        try {
            while(rs.next()) {
                list.add((Operation) MapperFactory.getMapper(Operation.class).map(rs));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }

    @Override
    public List<Operation> getAll(int number, int offset) {
        List<Operation> list = new ArrayList<>();
        
        RequestBuilder rb = new RequestBuilder();
        rb.append("SELECT ope_id, ope_amount, ope_description, ope_date, ope_comment, ope_check, ope_typ_id, ope_sty_id from operation "
                + "LIMIT :count OFFSET :skip;");
        rb.setParameter("count", number);
        rb.setParameter("skip", offset);
        
        ResultSet rs = RequestExecutor.executeQuery(rb.toString());
        
        try {
            while(rs.next()) {
                list.add((Operation) MapperFactory.getMapper(Operation.class).map(rs));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
}
