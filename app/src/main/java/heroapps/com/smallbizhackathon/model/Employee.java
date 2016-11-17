package heroapps.com.smallbizhackathon.model;

import io.realm.RealmObject;

/**
 * Created by lenovo on 17-Nov-16.
 */



public class Employee extends RealmObject {

    private String mName, mBankNum, mBranchNum, mAccountNum;
    private double mSalary;
    private int sessionId;


    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmBankNum() {
        return mBankNum;
    }

    public void setmBankNum(String mBankNum) {
        this.mBankNum = mBankNum;
    }

    public String getmBranchNum() {
        return mBranchNum;
    }

    public void setmBranchNum(String mBranchNum) {
        this.mBranchNum = mBranchNum;
    }

    public String getmAccountNum() {
        return mAccountNum;
    }

    public void setmAccountNum(String mAccountNum) {
        this.mAccountNum = mAccountNum;
    }

    public double getmSalary() {
        return mSalary;
    }

    public void setmSalary(double mSalary) {
        this.mSalary = mSalary;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }
}


