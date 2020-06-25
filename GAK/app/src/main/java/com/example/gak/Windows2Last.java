package com.example.gak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Windows2Last extends AppCompatActivity {

    public TextView tl1,tl2,tl3,tl4;
    String locarea,name;

    double tot,bill;
    FirebaseDatabase database2,database3,db4;
    DatabaseReference ref2,ref3,ref4;

    Orders tord;
    Carpenters tcar;
    CarpOrders tcar1;

    ListView listView1;

    ArrayList<String> list1;
    ArrayAdapter<String> adapter1;

    double cost;

    String cst,ord="order";

    int fg1;

    Button bl1;
    String ordtxt="",bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windows2_last);

       // tl1=findViewById(R.id.textView11);

        tl3=findViewById(R.id.textView10);
        tl4=findViewById(R.id.textView13);

        bl1=findViewById(R.id.button12);

        locarea=Objects.requireNonNull(getIntent().getStringExtra("Location"));
        name=Objects.requireNonNull(getIntent().getStringExtra("cname"));

        fg1=Objects.requireNonNull(getIntent().getIntExtra("Flag3",2));

        tord=new Orders();

        listView1=findViewById(R.id.listview2);

        database3=FirebaseDatabase.getInstance();

        if(fg1==2) {
            ref3 = database3.getReference("Orders").child("Windows").child("2sliding").child("c1");
        }else if(fg1==3) {
            ref3 = database3.getReference("Orders").child("Windows").child("3sliding").child("c1");
        }


        list1=new ArrayList<>();
        adapter1=new ArrayAdapter<String>(this,R.layout.orderslist,R.id.userInfo1,list1);



        ref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int cot=1;

                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    tord=ds.getValue(Orders.class);
                    assert tord != null;

                if(fg1==2) {
                    list1.add(Integer.toString(cot) + ")  Length: " + tord.getLen().toString() + "   X   " + "Width: " + tord.getWid().toString() + " \n" + "Number of Items: " + tord.getNum().toString() + " Color: " + tord.getColor() + "\nGlassType: " + tord.getGtype().substring(0, 6) + " GlassSize: " + tord.getGsize());
                    ordtxt=ordtxt+"\n"+Integer.toString(cot) + ")  Length: " + tord.getLen().toString() + "   X   " + "Width: " + tord.getWid().toString() + " " + "Number of Items: " + tord.getNum().toString() + " Color: " + tord.getColor() + "GlassType: " + tord.getGtype().substring(0, 6) + " GlassSize: " + tord.getGsize()+"\n";
                }else if(fg1==3) {
                    list1.add(Integer.toString(cot) + ")  Length: " + tord.getLen().toString() + "   X   " + "Width: " + tord.getWid().toString() + " \n" + "Number of Items: " + tord.getNum().toString() + " Color: " + tord.getColor() + "\nGlassType: " + tord.getGtype().substring(0, 6) + " GlassSize: " + tord.getGsize()+"\nMesh Type:"+tord.getMesh());
                   ordtxt=ordtxt+"\n"+ Integer.toString(cot) + ")  Length: " + tord.getLen().toString() + "   X   " + "Width: " + tord.getWid().toString() + " " + "Number of Items: " + tord.getNum().toString() + " Color: " + tord.getColor() + "GlassType: " + tord.getGtype().substring(0, 6) + " GlassSize: " + tord.getGsize()+"MeshType:"+tord.getMesh()+"\n";
                }cot=cot+1;

                   tot=tot+Double.parseDouble(tord.getLen().trim())*Double.parseDouble(tord.getNum().trim())*Double.parseDouble(tord.getWid().trim());
                }
                listView1.setAdapter(adapter1);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        tcar=new Carpenters();
        tcar1=new CarpOrders();


        database2=FirebaseDatabase.getInstance();
        db4=FirebaseDatabase.getInstance();
        ref4=db4.getReference();

        ref2=database2.getReference("Carpenters");

        Random r=new Random();

        final int rnd=r.nextInt(1000);

        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot ds:dataSnapshot.getChildren()){

                    tcar=ds.getValue(Carpenters.class);
                    assert tcar != null;
                   // String ln=tcar.getArea();
                    if(locarea.equals(tcar.getArea())){
                         cst=tcar.getPrice();
                         cost=Double.parseDouble(cst);
                         bill=cost*tot;



                         String bd="Total             :"+ bill +"Rs/- \n"+"Taxes            :250Rs/-\n"+"Your total prize:"+ (bill + 250)+"Rs/-";
                         String det = "\nName :" + tcar.getName().toString() + "\n" + "Age  :" + tcar.getAge().toString();
                         tl3.setText(det);
                         tl4.setText(bd);
                     //   ordtxt=ordtxt+"\n"+"Bill:"+Double.toString(bill+250.00)+"Rs/-";

                        bl1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                String ids=ord+Integer.toString(rnd);
                                tcar1.setBill(Double.toString(bill+250.00));
                                tcar1.setCname("ps");
                                tcar1.setItems(ordtxt);
                                tcar1.setMbl("7689");
                                tcar1.setFlag("0");
                                tcar1.setId(ids);


                             //   ref2.child(name).child("ordrecv").setValue(ordtxt);
                                ref4.child("CarpOrders").child(tcar.getOrdrecv()).child("w1").child(ids).setValue(tcar1);
                              //  ref.child("Orders").child("Windows").child("2sliding").child("c1").child(ord+Integer.toString(rnd)).setValue(od1);

                                bl1.setVisibility(v.GONE);
                            }
                        });

                    }


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


       // bill=cost;
       // tl1.setText(tlast1);

        //tl2.setText(tlast2);
        //String tbill="Total           :"+ bill +"Rs/- \n"+"Taxes          :250\n"+"Your total prize:"+ (bill + 250);
       // String dd=Double.toString(cost);
       // tl4.setText(cst);

      /*  ordtxt=ordtxt+"Bill:"+Double.toString(bill+250.00);
        bl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tcar.setOrdrecv(ordtxt);
                ref2.child(name).setValue(tcar);
            }
        });
        */

    }
}
