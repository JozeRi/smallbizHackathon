package heroapps.com.smallbizhackathon.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import heroapps.com.smallbizhackathon.R;
import heroapps.com.smallbizhackathon.business.SharedPref;
import heroapps.com.smallbizhackathon.business.Utils;
import heroapps.com.smallbizhackathon.model.User;

public class SplashActivity extends AppCompatActivity {

  private static final String TAG = SplashActivity.class.getSimpleName();

  private static final int SPLASH_TIME_IN_MILLIS = 2500;

  private TimerTask mTimerTask = new TimerTask() {
      @Override
      public void run() {
        checkIfLoggedIn();
      }
  };

  private TransitionManager mTransitionManager;
  private Scene mSignInScene;
  private Scene mBaseScene;
  private Scene mCurrentScene;

  private ImageView mSplashBg;
  private View mSplashEnterBtn;

  private EditText mBusinessName, mAccountNumber, mBranchNumber;

  private ViewGroup mTransitionRoot;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_splash);
    Utils.createLocalNotification("Best solution for your business", "Best solution for your business", "Best solution for your business", this);
      initViews();
      mCurrentScene = mBaseScene;
      setupTransitions();

      new Timer().schedule(mTimerTask, SPLASH_TIME_IN_MILLIS);
  }

  private void initViews() {
    mTransitionRoot = (ViewGroup) findViewById(R.id.root_container);
    mSplashBg = (ImageView) findViewById(R.id.splash_bg);

    mBusinessName = (EditText) findViewById(R.id.signin_et_business_name);
    mAccountNumber = (EditText) findViewById(R.id.signin_et_account_number);
    mBranchNumber = (EditText) findViewById(R.id.signin_et_branch_number);

    mSplashEnterBtn = findViewById(R.id.splash_enter);
    if (mSplashEnterBtn != null) {
      mSplashEnterBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          User user = new User();
          user.setName(mBusinessName.getText().toString());
          user.setAccountNumber(mAccountNumber.getText().toString());
          user.setBranchNumber(mBranchNumber.getText().toString());
          SharedPref.saveUser(user);

          SharedPref.setSignedStatus(true);

          //only if valid
          navigateToMain();
        }
      });
    }
    populate();
  }

  private void checkIfLoggedIn() {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        if (SharedPref.isSigned()) {
          navigateToMain();
        } else {
          goToSignUpScene();
        }
      }
    });

  }

  private void goToSignUpScene() {
    if (mCurrentScene == mSignInScene) {
      mCurrentScene = mBaseScene;
    } else {
      mCurrentScene = mSignInScene;
    }
    mTransitionManager.transitionTo(mCurrentScene);
  }

  private void navigateToMain() {
    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
    overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
  }

  private void setupTransitions() {
//        Slide slide = new Slide(Gravity.BOTTOM);
//        slide.excludeTarget(android.R.id.statusBarBackground, true);
//        getWindow().setEnterTransition(slide);
//        getWindow().setSharedElementsUseOverlay(false);

    mTransitionManager = new TransitionManager();

    // Expanded scene
    mSignInScene = Scene.getSceneForLayout(mTransitionRoot,
        R.layout.activity_splash_signin, this);

    mSignInScene.setEnterAction(new Runnable() {
      @Override
      public void run() {
        initViews();
        mCurrentScene = mSignInScene;
      }
    });

    int durationSpeed = 750;

    TransitionSet expandTransitionSet = new TransitionSet();
    expandTransitionSet.setOrdering(TransitionSet.ORDERING_SEQUENTIAL);
    ChangeBounds changeBounds = new ChangeBounds();
    changeBounds.setDuration(durationSpeed);
    expandTransitionSet.addTransition(changeBounds);

    // Collapsed scene
    mBaseScene = Scene.getSceneForLayout(mTransitionRoot,
        R.layout.activity_splash, this);

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

    mTransitionManager.setTransition(mBaseScene, mSignInScene, expandTransitionSet);
    mTransitionManager.setTransition(mSignInScene, mBaseScene, collapseTransitionSet);
    mBaseScene.enter();

//        postponeEnterTransition();
  }

  private void populate() {
    int bgRes = R.drawable.bg_main;
    Bitmap bgBitmap = getReducedBitmap(bgRes);
    mSplashBg.setImageBitmap(bgBitmap);
  }

  private Bitmap getReducedBitmap(int albumArtResId) {
    // reduce image size in memory to avoid memory errors
    final BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = false;
    options.inSampleSize = 8;
    return BitmapFactory.decodeResource(getResources(), albumArtResId, options);
  }
}
