package com.example.gak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Windows3Sliding extends AppCompatActivity {
    public RadioGroup rg1,rg2;
    public RadioButton rb1,rb2;
    public Button b1;
    String typ="Plane Glass",siz="3.5 mm",len,wid,num,glass=" ",area=" ",tb=" ";
    public TextView tv1;
    public EditText et1,et2,et3;

    //String flag="1";
    int flag=3;

    String ival2,ord="order",imesh;
    Spinner dropdown,dropdown2;
    Intent iw2,iw3,iw4;
    //int ar=100;
    double ar=100.00;

    FirebaseDatabase db1;
    DatabaseReference ref;

    Orders od1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windows3_sliding);

        rg1=findViewById(R.id.radiogroup1);
        rg2=findViewById(R.id.radiogroup2);

        b1=findViewById(R.id.button4);

        et1=findViewById(R.id.ed1);
        et2=findViewById(R.id.ed2);
        et3=findViewById(R.id.ed3);

        dropdown=findViewById(R.id.spinner3);

        List<String> lt=new ArrayList<>();
        lt.add("SS");
        lt.add("SG");
        lt.add("ALUMINUM");


        ArrayAdapter<String> ad=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lt);

        ad.setDropDownViewResource(android.R.layout.simple_spinner_item);

        dropdown.setAdapter(ad);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                imesh=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dropdown2=findViewById(R.id.spinner2);

        List<String> lt1=new ArrayList<>();
        lt1.add("Red");
        lt1.add("Blue");
        lt1.add("White");
        lt1.add("Brown");


        ArrayAdapter<String> ad1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lt1);

        ad1.setDropDownViewResource(android.R.layout.simple_spinner_item);

        dropdown2.setAdapter(ad1);

        dropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ival2=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        db1=FirebaseDatabase.getInstance();
        ref=db1.getReference();


        Random r=new Random();

        final int rnd=r.nextInt(1000);
        od1=new Orders();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rid1=rg1.getCheckedRadioButtonId();
                rb1=findViewById(rid1);
                int rid2=rg2.getCheckedRadioButtonId();
                rb2=findViewById(rid2);


                len=et2.getText().toString().trim();
                wid=et1.getText().toString().trim();
                num=et3.getText().toString().trim();


                od1.setLen(len);
                od1.setColor(ival2);
                od1.setWid(wid);
                od1.setGsize(siz);
                od1.setGtype(typ);
                od1.setNum(num);
                od1.setMesh(imesh);

                ref.child("Orders").child("Windows").child("3sliding").child("c1").child(ord+Integer.toString(rnd)).setValue(od1);
                Toast.makeText(Windows3Sliding.this,"Item Added to Cart Successfully",Toast.LENGTH_LONG).show();

                // ord=ord.substring(0,5)+Integer.toString(Integer.parseInt(ord.substring(5,6))+1);





                goToItems();




            }
        });

    }
    public void glassType(View v){
        int rid1=rg1.getCheckedRadioButtonId();
        rb1=findViewById(rid1);
        typ=rb1.getText().toString().trim();


    }
    public void glassSize(View v){
        int rid2=rg2.getCheckedRadioButtonId();
        rb2=findViewById(rid2);
        siz=rb2.getText().toString().trim();

    }
    public void goToItems(){

        iw2=new Intent(this,Windows2Item.class);




        // glass=glass+"Length: "+len+"    "+"Width: "+wid+"\n"+"Glass Type: "+typ+"\n"+"Glass Size: "+siz+"\n"+"Color:"+ival2;

        //tb=tb+" "+len+"  *  "+wid+"             "+num+"\n\n";

        //area=area+"Length:"+len+"Width"+wid;
        //ar=Integer.parseInt(len)*Integer.parseInt(wid);

        //ar=Double.parseDouble(len)*Double.parseDouble(wid);

        // iw2.putExtra("Area",ar);
        //iw2.putExtra("Area",ar);

        //iw2.putExtra("Glass",glass);

        //iw2.putExtra("Location",ival);

        //iw2.putExtra("Numberof",tb);
        //iw2.putExtra("Num",num);
        iw2.putExtra("Flag",flag);



        startActivity(iw2);
    }


}
