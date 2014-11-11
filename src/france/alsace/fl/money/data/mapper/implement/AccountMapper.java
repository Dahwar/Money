/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.mapper.implement;

import france.alsace.fl.money.core.service.IBankService;
import france.alsace.fl.money.core.service.factory.ServiceFactory;
import france.alsace.fl.money.data.component.Account;
import france.alsace.fl.money.data.component.Bank;
import france.alsace.fl.money.data.mapper.IMapper;
import france.alsace.fl.money.data.utils.DBConnection;
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
public class AccountMapper implements IMapper<Account> {
    
    private IBankService bankService = ServiceFactory.getBankInstance();
    
    @Override
    public Account map(ResultSet rs) {
        Account account = new Account();
        try {
            
            account.setId(rs.getInt("act_id"));
            account.setNumber(rs.getString("act_number"));
            account.setName(rs.getString("act_name"));
            account.setOwner(rs.getString("act_owner"));
            account.setAmount(rs.getDouble("act_amount"));
            account.setCreationDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("act_creation_date")));
            account.setComment(rs.getString("act_comment"));
            account.setOpen(rs.getBoolean("act_open"));
            
            int act_bnk_id = rs.getInt("act_bnk_id");
            
            AutoJoin autoJoin = Account.class.getDeclaredField("bank").getAnnotation(AutoJoin.class);
            if(autoJoin.value()) {
                account.setBank(bankService.findById(act_bnk_id));
            } else {
                account.setBank(null);
            }
            
            rs.close();
            
        } catch (SQLException | ParseException | NoSuchFieldException | SecurityException ex) {
            Logger.getLogger(AccountMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return account;
    }
}
