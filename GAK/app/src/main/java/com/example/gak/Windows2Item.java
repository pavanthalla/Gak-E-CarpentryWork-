package com.example.gak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Windows2Item extends AppCompatActivity {


    String tb=" ",loc,glass,num;
    String ord;
    public Button bw1,bw2;
    Intent iworker;

    Spinner dropdown;
    String ival;
    ListView listView1;

    ArrayList<String> list1;
    ArrayAdapter<String> adapter1;

    FirebaseDatabase database1;
    DatabaseReference ref1;
    Orders ods1;

    int fg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windows2_item);

        ods1=new Orders();

        listView1=findViewById(R.id.listview1);

        bw1=findViewById(R.id.button6);
        bw2=findViewById(R.id.button7);


       // loc=Objects.requireNonNull(getIntent().getStringExtra("Location"));
       // fg=Objects.requireNonNull(getIntent().getIntExtra("Flag"));
        fg=Objects.requireNonNull(getIntent().getIntExtra("Flag",2));

        dropdown=findViewById(R.id.spinner);

        List<String> lt=new ArrayList<>();
        lt.add("Tarnaka");
        lt.add("Secunderabad");
        lt.add("Gandipet");
        lt.add("Uppal");
        lt.add("Banjara Hills");

        ArrayAdapter<String> ad=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lt);

        ad.setDropDownViewResource(android.R.layout.simple_spinner_item);

        dropdown.setAdapter(ad);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ival=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        database1=FirebaseDatabase.getInstance();
        if(fg==2) {
            ref1 = database1.getReference("Orders").child("Windows").child("2sliding").child("c1");
        }else if(fg==3){
            ref1 = database1.getReference("Orders").child("Windows").child("3sliding").child("c1");

        }

        list1=new ArrayList<>();
        adapter1=new ArrayAdapter<String>(this,R.layout.orderslist,R.id.userInfo1,list1);




        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int cnt1=1;

                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    ods1=ds.getValue(Orders.class);
                    assert ods1 != null;

                    list1.add(Integer.toString(cnt1)+". Length: "+ods1.getLen().toString()+"  X  "+"Width: "+ods1.getWid().toString()+" \n"+"Number of Items:  "+ods1.getNum().toString());
                    cnt1=cnt1+1;
                }
                listView1.setAdapter(adapter1);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        bw1=findViewById(R.id.button6);
        bw2=findViewById(R.id.button7);
        bw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMore();
            }
        });
        bw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWorkers();
            }
        });


    }
    public void openWorkers(){
        iworker=new Intent(this,windows2cart.class);
       // iworker.putExtra("Glass",glass);
        iworker.putExtra("Location1",ival);
        iworker.putExtra("Flag2",fg);
        //iworker.putExtra("Numberof",tb);
        //iworker.putExtra("Num",num);
        startActivity(iworker);



    }
    public void addMore(){
        Intent iworker1 = null;
        if(fg==2) {
            iworker1 = new Intent(this, Windows2Sliding.class);
        }else if(fg==3) {
            iworker1 = new Intent(this, Windows3Sliding.class);
        }




        startActivity(iworker1);
    }

}
