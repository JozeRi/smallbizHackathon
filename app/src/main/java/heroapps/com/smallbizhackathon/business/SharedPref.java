package heroapps.com.smallbizhackathon.business;

import android.content.SharedPreferences;

import heroapps.com.smallbizhackathon.model.Constants;

/**
 * Created by Refael Ozeri on 16/11/2016.
 */

public class SharedPref {

    static SharedPreferences pref;
    static SharedPreferences.Editor editor;

    public static void writeToSharedPref(int REQ_ID, int num) {

        //pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();

        switch (REQ_ID) {
            case Constants.SP_REQ_ID_ACC_NUM:
                editor.putInt("acc_num", num);
                break;
            case Constants.SP_REQ_ID_BRANCH_NUM:
                editor.putInt("branch_num", num);
                break;
        }

        editor.putBoolean("isSigned", true);

        editor.apply();
    }

    private static int getDataFromSharedPref(int REQ_ID) {

        switch (REQ_ID) {
            case Constants.SP_REQ_ID_ACC_NUM:
                return pref.getInt("acc_num", 0);
            case Constants.SP_REQ_ID_BRANCH_NUM:
                return pref.getInt("branch_num", 0);
        }

        return -1;
    }

    public static boolean isSigned(){
        return pref.getBoolean("isSigned", false);
    }


    /*public static boolean isSigned = false;
    public static String accountId = "";

    public static boolean getIsSigned() {
        return isSigned;
    }

    public static void setIsSigned(boolean isSigned) {
        SharedPref.isSigned = isSigned;
    }

    public static String getAccountId() {
        return accountId;
    }

    public static void setAccountId(String branchNum, String accountNum) {

        //constant of bank number

        SharedPref.accountId = Constants.BANK_ID + branchNum + accountNum;

    }*/
}
