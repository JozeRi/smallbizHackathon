package heroapps.com.smallbizhackathon;

import android.app.Application;

import heroapps.com.smallbizhackathon.business.retrofit.IRetrofitCalls;
import heroapps.com.smallbizhackathon.business.retrofit.RetrofitClient;

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
  }

  private void loadRetrofit() {
    mRetrofitService = RetrofitClient.getClient().create(IRetrofitCalls.class);
  }
}
