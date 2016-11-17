package heroapps.com.smallbizhackathon.business;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Date;

import heroapps.com.smallbizhackathon.BaseApplication;
import heroapps.com.smallbizhackathon.R;
import heroapps.com.smallbizhackathon.business.listeners.IDialogListener;
import heroapps.com.smallbizhackathon.business.rafanotification.RefaelsNotification;
import heroapps.com.smallbizhackathon.business.rafanotification.RefaelsNotificationAction;
import heroapps.com.smallbizhackathon.business.rafanotification.RefaelsNotificationBuilder;
import heroapps.com.smallbizhackathon.model.Constants;
import heroapps.com.smallbizhackathon.ui.TransactionActivity;

/**
 * Created by Refael Ozeri on 16/11/2016.
 */

public class Utils {

  /** create a push notification build */
  public static void createLocalNotification(String ticker, @Nullable String expanded, String collapsed, Context ctx) {
    RefaelsNotification notification = new RefaelsNotification(ticker, expanded, collapsed);

    ArrayList<RefaelsNotificationAction> actions = new ArrayList<RefaelsNotificationAction>();

    final int NOTIFICATION_ID = randomId();

    Intent remindLaterIntent = new Intent("RemindLater");
//    remindLaterIntent.putExtra(TeamiConstants.teaTypeEnum, teaType);
//    remindLaterIntent.putExtra(TeamiConstants.daysPassed, TeamiUtils.getDaysPassed());
    remindLaterIntent.putExtra("NotificationId", NOTIFICATION_ID);
    PendingIntent pendingSnoozeIntent = PendingIntent.getService(BaseApplication.getInstance(), NOTIFICATION_ID, remindLaterIntent, 0); //getBroadcast(BaseApplication.getAppContext(), 0, snoozeIntent, 0);

    Intent payNowIntent = new Intent("PayNow");
    payNowIntent.putExtra("NotificationId", NOTIFICATION_ID);
    PendingIntent pendingDrinkIntent = PendingIntent.getService(BaseApplication.getInstance(), NOTIFICATION_ID, payNowIntent, 0);

    RefaelsNotificationAction snooze = new RefaelsNotificationAction(R.mipmap.ic_launcher, "מאוחר יותר", pendingSnoozeIntent);
    RefaelsNotificationAction drinking = new RefaelsNotificationAction(R.mipmap.ic_launcher, "שלם עכשיו", pendingDrinkIntent);

    actions.add(drinking);
    actions.add(snooze);

    RefaelsNotificationBuilder builder = new RefaelsNotificationBuilder();
    builder.sendNotification(notification, ctx, TransactionActivity.class, actions, R.mipmap.ic_launcher, NOTIFICATION_ID);
  }

  /** generates random notification id from current date, use when need random id */
  private static int randomId() {
    long time = new Date().getTime();
    String tmpStr = String.valueOf(time);
    String last4Str = tmpStr.substring(tmpStr.length() - 5);

    return Integer.valueOf(last4Str);
  }

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
