package heroapps.com.smallbizhackathon.ui;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.TextView;

import heroapps.com.smallbizhackathon.R;

public class PaychecksActivity extends AppCompatActivity implements View.OnClickListener {

  private TransitionManager mTransitionManager;
  private Scene mExpandedAddEmployeeScene;
  private Scene mBaseScene;
  private Scene mCurrentScene;

  private ViewGroup mTransitionRoot;

  private EditText mName, mBankNum, mBranchNum, mAccountNum, mSalary;

  private TextView mAddNewEmployeeBtn;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_paychecks);

    initViews();
    mCurrentScene = mBaseScene;
    setupTransitions();
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

}
