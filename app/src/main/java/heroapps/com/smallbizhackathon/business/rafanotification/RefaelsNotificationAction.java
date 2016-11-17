package heroapps.com.smallbizhackathon.business.rafanotification;

import android.app.PendingIntent;

/**
 * Created by Refael Ozeri on 7/27/15.
 */
public class RefaelsNotificationAction {

  private int icon;
  private CharSequence title;
  private PendingIntent pendingIntent;

  public RefaelsNotificationAction(int icon, CharSequence title, PendingIntent pendingIntent) {
    this.icon = icon;
    this.title = title;
    this.pendingIntent = pendingIntent;
  }

  public PendingIntent getPendingIntent() {
    return pendingIntent;
  }

  public void setPendingIntent(PendingIntent pendingIntent) {
    this.pendingIntent = pendingIntent;
  }

  public int getIcon() {
    return icon;
  }

  public void setIcon(int icon) {
    this.icon = icon;
  }

  public CharSequence getTitle() {
    return title;
  }

  public void setTitle(CharSequence title) {
    this.title = title;
  }
}