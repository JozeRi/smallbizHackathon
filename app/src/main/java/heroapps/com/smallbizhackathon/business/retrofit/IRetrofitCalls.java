package heroapps.com.smallbizhackathon.business.retrofit;

import java.util.List;

import heroapps.com.smallbizhackathon.model.retrofitobjects.AccountTransaction;
import heroapps.com.smallbizhackathon.model.retrofitobjects.AllAccountTransactions;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Refael Ozeri on 16/11/2016.
 */

public interface IRetrofitCalls {

  @Headers("Content-Type:application/json;charset=UTF-8")
  @GET("accountTransactions/getAccountTransactions/9121008976501?offset=0&limit=50&version=V2")
  Call<List<AccountTransaction>> getAccountTransactions(@Header("Ocp-Apim-Subscription-Key") String token);

}
