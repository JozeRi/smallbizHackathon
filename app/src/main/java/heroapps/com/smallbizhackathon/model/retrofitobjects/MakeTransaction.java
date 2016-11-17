package heroapps.com.smallbizhackathon.model.retrofitobjects;

import com.google.gson.annotations.SerializedName;

import heroapps.com.smallbizhackathon.model.Constants;

/**
 * Created by Refael Ozeri on 17/11/2016.
 */

public class MakeTransaction {

  @SerializedName(Constants.RETRO_FROM_ACCOUNT)
  private BankAccount mFromAccount;

  @SerializedName(Constants.RETRO_TO_ACCOUNT)
  private BankAccount mToAccount;

  @SerializedName(Constants.RETRO_AMOUNT)
  private double mAmount;

  public BankAccount getFromAccount() {
    return mFromAccount;
  }

  public void setFromAccount(BankAccount fromAccount) {
    mFromAccount = fromAccount;
  }

  public BankAccount getToAccount() {
    return mToAccount;
  }

  public void setToAccount(BankAccount toAccount) {
    mToAccount = toAccount;
  }

  public double getAmount() {
    return mAmount;
  }

  public void setAmount(double amount) {
    mAmount = amount;
  }

}
