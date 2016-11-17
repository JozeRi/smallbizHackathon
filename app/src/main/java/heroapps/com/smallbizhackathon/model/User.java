package heroapps.com.smallbizhackathon.model;

/**
 * Created by Refael Ozeri on 17/11/2016.
 */

public class User {

  private String mName, mAccountNumber, mBranchNumber;

  public String getName() {
    return mName;
  }

  public void setName(String name) {
    mName = name;
  }

  public String getAccountNumber() {
    return mAccountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    mAccountNumber = accountNumber;
  }

  public String getBranchNumber() {
    return mBranchNumber;
  }

  public void setBranchNumber(String branchNumber) {
    mBranchNumber = branchNumber;
  }
}
