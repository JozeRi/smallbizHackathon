package heroapps.com.smallbizhackathon.business;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import heroapps.com.smallbizhackathon.BaseApplication;
import heroapps.com.smallbizhackathon.model.Constants;
import heroapps.com.smallbizhackathon.model.User;

/**
 * Created by Refael Ozeri on 16/11/2016.
 */

public class SharedPref {

    //initialize the shared pref.
    private static SharedPreferences mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getInstance());

    public static void saveUser(User user) {
      mSharedPreferences.edit().putString(Constants.SP_USER_NAME, user.getName()).apply();
      mSharedPreferences.edit().putString(Constants.SP_BRANCH_NUMBER, user.getBranchNumber()).apply();
      mSharedPreferences.edit().putString(Constants.SP_ACCOUNT_NUMBER, user.getAccountNumber()).apply();
    }

    public static User getUser() {
      User user = new User();
      user.setName(mSharedPreferences.getString(Constants.SP_USER_NAME, "No Name"));
      user.setBranchNumber(mSharedPreferences.getString(Constants.SP_BRANCH_NUMBER, "No Number"));
      user.setAccountNumber(mSharedPreferences.getString(Constants.SP_ACCOUNT_NUMBER, "No Number"));
      return user;
    }

  public static void setSignedStatus(boolean isSigned) {
    mSharedPreferences.edit().putBoolean(Constants.SP_IS_SIGNED, isSigned).apply();
  }

  public static boolean isSigned() {
    return mSharedPreferences.getBoolean(Constants.SP_IS_SIGNED, false);
  }
}
