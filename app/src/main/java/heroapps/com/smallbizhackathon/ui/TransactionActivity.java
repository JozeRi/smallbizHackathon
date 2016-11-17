package heroapps.com.smallbizhackathon.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import heroapps.com.smallbizhackathon.R;

public class TransactionActivity extends AppCompatActivity {

  private static final String COUNT = "COUNT";

  private TextView mPaymentStatus, mPaymentText, mSuccess;
  private ProgressBar mProgressBar;

  public static Intent getTransactionIntent(Context context, int count) {
    Intent intent = new Intent(context, TransactionActivity.class);
    intent.putExtra(COUNT, count);
    return intent;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_transaction);
    initViews();

    Intent intent = getIntent();
    int count = intent.getIntExtra(COUNT, 0);

    if (count == 0) {
      Toast.makeText(this, "אין עובדים המחכים לתשלום", Toast.LENGTH_SHORT).show();
      finish();
    }

    sendTransactions(count);
  }

  private void initViews() {
    mPaymentText = (TextView) findViewById(R.id.trans_text1);
    mPaymentStatus = (TextView) findViewById(R.id.trans_text2);
    mSuccess = (TextView) findViewById(R.id.trans_text3);
    mProgressBar = (ProgressBar) findViewById(R.id.progressBar2);

    mSuccess.setScaleX(0);
    mSuccess.setScaleY(0);
  }

  public void sendTransactions(final int count) {
    mProgressBar.setProgress(0);

    final int totalProgressTime = 100;
    final int jumpTimeAdd = totalProgressTime / count;
    final Thread t = new Thread() {
      @Override
      public void run() {
        int jumpTime = 0;
        int numToPrint = 0;
        while(jumpTime < totalProgressTime) {
          try {
            sleep(500);
            jumpTime += jumpTimeAdd;
//            jumpTime++;
            final StringBuilder sb = new StringBuilder();
            numToPrint++;
            if (numToPrint > count) numToPrint = count;
            sb.append(numToPrint);
            sb.append(" ");
            sb.append("מתוך");
            sb.append(" ");
            sb.append(count);
            final int finalJumpTime = jumpTime;
            runOnUiThread(new Runnable() {
              @Override
              public void run() {
                mPaymentStatus.setText(sb.toString());
                mProgressBar.setProgress(finalJumpTime);
              }
            });

          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
        animateSuccess();
        try {
          sleep(2500);
          finish();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      }
    };
    t.start();
  }

  private void animateSuccess() {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        mProgressBar.setScaleX(1);
        mProgressBar.setScaleY(1);
        mProgressBar.animate().scaleX(0).scaleY(0).start();

        mPaymentText.setScaleX(1);
        mPaymentText.setScaleY(1);
        mPaymentText.animate().scaleX(0).scaleY(0).start();

        mPaymentStatus.setScaleX(1);
        mPaymentStatus.setScaleY(1);
        mPaymentStatus.animate().scaleX(0).scaleY(0).start();

        mSuccess.animate().scaleX(1).scaleY(1).start();


      }
    });
  }


}
