/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.dao.implement;

import france.alsace.fl.money.data.component.Account;
import france.alsace.fl.money.data.dao.IAccountDAO;
import france.alsace.fl.money.data.mapper.factory.MapperFactory;
import france.alsace.fl.money.data.utils.RequestBuilder;
import france.alsace.fl.money.data.utils.RequestExecutor;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

/**
 *
 * @author Florent
 */
public class AccountDAO implements IAccountDAO {

    @Override
    public boolean save(Account account) {
        RequestBuilder rb = new RequestBuilder();
        rb.append("INSERT INTO account(act_number, act_name, act_bnk_id, act_owner, act_amount, act_creation_date, act_comment, act_open) " +
                   "VALUES (:act_number, :act_name, :act_bnk_id, :act_owner, :act_amount, :act_creation_date, :act_comment, :act_open);");

        rb.setParameter("act_number", account.getNumber());
        rb.setParameter("act_name", account.getName());
        rb.setParameter("act_bnk_id", account.getBank().getId());
        rb.setParameter("act_owner", account.getOwner());
        rb.setParameter("act_amount", account.getAmount());
        if(account.getCreationDate() == null) {
            rb.setParameterWithoutQuote("act_creation_date", "datetime('now','localtime')");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            rb.setParameter("act_creation_date",sdf.format(account.getCreationDate()));
        }
        rb.setParameter("act_comment", account.getComment());
        rb.setParameter("act_open", account.isOpen());
        
        return RequestExecutor.executeUpdate(rb.toString());
    }

    @Override
    public Account findById(int id) {
        RequestBuilder rb = new RequestBuilder();
        rb.append("SELECT act_id, act_number, act_name, act_bnk_id, act_owner, act_amount, act_creation_date, act_comment, act_open from account " +
                  "WHERE act_id=:act_id;");
        rb.setParameter("act_id", id);
        
        ResultSet rs = RequestExecutor.executeQuery(rb.toString());
        
        return (Account) MapperFactory.getMapper(Account.class).map(rs);
    }
    
}
