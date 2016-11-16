package heroapps.com.smallbizhackathon.business.retrofit;

/**
 * Created by Refael Ozeri on 16/11/2016.
 */

public class RetrofitCallUtil {

//  /**
//   * Fetch all categories from server
//   * Popular categories will be marked with a specific boolean.
//   */
//  private static void fetchAllCategories() {
//    BaseApplication.getInstance().getRetrofit().getAllCategories(SharedPref.getAccessToken()).enqueue(new Callback<AllCategories>() {
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
