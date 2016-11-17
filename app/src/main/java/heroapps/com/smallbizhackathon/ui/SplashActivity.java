package heroapps.com.smallbizhackathon.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import heroapps.com.smallbizhackathon.R;
import heroapps.com.smallbizhackathon.business.SharedPref;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Button signInBtn = (Button) findViewById(R.id.signInBtn);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //fill in screen with color

                //check if isSigned == true
                if (!SharedPref.isSigned()) {
                    userAccDetailsDialog();
                    //open activity? dialog?
                    //get user data from et
                    return;
                }

                //fill out screen
                //go to main activity
                //pass name
                //pass balance
            }
        });

    }


    private void userAccDetailsDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.get_details));

        final EditText branchNumInput = new EditText(this);
        final EditText accNumInput = new EditText(this);

        branchNumInput.setInputType(InputType.TYPE_CLASS_NUMBER);
        accNumInput.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(R.layout.activity_sign_in);
        //builder.setView(accNumInput);

        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //Log.d(TAG, SharedPref.getAccountId());
                Intent goToMain = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(goToMain);
            }
        });

        builder.show().getWindow().setLayout(1000,1000);
    }
}
