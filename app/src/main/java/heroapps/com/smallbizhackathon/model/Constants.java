package heroapps.com.smallbizhackathon.model;

/**
 * Created by Refael Ozeri on 16/11/2016.
 */

public class Constants {

    public static final String API_SUB_KEY = "9b8e45f4c990404e873a10dfc123ac20";

    public static final String URL_GET_ACCOUNT_TRANSACTIONS = "http://bankapitest.azure-api.net/v11/accountTransactions/getAccountTransactions/9121008976501?offset=0&limit=50&version=V2";


    // --- RETROFIT RELATED CONSTANTS START ! ---

    //RETROFIT TRANSACTIONS CONSTANTS
    public static final String RETRO_VERSION = "version";

    public static final String RETRO_VALIDITY_TYPE = "validityDate";
    public static final String RETRO_VALIDITY_MONTH = "validityMonth";

    public static final String RETRO_TRANS_DATE = "transactionDate";
    public static final String RETRO_AMOUNT = "amount";
    public static final String RETRO_DEBIT = "debit";
    public static final String RETRO_MELEL = "melel";
    public static final String RETRO_TRANS_DESC = "transactionDescription";
    public static final String RETRO_INST_NAME = "institutionName";
    public static final String RETRO_COMMENT = "comment";

    ///// ACCOUNT
    public static final String RETRO_ACCOUNT = "account";
    public static final String RETRO_ACC_ID = "accountID";
    public static final String RETRO_ACC_NUM = "accountNumber";
    public static final String RETRO_ACC_NAME = "accountName";
    public static final String RETRO_ACC_TYPE_DESC = "accountTypeDescription";
    public static final String RETRO_ACC_OPEN_DATE = "accountOpenDate";

    ///// BANK
    public static final String RETRO_BANK_ID = "bankId";
    public static final String RETRO_BANK_NAME = "bankName";

    // --- RETROFIT RELATED CONSTANTS ENDS ! ---

    // JSON

    /*{
        "version": "V1.1",
            "accountID": "9121008976501",
            "validityDate": 1442361600000,
            "transactionDate": "2015-09-16",
            "valueDate": "2015-09-16",
            "transactionId": "8",
            "amount": "3.50",
            "balance": -47529.84,
            "debit": "חובה",
            "melel": "ישראכרט",
            "transactionDescription": "ישראכרט - יורוקרט",
            "institutionName": "",
            "comment": "",
            "account": {
        "accountID": "9121008976501",
                "bankId": "912",
                "bankName": "בנק הפועלים בע מ",
                "branchId": "100",
                "accountNumber": "8976501",
                "accountName": "מלכי ישראל",
                "accountTypeDescription": "חשבון עובר ושב",
                "accountOpenDate": "2000-09-01",
                "validityDate": "2015-09-30",
                "validityMonth": "201509"
    }*/




}
