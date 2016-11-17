package heroapps.com.smallbizhackathon.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import heroapps.com.smallbizhackathon.BaseApplication;
import heroapps.com.smallbizhackathon.R;
import heroapps.com.smallbizhackathon.business.Utils;
import heroapps.com.smallbizhackathon.business.listeners.IDialogListener;
import heroapps.com.smallbizhackathon.model.Employee;
import heroapps.com.smallbizhackathon.ui.recyclerview.ClickListener;
import heroapps.com.smallbizhackathon.ui.recyclerview.RecyclerTouchListener;
import io.realm.Realm;
import io.realm.RealmResults;

public class EmployeesActivity extends AppCompatActivity implements View.OnClickListener {

  private TransitionManager mTransitionManager;
  private Scene mExpandedAddEmployeeScene;
  private Scene mBaseScene;
  private Scene mCurrentScene;

  private ViewGroup mTransitionRoot;

  private EditText mName, mBankNum, mBranchNum, mAccountNum, mSalary;

  private TextView mAddNewEmployeeBtn;

  private ArrayList<Employee> mEmployees = new ArrayList<>();

  private Realm mRealm;

  private RecyclerView mRecyclerView; //advertisements recyclerView
  private RecyclerView.Adapter mAdapter;
  private RecyclerView.LayoutManager mLayoutManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_paychecks);

    initViews();
    mCurrentScene = mBaseScene;
    setupTransitions();

    mRealm = Realm.getDefaultInstance();

    if (mRealm == null) return;
    RealmResults<Employee> results = mRealm.where(Employee.class).findAll();
    if (!results.isEmpty()) {
      updateEmployees();
    }

  }

  private void initViews() {
    mTransitionRoot = (ViewGroup) findViewById(R.id.detail_container);

    mName = (EditText) findViewById(R.id.paychecks_et_employee_name);
    mBankNum = (EditText) findViewById(R.id.paychecks_et_bank_num);
    mBranchNum = (EditText) findViewById(R.id.paychecks_et_branch_num);
    mAccountNum = (EditText) findViewById(R.id.paychecks_et_account_num);
    mSalary = (EditText) findViewById(R.id.paychecks_et_salary);

    mAddNewEmployeeBtn = (TextView) findViewById(R.id.paychecks_add_new_employee_btn);
    mAddNewEmployeeBtn.setOnClickListener(this);

    initRecyclerView();

    if (mSalary == null) {
      return;
    }

    mSalary.setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        if (mName.getText().length()<2){
          mName.setText("");
          mName.setHint("הכנס את שם העובד");
          mName.setHintTextColor(Color.RED);
        }else if (mBankNum.getText().length()<2){
          mBankNum.setText("");
          mBankNum.setHint("הכנס מספר בנק");
          mBankNum.setHintTextColor(Color.RED);
        }else if (mBranchNum.getText().length()<3){
          mBranchNum.setText("");
          mBranchNum.setHint("הכנס את מספר הסניף");
          mBranchNum.setHintTextColor(Color.RED);
        }else if (mAccountNum.getText().length()<2){
          mAccountNum.setText("");
          mAccountNum.setHint("הכנס את מספר החשבון");
          mAccountNum.setHintTextColor(Color.RED);
        }else if (mSalary.getText().length()<1){
          mSalary.setText("");
          mSalary.setHint("הכנס את המשכורת");
          mSalary.setHintTextColor(Color.RED);
        }else {

          mRealm.beginTransaction();
          Employee employee = mRealm.createObject(Employee.class);
          employee.setmName(mName.getText().toString());
          employee.setmBankNum(mBankNum.getText().toString());
          employee.setmBranchNum(mBranchNum.getText().toString());
          employee.setmAccountNum(mAccountNum.getText().toString());
          employee.setmSalary(Double.parseDouble(mSalary.getText().toString()));
          mRealm.commitTransaction();

          onNewEmployeeClicked();
        }
        return false;
      }
    });
  }

  private void updateEmployees() {

    if (mRealm == null) return;
    RealmResults<Employee> results = mRealm.where(Employee.class).findAll();
    if (results.isEmpty()) {
      return;
    }

    mEmployees = new ArrayList<>(results);
    // use this setting to improve performance if you know that changes
    // in content do not change the layout size of the RecyclerView
    mRecyclerView.setHasFixedSize(true);

    // linear layout manager
    mLayoutManager = new LinearLayoutManager(EmployeesActivity.this);
    mRecyclerView.setLayoutManager(mLayoutManager);

    mAdapter = new EmployeesAdapter();
    mRecyclerView.setAdapter(mAdapter);
  }

  private void initRecyclerView() {
    mRecyclerView = (RecyclerView) findViewById(R.id.employees_recycler_view);

    mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(BaseApplication.getInstance(), mRecyclerView, new ClickListener() {
      @Override
      public void onClick(View view, int position) {
      }
      @Override
      public void onLongClick(View view, final int position) {

        Utils.displayDialog(EmployeesActivity.this, "מחיקת עובד",
            "האם אתה בטוח שברצונך למחוק את "+mEmployees.get(position).getmName()+"?",
            "כן",
            "ביטול",
            new IDialogListener() {
          @Override
          public void onPositiveClicked() {
            mRealm.beginTransaction();
            mEmployees.get(position).deleteFromRealm();
            mRealm.commitTransaction();
            mEmployees.remove(position);
            updateEmployees();
          }
          @Override
          public void onNegativeClicked() {

          }
        });
      }
    }));
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mRealm.close();
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.paychecks_add_new_employee_btn:
        onNewEmployeeClicked();
        break;
    }
  }

  private void onNewEmployeeClicked() {
    if (mCurrentScene == mExpandedAddEmployeeScene) {
      mCurrentScene = mBaseScene;
    } else {
      mCurrentScene = mExpandedAddEmployeeScene;
    }
    mTransitionManager.transitionTo(mCurrentScene);
  }

  private void setupTransitions() {
//        Slide slide = new Slide(Gravity.BOTTOM);
//        slide.excludeTarget(android.R.id.statusBarBackground, true);
//        getWindow().setEnterTransition(slide);
//        getWindow().setSharedElementsUseOverlay(false);

    mTransitionManager = new TransitionManager();

    // Expanded scene
    mExpandedAddEmployeeScene = Scene.getSceneForLayout(mTransitionRoot,
        R.layout.activity_paychecks_employee_expanded, this);

    mExpandedAddEmployeeScene.setEnterAction(new Runnable() {
      @Override
      public void run() {
        initViews();
        mCurrentScene = mExpandedAddEmployeeScene;
        updateEmployees();
      }
    });

    int fadeSpeed = 100;
    int durationSpeed = 300;

    TransitionSet expandTransitionSet = new TransitionSet();
    expandTransitionSet.setOrdering(TransitionSet.ORDERING_SEQUENTIAL);
    ChangeBounds changeBounds = new ChangeBounds();
    changeBounds.setDuration(durationSpeed);
    expandTransitionSet.addTransition(changeBounds);

    Fade fadeLyrics1 = new Fade();
    fadeLyrics1.setInterpolator(new AccelerateInterpolator());
    fadeLyrics1.addTarget(R.id.paychecks_et_employee_name);
    fadeLyrics1.setDuration(fadeSpeed);
    expandTransitionSet.addTransition(fadeLyrics1);

    Fade fadeLyrics2 = new Fade();
    fadeLyrics1.setInterpolator(new AccelerateInterpolator());
    fadeLyrics2.addTarget(R.id.paychecks_et_bank_num);
    fadeLyrics2.setDuration(fadeSpeed);
    expandTransitionSet.addTransition(fadeLyrics2);

    Fade fadeLyrics3 = new Fade();
    fadeLyrics1.setInterpolator(new AccelerateInterpolator());
    fadeLyrics3.addTarget(R.id.paychecks_et_branch_num);
    fadeLyrics3.setDuration(fadeSpeed);
    expandTransitionSet.addTransition(fadeLyrics3);

    Fade fadeLyrics4 = new Fade();
    fadeLyrics1.setInterpolator(new AccelerateInterpolator());
    fadeLyrics4.addTarget(R.id.paychecks_et_account_num);
    fadeLyrics4.setDuration(fadeSpeed);
    expandTransitionSet.addTransition(fadeLyrics4);

    Fade fadeLyrics5 = new Fade();
    fadeLyrics1.setInterpolator(new AccelerateInterpolator());
    fadeLyrics5.addTarget(R.id.paychecks_et_salary);
    fadeLyrics5.setDuration(fadeSpeed);
    expandTransitionSet.addTransition(fadeLyrics5);

    // Collapsed scene
    mBaseScene = Scene.getSceneForLayout(mTransitionRoot,
        R.layout.activity_paychecks, this);

    mBaseScene.setEnterAction(new Runnable() {
      @Override
      public void run() {
        initViews();
        mCurrentScene = mBaseScene;
        updateEmployees();
      }
    });

    TransitionSet collapseTransitionSet = new TransitionSet();
    collapseTransitionSet.setOrdering(TransitionSet.ORDERING_SEQUENTIAL);

    ChangeBounds resetBounds = new ChangeBounds();
    resetBounds.setDuration(durationSpeed);
    collapseTransitionSet.addTransition(resetBounds);

    mTransitionManager.setTransition(mBaseScene, mExpandedAddEmployeeScene, expandTransitionSet);
    mTransitionManager.setTransition(mExpandedAddEmployeeScene, mBaseScene, collapseTransitionSet);
    mBaseScene.enter();

//        postponeEnterTransition();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    overridePendingTransition(R.anim.slide_out_down, R.anim.slide_in_down);
  }

  public class EmployeesAdapter extends RecyclerView.Adapter<EmployeesAdapter.MyViewHolder> {

    public class MyViewHolder extends RecyclerView.ViewHolder {
      public TextView name, salary, bankNum, branchNum, accountNum;

      public MyViewHolder(View view) {
        super(view);

        name = (TextView) view.findViewById(R.id.employee_name);
        salary = (TextView) view.findViewById(R.id.employee_salary);
        bankNum = (TextView) view.findViewById(R.id.employee_bank_number);
        branchNum = (TextView) view.findViewById(R.id.employee_branch_number);
        accountNum = (TextView) view.findViewById(R.id.employee_account_number);
      }
    }

    public EmployeesAdapter() {
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View itemView = LayoutInflater.from(parent.getContext())
          .inflate(R.layout.employee_list_item, parent, false);

      return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      Employee employee = mEmployees.get(position);
//      int categoryId = category.getCategoryId();
      holder.name.setText(employee.getmName());
      String salary = String.format("%s", employee.getmSalary());
      holder.salary.setText(salary + " NIS");
      holder.bankNum.setText("בנק " + employee.getmBankNum());
      holder.branchNum.setText("סניף " + employee.getmBranchNum());
      holder.accountNum.setText("חשבון " + employee.getmAccountNum());
    }

    @Override
    public int getItemCount() {
      return mEmployees.size();
    }
  }
}
