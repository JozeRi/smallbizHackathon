package heroapps.com.smallbizhackathon.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import heroapps.com.smallbizhackathon.R;

public class SignInActivity extends AppCompatActivity {

    EditText accountNumET;
    EditText branchNumET;
    Button signInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

//        accountNumET = (EditText) findViewById(R.id.accountNumET);
//        branchNumET = (EditText) findViewById(R.id.branchNumET);
//
//        signInBtn = (Button) findViewById(R.id.signInBtn);
//        signInBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                //add validation
//                //send api request
//
//            }
//        });
    }


}
