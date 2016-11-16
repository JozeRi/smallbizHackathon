package heroapps.com.smallbizhackathon.model.retrofitobjects;

import com.google.gson.annotations.SerializedName;

import heroapps.com.smallbizhackathon.model.Constants;

/**
 * Created by Refael Ozeri on 16/11/2016.
 */

public class AccountTransaction {

  @SerializedName(Constants.RETRO_VERSION)
  private String mVersion;

  @SerializedName(Constants.RETRO_ACC_ID)
  private String mAccountId;

  @SerializedName(Constants.RETRO_VALIDITY_DATE)
  private long mValidityDate;

  @SerializedName(Constants.RETRO_TRANS_DATE)
  private String mTransactionDate;

  @SerializedName(Constants.RETRO_VALUE_DATE)
  private String mValueDate;

  @SerializedName(Constants.RETRO_TRANSACTION_ID)
  private String mTransactionId;

  @SerializedName(Constants.RETRO_AMOUNT)
  private String mAmount;

  @SerializedName(Constants.RETRO_BALANCE)
  private double mBalance;

  @SerializedName(Constants.RETRO_DEBIT)
  private String mDebit;

  @SerializedName(Constants.RETRO_MELEL)
  private String mMelel;

  @SerializedName(Constants.RETRO_TRANS_DESC)
  private String mTransactionDescription;

  @SerializedName(Constants.RETRO_INST_NAME)
  private String mInstitutionName;

  @SerializedName(Constants.RETRO_COMMENT)
  private String mComment;

  @SerializedName(Constants.RETRO_ACCOUNT)
  private BankAccount mAccount;

  public String getVersion() {
    return mVersion;
  }

  public void setVersion(String version) {
    mVersion = version;
  }

  public String getAccountId() {
    return mAccountId;
  }

  public void setAccountId(String accountId) {
    mAccountId = accountId;
  }

  public long getValidityDate() {
    return mValidityDate;
  }

  public void setValidityDate(long validityDate) {
    mValidityDate = validityDate;
  }

  public String getTransactionDate() {
    return mTransactionDate;
  }

  public void setTransactionDate(String transactionDate) {
    mTransactionDate = transactionDate;
  }

  public String getValueDate() {
    return mValueDate;
  }

  public void setValueDate(String valueDate) {
    mValueDate = valueDate;
  }

  public String getTransactionId() {
    return mTransactionId;
  }

  public void setTransactionId(String transactionId) {
    mTransactionId = transactionId;
  }

  public String getAmount() {
    return mAmount;
  }

  public void setAmount(String amount) {
    mAmount = amount;
  }

  public double getBalance() {
    return mBalance;
  }

  public void setBalance(double balance) {
    mBalance = balance;
  }

  public String getDebit() {
    return mDebit;
  }

  public void setDebit(String debit) {
    mDebit = debit;
  }

  public String getMelel() {
    return mMelel;
  }

  public void setMelel(String melel) {
    mMelel = melel;
  }

  public String getTransactionDescription() {
    return mTransactionDescription;
  }

  public void setTransactionDescription(String transactionDescription) {
    mTransactionDescription = transactionDescription;
  }

  public String getInstitutionName() {
    return mInstitutionName;
  }

  public void setInstitutionName(String institutionName) {
    mInstitutionName = institutionName;
  }

  public String getComment() {
    return mComment;
  }

  public void setComment(String comment) {
    mComment = comment;
  }

  public BankAccount getAccount() {
    return mAccount;
  }

  public void setAccount(BankAccount account) {
    mAccount = account;
  }
}
