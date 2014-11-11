package france.alsace.fl.money.data.init;

import france.alsace.fl.money.data.utils.RequestBuilder;
import france.alsace.fl.money.data.utils.RequestExecutor;

/**
 *
 * @author Florent
 */
public class DBInit {
    
    public static boolean create() {

        String createBankTableSQL = "CREATE TABLE bank "
                + "(bnk_id      INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + " bnk_name    TEXT                              NOT NULL,"
                + " bnk_address TEXT,"
                + " bnk_comment TEXT);";

        String createAccountTableSQL = "CREATE TABLE account "
                + "(act_id            INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + " act_number        INTEGER                           NOT NULL,"
                + " act_name          TEXT                              NOT NULL,"
                + " act_bnk_id        INTEGER                           NOT NULL,"
                + " act_owner         TEXT                              NOT NULL,"
                + " act_amount        REAL                              NOT NULL,"
                + " act_creation_date TEXT                              NOT NULL,"
                + " act_comment       TEXT,"
                + " act_open          INTEGER                           NOT NULL,"
                + " FOREIGN KEY(act_bnk_id) REFERENCES bank(bnk_id));";

        String createOperationTableSQL = "CREATE TABLE operation "
                + "(ope_id          INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + " ope_amount      REAL                              NOT NULL,"
                + " ope_description TEXT                              NOT NULL,"
                + " ope_date        TEXT                              NOT NULL,"
                + " ope_comment     TEXT,"
                + " ope_check       TEXT                              NOT NULL,"
                + " ope_typ_id      INTEGER                           NOT NULL,"
                + " ope_sty_id      INTEGER,"
                + " FOREIGN KEY(ope_typ_id) REFERENCES type(typ_id),"
                + " FOREIGN KEY(ope_sty_id) REFERENCES subtype(sty_id));";

        String createTypeTableSQL = "CREATE TABLE type "
                + "(typ_id   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + " typ_text TEXT                              NOT NULL);";

        String createSubtypeTableSQL = "CREATE TABLE subtype "
                + "(sty_id     INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + " sty_text   TEXT                              NOT NULL,"
                + " sty_typ_id INTEGER                           NOT NULL,"
                + " FOREIGN KEY(sty_typ_id) REFERENCES type(typ_id));";

        String createAutoOperationTableSQL = "CREATE TABLE auto_operation "
                + "(aop_id          INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + " aop_amount      REAL                              NOT NULL,"
                + " aop_description TEXT                              NOT NULL,"
                + " aop_date_action TEXT                              NOT NULL,"
                + " aop_comment     TEXT,"
                + " aop_typ_id      INTEGER                           NOT NULL,"
                + " aop_sty_id      INTEGER,"
                + " aop_per_id      INTEGER                           NOT NULL,"
                + " FOREIGN KEY(aop_typ_id) REFERENCES type(typ_id),"
                + " FOREIGN KEY(aop_sty_id) REFERENCES subtype(sty_id),"
                + " FOREIGN KEY(aop_per_id) REFERENCES period(per_id));";

        String createPeriodTableSQL = "CREATE TABLE period "
                + "(per_id   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + " per_name TEXT                              NOT NULL);";

        StringBuilder createIndexSQL = new StringBuilder();
        createIndexSQL.append("CREATE INDEX idx_fk_act_bnk_id ON account(act_bnk_id);");
        createIndexSQL.append("CREATE INDEX idx_fk_ope_typ_id ON operation(ope_typ_id);");
        createIndexSQL.append("CREATE INDEX idx_fk_ope_sty_id ON operation(ope_sty_id);");
        createIndexSQL.append("CREATE INDEX idx_fk_sty_typ_id ON subtype(sty_typ_id);");
        createIndexSQL.append("CREATE INDEX idx_fk_aop_typ_id ON auto_operation(aop_typ_id);");
        createIndexSQL.append("CREATE INDEX idx_fk_aop_sty_id ON auto_operation(aop_sty_id);");
        createIndexSQL.append("CREATE INDEX idx_fk_aop_per_id ON auto_operation(aop_per_id);");

        StringBuilder sb = new StringBuilder();
        sb.append(createBankTableSQL);
        sb.append(createAccountTableSQL);
        sb.append(createOperationTableSQL);
        sb.append(createTypeTableSQL);
        sb.append(createSubtypeTableSQL);
        sb.append(createAutoOperationTableSQL);
        sb.append(createPeriodTableSQL);
        sb.append(createIndexSQL);

        return RequestExecutor.executeUpdate(sb.toString());
    }
    
    public static boolean fillDB() {
                   
        StringBuilder sb = new StringBuilder();
        RequestBuilder rb = new  RequestBuilder();

        String[] list = {"Journalière", "Hebdomadaire", "Mensuelle", "Trimestrielle", "Semestrielle", "Annuelle"};

        for(String s : list) {
            rb.append("INSERT INTO period(per_name) VALUES (:per_name);");
            rb.setParameter("per_name", s);
            sb.append(rb.toString());
            rb.clear();
        }

        return RequestExecutor.executeUpdate(sb.toString());

    }
}
