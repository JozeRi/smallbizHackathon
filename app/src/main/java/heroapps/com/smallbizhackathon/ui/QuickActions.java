package heroapps.com.smallbizhackathon.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import heroapps.com.smallbizhackathon.R;
import heroapps.com.smallbizhackathon.model.Employee;
import io.realm.Realm;
import io.realm.RealmResults;

public class QuickActions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_actions);


        Button employe=(Button)findViewById(R.id.emploeyIB);
        employe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(QuickActions.this,EmployeesActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            }
        });

        Button payimg=(Button)findViewById(R.id.payIB);
        payimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Realm mRealm = Realm.getDefaultInstance();

                if (mRealm == null) return;
                RealmResults<Employee> results = mRealm.where(Employee.class).findAll();
                int count = results.size();
                startActivity(TransactionActivity.getTransactionIntent(QuickActions.this, count));
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            }
        });

    }
}
