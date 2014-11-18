/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.dao.implement;

import france.alsace.fl.money.data.component.Subtype;
import france.alsace.fl.money.data.component.Type;
import france.alsace.fl.money.data.dao.ITypeDAO;
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
public class TypeDAO implements ITypeDAO {

    @Override
    public boolean save(Type type) {
        RequestBuilder rb = new RequestBuilder();
        rb.append("INSERT INTO type(typ_text) " +
                  "VALUES (:typ_text);");

        rb.setParameter("typ_text", type.getText());
        
        return RequestExecutor.executeUpdate(rb.toString());
    }

    @Override
    public Type findById(int id) {
        RequestBuilder rb = new RequestBuilder();
        rb.append("SELECT typ_id, typ_text from type " +
                  "WHERE typ_id=:typ_id;");
        rb.setParameter("typ_id", id);
        
        ResultSet rs = RequestExecutor.executeQuery(rb.toString());
        Type type = (Type) MapperFactory.getMapper(Type.class).map(rs);
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return type;
    }

    @Override
    public List<Type> getAll() {
        List<Type> list = new ArrayList<>();
        
        RequestBuilder rb = new RequestBuilder();
        rb.append("SELECT typ_id, typ_text from type;");
        
        ResultSet rs = RequestExecutor.executeQuery(rb.toString());
        
        try {
            while(rs.next()) {
                list.add((Type) MapperFactory.getMapper(Type.class).map(rs));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Type.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }

    @Override
    public List<Type> getAll(int number, int offset) {
        List<Type> list = new ArrayList<>();
        
        RequestBuilder rb = new RequestBuilder();
        rb.append("SELECT typ_id, typ_text from type "
                + "LIMIT :count OFFSET :skip;");
        rb.setParameter("count", number);
        rb.setParameter("skip", offset);
        
        ResultSet rs = RequestExecutor.executeQuery(rb.toString());
        
        try {
            while(rs.next()) {
                list.add((Type) MapperFactory.getMapper(Type.class).map(rs));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Type.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
}
