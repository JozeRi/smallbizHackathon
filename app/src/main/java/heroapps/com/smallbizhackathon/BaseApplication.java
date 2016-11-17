package heroapps.com.smallbizhackathon;

import android.app.Application;

import heroapps.com.smallbizhackathon.business.retrofit.IRetrofitCalls;
import heroapps.com.smallbizhackathon.business.retrofit.RetrofitClient;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Refael Ozeri on 16/11/2016.
 */

public class BaseApplication extends Application {

  private static IRetrofitCalls mRetrofitService;

  private static BaseApplication singleton;
  public static BaseApplication getInstance() {
    return singleton;
  }

  @Override
  public void onCreate() {
    super.onCreate();

    singleton = this;

    loadRetrofit();

    Realm.init(this);
    RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
    Realm.setDefaultConfiguration(realmConfiguration);

  }

  private void loadRetrofit() {
    mRetrofitService = RetrofitClient.getClient().create(IRetrofitCalls.class);
  }

  public IRetrofitCalls getRetrofit() {
    if (mRetrofitService == null) {
      loadRetrofit();
    }
    return mRetrofitService;
  }

}
