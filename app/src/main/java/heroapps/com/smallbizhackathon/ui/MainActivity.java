package heroapps.com.smallbizhackathon.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import heroapps.com.smallbizhackathon.R;
import heroapps.com.smallbizhackathon.model.retrofitobjects.AccountTransaction;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


      TextView title= (TextView)findViewById(R.id.titleTv);
      title.setText(R.string.hello );

      TextView subtitle= (TextView)findViewById(R.id.subtitleTv);
      title.setText(R.string.your_balance );

      RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerList);
      //MyAdapter adapter = new MyAdapter(listF);
      recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
      //recyclerView.swapAdapter(adapter, true);




  }


  // 1> Create our Adapter class ==> generic type is a ViewHolder, a wrapper for each item
  public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    // 8> Create the data structure
    private ArrayList<AccountTransaction> strings;


    // 9> create constructor that gets a new ArrayList
    public MyAdapter(ArrayList<AccountTransaction> string) {

      this.strings = string;
    }


    // 11> what to do when creating a new MyHolder - inflate the item layout and pass it to a new holder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      LayoutInflater inflater = MainActivity.this.getLayoutInflater();
      View v = inflater.inflate(R.layout.list_item, parent, false);
      return new MyViewHolder(v);
    }

    // 12> how to bind(show) the data for each item in the list
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

       // holder.bindText( );

    }

    // 10> return the size of the ArrayList
    @Override
    public int getItemCount() {
      return strings.size();
    }

    // 2> Create the ViewHolder class - and the layout resource file
    public class MyViewHolder extends RecyclerView.ViewHolder{

      // 5> add the view variables
        private TextView date;
        private TextView description;
        private TextView amunt;



        // 3> Add constructor
      public MyViewHolder(View itemView) {
        super(itemView);

        // 6> find the views and connect to the variables
          date = (TextView) itemView.findViewById(R.id.dateTv);
          description = (TextView) itemView.findViewById(R.id.descriptionTv);
          amunt = (TextView) itemView.findViewById(R.id.amuntTv);


          itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {


            //Intent intent=new Intent(this,DetailActivity.class);
            //intent.putExtra("detail",text.getText());
            //startActivity(intent);
            //Toast.makeText(getActivity(), text.getText() , Toast.LENGTH_SHORT).show();

          }
        });


      }


      // 7> create the binding method - what data goes to which view!
      public void bindText(String txt, String txt1, String txt2 ) {

        date.setText(txt);
        description.setText(txt1);
        amunt.setText(txt2);

      }
    }
  }
}