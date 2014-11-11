/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.mapper.implement;

import france.alsace.fl.money.data.component.Bank;
import france.alsace.fl.money.data.mapper.IMapper;
import france.alsace.fl.money.data.utils.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florent
 */
public class BankMapper implements IMapper<Bank> {

    @Override
    public Bank map(ResultSet rs) {
        Bank bank = new Bank();
        try {
            bank.setId(rs.getInt("bnk_id"));
            bank.setName(rs.getString("bnk_name"));
            bank.setAddress(rs.getString("bnk_address"));
            bank.setComment(rs.getString("bnk_comment"));
            
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(BankMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bank;
    }
}
