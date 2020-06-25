package com.example.gak;

//import androidx.annotation.NonNull;
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

import com.example.gak.ui.home.HomeFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class windows2cart extends AppCompatActivity {


    String txt1=" ",txt2=" ",num;
    String locarea,glass,tb;


    Double tot;
    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;

    ArrayList<String> list;

    ArrayList<String> namelist;
    ArrayAdapter<String> adapter;

    Carpenters cs;

    int fg2;

    int cnt=0;

    public Button bc1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windows2cart);



        //loc=Objects.requireNonNull(getIntent().getStringExtra("Location1"));

        bc1=findViewById(R.id.button5);

        cs=new Carpenters();

        listView=findViewById(R.id.listview);


        database=FirebaseDatabase.getInstance();

        fg2=Objects.requireNonNull(getIntent().getIntExtra("Flag2",2));


        locarea=Objects.requireNonNull(getIntent().getStringExtra("Location1"));
        //glass= Objects.requireNonNull(getIntent().getStringExtra("Glass"));
        //tb= Objects.requireNonNull(getIntent().getStringExtra("Numberof"));
        //num= Objects.requireNonNull(getIntent().getStringExtra("Num"));


      //  ref=database.getReference("Carpenters").child(locarea);
        ref=database.getReference("Carpenters");

        list=new ArrayList<>();
        namelist=new ArrayList<String>(100);

       // txt2=Objects.requireNonNull(getIntent().getDoubleExtra("Area",100.00)).toString();

        adapter=new ArrayAdapter<String>(this,R.layout.carpenterslist,R.id.userInfo,list);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int cnt2=1;

                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    cs=ds.getValue(Carpenters.class);
                    //tot=(Double.parseDouble(cs.getPrice())*Double.parseDouble(txt2));
                    assert cs != null;
                if(locarea.equals(cs.getArea())){
                    cnt=cnt+1;
                    String gn=cs.getName().toString().trim();

                    list.add(Integer.toString(cnt2)+".  Name:  "+gn+"    Age:"+cs.getAge()+"\n\n"+" Price(persqinch): "+cs.getPrice()+"Rs\\-");
                    cnt2=cnt2+1;
                    namelist.add(gn);
                }
                }
                listView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        //txt2=Objects.requireNonNull(getIntent().getIntExtra("Area",100)).toString();

        //tv2.setText("Total Bill"+txt2+"Rs");
       // tv2.setText(getIntent().getIntExtra("Area",100));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent ic1=new Intent(getApplicationContext(),Windows2Last.class);
                //ic1.putExtra("Worker",listView.getItemAtPosition(position).toString());


                ic1.putExtra("Location",locarea);

               // ic1.putExtra("cname",listView.getItemAtPosition(position).toString());
                ic1.putExtra("cname",namelist.get(position));
                ic1.putExtra("Flag3",fg2);
                startActivity(ic1);


            }
        });

        bc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });

    }

    public void goBack(){
        Intent ic1=new Intent(this, HomeFragment.class);
        startActivity(ic1);
    }

}
