package heroapps.com.smallbizhackathon.model.retrofitobjects;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Refael Ozeri on 16/11/2016.
 */

public class AllAccountTransactions {

  @SerializedName("")
  private List<AccountTransaction> mAccountTransactions;

  public List<AccountTransaction> getAccountTransactions() {
    return mAccountTransactions;
  }

  public void setAccountTransactions(List<AccountTransaction> accountTransactions) {
    mAccountTransactions = accountTransactions;
  }
}
