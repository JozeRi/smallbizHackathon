package heroapps.com.smallbizhackathon.business.services;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;

import heroapps.com.smallbizhackathon.BaseApplication;
import heroapps.com.smallbizhackathon.model.Employee;
import heroapps.com.smallbizhackathon.ui.TransactionActivity;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Refael Ozeri on 17/11/2016.
 */

public class NotificationActionService extends IntentService {

  public NotificationActionService() {
    super("ActionService");
  }

  @Override
  protected void onHandleIntent(Intent intent) {

    String action = intent.getAction();

    //get instance of realm object
    final Realm realm = Realm.getDefaultInstance();

    //get the notification id
    final int notificationId = intent.getIntExtra("NotificationId", 0);

    //sets a notification manager
    NotificationManager mNotificationManager = (NotificationManager) BaseApplication.getInstance().getSystemService(Context.NOTIFICATION_SERVICE);

    mNotificationManager.cancel(notificationId);

    switch (action) {
      case "RemindLater":
        mNotificationManager.cancel(notificationId);
        break;
      case "PayNow":
        //search the data base for the current day
        final RealmResults<Employee> employees = realm.where(Employee.class).findAll();
        Intent transIntent = TransactionActivity.getTransactionIntent(BaseApplication.getInstance(), employees.size());
        transIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        transIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        BaseApplication.getInstance().startActivity(transIntent);
        mNotificationManager.cancel(notificationId);
        break;
    }

  }
}
