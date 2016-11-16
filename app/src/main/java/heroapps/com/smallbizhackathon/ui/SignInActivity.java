package heroapps.com.smallbizhackathon.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import heroapps.com.smallbizhackathon.R;

public class SignInActivity extends AppCompatActivity {

    EditText accountNumET;
    EditText branchNumET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        accountNumET = (EditText) findViewById(R.id.accountNumET);
        branchNumET = (EditText) findViewById(R.id.branchNumET);


    }
}
