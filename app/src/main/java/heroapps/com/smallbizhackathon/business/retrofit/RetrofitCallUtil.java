package heroapps.com.smallbizhackathon.business.retrofit;

import android.util.Log;

import java.util.List;

import heroapps.com.smallbizhackathon.BaseApplication;
import heroapps.com.smallbizhackathon.business.listeners.IAccountTransactions;
import heroapps.com.smallbizhackathon.model.Constants;
import heroapps.com.smallbizhackathon.model.retrofitobjects.AccountTransaction;
import heroapps.com.smallbizhackathon.model.retrofitobjects.AllAccountTransactions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Refael Ozeri on 16/11/2016.
 */

public class RetrofitCallUtil {

  private static final String TAG = RetrofitCallUtil.class.getSimpleName();

  /**
   * This method retrieves our bank account transactions
   */
  public static void getAccountTransactions(final IAccountTransactions listener) {
    BaseApplication.getInstance().getRetrofit().getAccountTransactions(Constants.BANK_API_KEY).enqueue(new Callback<List<AccountTransaction>>() {
      @Override
      public void onResponse(Call<List<AccountTransaction>> call, Response<List<AccountTransaction>> response) {
        List<AccountTransaction> transactions = response.body();

        if (transactions != null &&
              !transactions.isEmpty()) {
          listener.onSuccess(transactions);
          return;
        }

        listener.onError("Couldn't fetch AccountTransactions, Server Error");
      }
      @Override
      public void onFailure(Call<List<AccountTransaction>> call, Throwable t) {
        Log.d(TAG, t.getMessage());
        listener.onError(t.getMessage());
      }
    });
  }
//  /**
//   * Fetch all categories from server
//   * Popular categories will be marked with a specific boolean.
//   */
//  private static void fetchAllCategories() {
//    BaseApplication.getInstance().getRetrofit().sendPhoneVerification(SharedPref.getAccessToken()).enqueue(new Callback<AllCategories>() {
//      @Override
//      public void onResponse(Call<AllCategories> call, Response<AllCategories> response) {
//        if (response.body() == null) {
//          RLog.d("Failed to get Categories: %s", "body is null");
//          return;
//        }
//        if (response.body().isSuccess()) {
//          List<Category> allCategories = response.body().getCategoryList();
//          if (allCategories != null && !allCategories.isEmpty()) {
//            BaseApplication.getInstance().setLocalCategories(new ArrayList<Category>(allCategories));
//            EventManager.getInstance().publish(Constants.EVENT_CATEGORIES_UPDATED);
//          }
//        } else {
//          ErrorHandler.handleError(response.body().getErrorCode());
//        }
//      }
//      @Override
//      public void onFailure(Call<AllCategories> call, Throwable t) {
//        RLog.d("Failed to get Categories: %s", t.getMessage());
//      }
//    });
//  }

}