package heroapps.com.smallbizhackathon;

import android.app.Application;
import android.util.Log;

import java.util.List;

import heroapps.com.smallbizhackathon.business.listeners.IAccountTransactions;
import heroapps.com.smallbizhackathon.business.retrofit.IRetrofitCalls;
import heroapps.com.smallbizhackathon.business.retrofit.RetrofitCallUtil;
import heroapps.com.smallbizhackathon.business.retrofit.RetrofitClient;
import heroapps.com.smallbizhackathon.model.retrofitobjects.AccountTransaction;
import heroapps.com.smallbizhackathon.model.retrofitobjects.AllAccountTransactions;

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

  private void fetchAccountTransactions() {
    RetrofitCallUtil.getAccountTransactions(new IAccountTransactions() {
      @Override
      public void onSuccess(List<AccountTransaction> accountTransactions) {
        Log.d("", accountTransactions.toString());
      }

      @Override
      public void onError(String error) {
        Log.d("", error);
      }
    });
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
