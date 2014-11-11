/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.core.utils;

/**
 *
 * @author Florent
 */
public class DBProperties {
    
    public static String fileDBName = null;
    public static String connectionDBUrl = null;

    public static void setFileDBName(String fileDBName) {
        DBProperties.fileDBName = fileDBName;
    }
    
    public static void setConnectionDBUrl(String connectionDBUrl) {
        DBProperties.connectionDBUrl = connectionDBUrl;
    }
    
    
    
}
