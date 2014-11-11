/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package france.alsace.fl.money.ihm;

import france.alsace.fl.money.core.service.IAccountService;
import france.alsace.fl.money.core.service.IAutoOperationService;
import france.alsace.fl.money.core.service.IBankService;
import france.alsace.fl.money.core.service.IOperationService;
import france.alsace.fl.money.core.service.IPeriodService;
import france.alsace.fl.money.core.service.ISubtypeService;
import france.alsace.fl.money.core.service.ITypeService;
import france.alsace.fl.money.core.service.factory.ServiceFactory;
import france.alsace.fl.money.core.utils.DBProperties;
import france.alsace.fl.money.core.utils.PropertiesLoader;
import france.alsace.fl.money.data.component.Account;
import france.alsace.fl.money.data.component.AutoOperation;
import france.alsace.fl.money.data.component.Bank;
import france.alsace.fl.money.data.component.Operation;
import france.alsace.fl.money.data.component.Period;
import france.alsace.fl.money.data.component.Subtype;
import france.alsace.fl.money.data.component.Type;
import france.alsace.fl.money.data.init.DBInit;
import france.alsace.fl.money.data.utils.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Florent
 */
public class Money extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMoney.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        System.out.println("Begin !");
        
        // get some services
        IBankService bankService = ServiceFactory.getBankInstance();
        IAccountService accountService = ServiceFactory.getAccountInstance();
        IOperationService operationService = ServiceFactory.getOperationInstance();
        ITypeService typeService = ServiceFactory.getTypeInstance();
        ISubtypeService subtypeService = ServiceFactory.getSubtypeInstance();
        IAutoOperationService autoOperationService = ServiceFactory.getAutoOperationInstance();
        IPeriodService periodService = ServiceFactory.getPeriodInstance();
        
        // load config.properties
        PropertiesLoader.loadConfig("config/config.properties");
        
        // init ConnectionProperties constant
        DBProperties.setFileDBName("money");
        DBProperties.setConnectionDBUrl(PropertiesLoader.properties.getProperty("jdbc.url")
                + ":" + DBProperties.fileDBName + "."
                + PropertiesLoader.properties.getProperty("database.extension"));
        
        //open connection
        DBConnection.open();
        
        // create DB
        DBInit.create();
        
        // Fill DB
        DBInit.fillDB();
        
        // create Bank
        Bank bank = new Bank();
        bank.setName("Crédit Agricole Centre Loire");
        bank.setAddress("Ingré, Loiret");
        bank.setComment("Test banque");

        bankService.save(bank);
        System.out.println(bankService.findById(1));
        
        // create Account
        Account account = new Account();
        account.setNumber("70053454656");
        account.setName("Dépôt à vue");
        account.setBank(bankService.findById(1));
        account.setOwner("Florent LACROIX");
        account.setAmount(20000.0);
        account.setComment("Test compte");
        account.setOpen(true);

        accountService.save(account);
        System.out.println(accountService.findById(1));
        
        // create Type
        Type type = new Type();
        type.setText("Nourriture");
        
        typeService.save(type);
        System.out.println(typeService.findById(1));
        
        // create Subtype
        Subtype subtype = new Subtype();
        subtype.setText("FastFood");
        subtype.setType(typeService.findById(1));
        
        subtypeService.save(subtype);
        System.out.println(subtypeService.findById(1));
        
        // create Operation
        Operation operation = new Operation();
        operation.setAmount(20.0);
        operation.setComment("Test Operation");
        operation.setCheck(false);
        operation.setDescription("Macdo");
        operation.setType(typeService.findById(1));
        operation.setSubtype(subtypeService.findById(1));
        
        operationService.save(operation);
        System.out.println(operationService.findById(1));
        
        // create AutoOperation
        AutoOperation autoOperation = new AutoOperation();
        autoOperation.setAmount(40.0);
        autoOperation.setComment("Test Auto Operation");
        autoOperation.setDescription("Desc auto operation");
        autoOperation.setPeriod(periodService.findById(1));
        autoOperation.setSubtype(subtypeService.findById(1));
        autoOperation.setType(typeService.findById(1));
        
        autoOperationService.save(autoOperation);
        System.out.println(autoOperationService.findById(1));
        
        // create period
        Period period = new Period();
        period.setName("Test");
        
        periodService.save(period);
        System.out.println(periodService.findById(7));
        
        DBConnection.close();
            
        System.out.println("End !");
        
    }
    
}
