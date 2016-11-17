package heroapps.com.smallbizhackathon.business.rafanotification;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Refael Ozeri on 7/27/15.
 */
public class RefaelsNotificationBuilder {

  // A fixed dedicated ID sets only 1 notification per app.
  // if you want several pushes that won't override one another
  // create a random id every time
  //public static final int NOTIFICATION_ID = randomId();

  // notification manager
  private NotificationManager mNotificationManager;

  public void sendNotification(RefaelsNotification notification, Context ctx, Class<? extends Activity> intentActivity, int icon) {
    sendNotification(notification, ctx, intentActivity, new ArrayList<RefaelsNotificationAction>(), icon, randomId());
  }

  public void sendNotification(RefaelsNotification notification, Context ctx, Class<? extends Activity> intentActivity, @Nullable ArrayList<RefaelsNotificationAction> actions, int icon, int id) {

    //if no sound given - sets the default notification sound.
    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

    sendNotification(notification, ctx, intentActivity, actions, alarmSound, icon, id);
  }

  public void sendNotification(RefaelsNotification notification, Context ctx, Class<? extends Activity> intentActivity, @Nullable ArrayList<RefaelsNotificationAction> actions, Uri alarmSound, int icon, int id) {

    mNotificationManager = (NotificationManager)
        ctx.getSystemService(Context.NOTIFICATION_SERVICE);

    Intent intent = new Intent(ctx, intentActivity);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

    PendingIntent contentIntent = PendingIntent.getActivity(ctx, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

    /**
     * "\u200E\u200E\u200E" is Unicode char that sets the text alignment from the left!
     */

    NotificationCompat.Builder mBuilder =
        new NotificationCompat.Builder(ctx)
            .setSmallIcon(icon)
            .setContentTitle("SmallBiz - The Best App Ever!" /**ctx.getResources().getString(R.string.app_name)*/)
            .setStyle(new NotificationCompat.BigTextStyle()
                .bigText("‎‎‎\u200E\u200E\u200E‎‎‎‎‎‎‎‎‎‎‎‎‎‎‎‎‎‎‎‎‎‎‎‎" + notification.getExpandText()))
            .setTicker("\u200E\u200E\u200E" + notification.getTicker())
            .setAutoCancel(true)
            //.setOngoing(true)
            .setSound(alarmSound)
            .setContentText("\u200E\u200E\u200E" + notification.getCollapsedText())
            .setPriority(NotificationCompat.PRIORITY_MAX);
    //.setVibrate(new long[0]);

    if (actions != null) {
      for (int i = 0; i < actions.size(); i++) {
        mBuilder.addAction(actions.get(i).getIcon(), actions.get(i).getTitle(), actions.get(i).getPendingIntent());
      }
    }

//        int NOTIFICATION_ID = randomId();

    mBuilder.setContentIntent(contentIntent);
    mNotificationManager.notify(id, mBuilder.build());
  }

  /** generates random notification id from current date, use when need random id */
  private int randomId() {
    long time = new Date().getTime();
    String tmpStr = String.valueOf(time);
    String last4Str = tmpStr.substring(tmpStr.length() - 5);

    return Integer.valueOf(last4Str);
  }

}