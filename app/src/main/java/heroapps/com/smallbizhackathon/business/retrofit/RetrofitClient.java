package heroapps.com.smallbizhackathon.business.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Refael Ozeri on 16/11/2016.
 */

public class RetrofitClient {

  public static final String BASE_URL = "http://bankapitest.azure-api.net/v11/";

  private static Retrofit retrofit = null;

  public static Retrofit getClient() {
    if (retrofit==null) {
      retrofit = new Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }
    return retrofit;
  }

}
