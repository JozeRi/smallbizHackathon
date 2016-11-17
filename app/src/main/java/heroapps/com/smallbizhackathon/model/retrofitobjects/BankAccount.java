package heroapps.com.smallbizhackathon.model.retrofitobjects;

import com.google.gson.annotations.SerializedName;

import heroapps.com.smallbizhackathon.model.Constants;

/**
 * Created by Refael Ozeri on 16/11/2016.
 */

public class BankAccount {

  @SerializedName(Constants.RETRO_ACC_ID)
  private String mAccountId;

  @SerializedName(Constants.RETRO_BANK_ID)
  private String mBankId;

  @SerializedName(Constants.RETRO_TRANS_BANK_ID)
  private String mTransBankId;

  @SerializedName(Constants.RETRO_BANK_NAME)
  private String mBankName;

  @SerializedName(Constants.RETRO_TRANS_BRANCH_ID)
  private String mTransBranchId;

  @SerializedName(Constants.RETRO_BRANCH_ID)
  private String mBranchId;

  @SerializedName(Constants.RETRO_ACC_NUM)
  private String mAccountNumber;

  @SerializedName(Constants.RETRO_ACC_NAME)
  private String mAccountName;

  @SerializedName(Constants.RETRO_ACC_TYPE_DESC)
  private String mAccountTypeDescription;

  @SerializedName(Constants.RETRO_ACC_OPEN_DATE)
  private String mAccountOpenDate;

  @SerializedName(Constants.RETRO_VALIDITY_DATE)
  private String mValidityDate;

  @SerializedName(Constants.RETRO_VALIDITY_MONTH)
  private String mValidityMonth;

  public String getAccountId() {
    return mAccountId;
  }

  public void setAccountId(String accountId) {
    mAccountId = accountId;
  }

  public String getBankId() {
    return mBankId;
  }

  public void setBankId(String bankId) {
    mBankId = bankId;
  }

  public String getBankName() {
    return mBankName;
  }

  public void setBankName(String bankName) {
    mBankName = bankName;
  }

  public String getBranchId() {
    return mBranchId;
  }

  public void setBranchId(String branchId) {
    mBranchId = branchId;
  }

  public String getAccountNumber() {
    return mAccountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    mAccountNumber = accountNumber;
  }

  public String getAccountName() {
    return mAccountName;
  }

  public void setAccountName(String accountName) {
    mAccountName = accountName;
  }

  public String getAccountTypeDescription() {
    return mAccountTypeDescription;
  }

  public void setAccountTypeDescription(String accountTypeDescription) {
    mAccountTypeDescription = accountTypeDescription;
  }

  public String getAccountOpenDate() {
    return mAccountOpenDate;
  }

  public void setAccountOpenDate(String accountOpenDate) {
    mAccountOpenDate = accountOpenDate;
  }

  public String getValidityDate() {
    return mValidityDate;
  }

  public void setValidityDate(String validityDate) {
    mValidityDate = validityDate;
  }

  public String getValidityMonth() {
    return mValidityMonth;
  }

  public void setValidityMonth(String validityMonth) {
    mValidityMonth = validityMonth;
  }
}
