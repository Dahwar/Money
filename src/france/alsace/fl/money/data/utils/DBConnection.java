/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.data.utils;

import france.alsace.fl.money.core.utils.DBProperties;
import france.alsace.fl.money.core.utils.PropertiesLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Florent
 */
public class DBConnection {
    private static Connection connection = null;
    private static Statement statement = null;
        
    public static Statement open() {
        if(connection == null || statement == null) {
            try {
                Class.forName(PropertiesLoader.properties.getProperty("jdbc.driver"));
                connection = DriverManager.getConnection(DBProperties.connectionDBUrl);
                statement = connection.createStatement();
                statement.execute("PRAGMA foreign_keys = ON;");
                
            } catch (Exception e) {
                System.err.println("DBConnection.open : " + e.getClass().getName() + " : " + e.getMessage());
                return null;
            }
        }
        return statement;
    }
    
    public static Statement getStatement() {
        return statement;
    }
    
    public static void close() {
        try {
            statement.close();
            connection.close();
            statement = null;
            connection = null;
        } catch (Exception e) {
            System.err.println("DBConnection.close : " + e.getClass().getName() + " : " + e.getMessage());
        }
    }
}
