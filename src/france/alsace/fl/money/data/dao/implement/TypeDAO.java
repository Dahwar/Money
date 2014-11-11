/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.dao.implement;

import france.alsace.fl.money.data.component.Type;
import france.alsace.fl.money.data.dao.ITypeDAO;
import france.alsace.fl.money.data.mapper.factory.MapperFactory;
import france.alsace.fl.money.data.utils.RequestBuilder;
import france.alsace.fl.money.data.utils.RequestExecutor;
import java.sql.ResultSet;

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
        
        return (Type) MapperFactory.getMapper(Type.class).map(rs);
    }
    
}
