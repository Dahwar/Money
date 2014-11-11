/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.core.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Florent
 */
public class PropertiesLoader {
    
    public static Properties properties = new Properties();
    
    public static void loadConfig(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);
            fis.close();
        } catch(IOException e) {
            System.out.println("Unable to load config file.");
        }
    }
}
