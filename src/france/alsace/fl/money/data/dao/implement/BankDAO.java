/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.dao.implement;

import france.alsace.fl.money.data.component.Bank;
import france.alsace.fl.money.data.dao.IBankDAO;
import france.alsace.fl.money.data.mapper.factory.MapperFactory;
import france.alsace.fl.money.data.utils.RequestBuilder;
import france.alsace.fl.money.data.utils.RequestExecutor;
import java.sql.ResultSet;

/**
 *
 * @author Florent
 */
public class BankDAO implements IBankDAO {

    @Override
    public boolean save(Bank bank) {
                    
        RequestBuilder rb = new RequestBuilder();
        rb.append("INSERT INTO bank(bnk_name, bnk_address, bnk_comment) " +
                  "VALUES (:bnk_name, :bnk_address, :bnk_comment);");

        rb.setParameter("bnk_name", bank.getName());
        rb.setParameter("bnk_address", bank.getAddress());
        rb.setParameter("bnk_comment", bank.getComment());

        return RequestExecutor.executeUpdate(rb.toString());      
    }

    @Override
    public Bank findById(int id) {
        RequestBuilder rb = new RequestBuilder();
        rb.append("SELECT bnk_id, bnk_name, bnk_address, bnk_comment from bank " +
                  "WHERE bnk_id=:bnk_id;");
        rb.setParameter("bnk_id", id);
        
        ResultSet rs = RequestExecutor.executeQuery(rb.toString());
        
        return (Bank) MapperFactory.getMapper(Bank.class).map(rs);

    }
}
