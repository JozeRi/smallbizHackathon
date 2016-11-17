package heroapps.com.smallbizhackathon.business;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;

import heroapps.com.smallbizhackathon.business.listeners.IDialogListener;

/**
 * Created by Refael Ozeri on 16/11/2016.
 */

public class Utils {

  public static void displayDialog(Context ctx, String title, String msg,
                                   String positiveMsg, String negativeMsg,
                                   final IDialogListener listener) {

    AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
    builder.setTitle(title);
    builder.setMessage(msg);
    builder.setPositiveButton(positiveMsg, new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int which) {
        if (listener != null)
          listener.onPositiveClicked();
      }
    });
    if (!TextUtils.isEmpty(negativeMsg)) {
      builder.setNegativeButton(negativeMsg, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
          if (listener != null)
            listener.onNegativeClicked();
        }
      });
    }
    builder.setIcon(android.R.drawable.ic_dialog_alert);
    builder.show();
  }

}
