/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.dao.implement;

import france.alsace.fl.money.data.component.Subtype;
import france.alsace.fl.money.data.dao.ISubtypeDAO;
import france.alsace.fl.money.data.mapper.factory.MapperFactory;
import france.alsace.fl.money.data.utils.RequestBuilder;
import france.alsace.fl.money.data.utils.RequestExecutor;
import java.sql.ResultSet;

/**
 *
 * @author Florent
 */
public class SubtypeDAO implements ISubtypeDAO {

    @Override
    public boolean save(Subtype subtype) {
        RequestBuilder rb = new RequestBuilder();
        rb.append("INSERT INTO subtype(sty_text, sty_typ_id) " +
                  "VALUES (:sty_text, :sty_typ_id);");

        rb.setParameter("sty_text", subtype.getText());
        rb.setParameter("sty_typ_id", subtype.getType().getId());
        
        return RequestExecutor.executeUpdate(rb.toString());
    }

    @Override
    public Subtype findById(int id) {
        RequestBuilder rb = new RequestBuilder();
        rb.append("SELECT sty_id, sty_text, sty_typ_id from subtype " +
                  "WHERE sty_id=:sty_id;");
        rb.setParameter("sty_id", id);
        
        ResultSet rs = RequestExecutor.executeQuery(rb.toString());
        
        return (Subtype) MapperFactory.getMapper(Subtype.class).map(rs);
    }
    
}
