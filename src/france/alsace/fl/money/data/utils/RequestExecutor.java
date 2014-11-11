/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.utils;

import java.sql.ResultSet;

/**
 *
 * @author Florent
 */
public class RequestExecutor {
    
    public static boolean execute(String... requests) {     
        try {
                    
            for(String r : requests) {
                DBConnection.getStatement().execute(r);
            }
            
            return true;
            
        } catch (Exception e) {
            System.err.println("RequestExecutor.execute : " + e.getClass().getName() + " : " + e.getMessage());
            return false;
        }
    }
    
    public static boolean executeUpdate(String... requests) {        
        try {
            
            for(String r : requests) {
                DBConnection.getStatement().executeUpdate(r);
            }
            
            return true;
            
        } catch (Exception e) {
            System.err.println("RequestExecutor.executeUpdate : " + e.getClass().getName() + " : " + e.getMessage());
            for(String r : requests) {
                System.out.println(r);
            }
            return false;
        }
    }
    
    public static ResultSet executeQuery(String request) {        
        try {
            
            return DBConnection.getStatement().executeQuery(request);
            
        } catch (Exception e) {
            System.err.println("RequestExecutor.executeQuery : " + e.getClass().getName() + " : " + e.getMessage());
            return null;
        }
    }
}
