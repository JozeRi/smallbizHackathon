package heroapps.com.smallbizhackathon.business.listeners;

import java.util.List;

import heroapps.com.smallbizhackathon.model.retrofitobjects.AccountTransaction;

/**
 * Created by Refael Ozeri on 16/11/2016.
 */

public interface IAccountTransactions extends INetworkError {
  void onSuccess(List<AccountTransaction> accountTransactions);
}
