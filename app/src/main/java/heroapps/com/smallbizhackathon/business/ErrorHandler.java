package heroapps.com.smallbizhackathon.business;

import android.widget.Toast;

import heroapps.com.smallbizhackathon.BaseApplication;

/**
 * Created by Refael Ozeri on 16/11/2016.
 */

public class ErrorHandler {

  private static final int ERROR_NO_INTERNET = 100;

  public static void handleError(int errorCode) {
    switch (errorCode) {
      case ERROR_NO_INTERNET:
        Toast.makeText(BaseApplication.getInstance(), "No Internet", Toast.LENGTH_SHORT).show();
        break;
      default:
        break;
    }
  }

}