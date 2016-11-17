package heroapps.com.smallbizhackathon.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import heroapps.com.smallbizhackathon.R;

public class QuickActions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_actions);

        ImageButton payimg=(ImageButton)findViewById(R.id.paychecksIV);
        payimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(QuickActions.this,EmployeesActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            }
        });

    }
}
