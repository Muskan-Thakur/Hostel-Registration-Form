package com.mt.hostelregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        Intent intent=getIntent();
        String name=intent.getStringExtra("Name");
        String clas=intent.getStringExtra("Class");
        String dept=intent.getStringExtra("dept");
        String rank=intent.getStringExtra("Rank");
        String city=intent.getStringExtra("City");
        String hostel=intent.getStringExtra("Hostel");
        String gender=intent.getStringExtra("Gender");
        String course=intent.getStringExtra("course");
        String id=intent.getStringExtra("id");

        //displaying the values in textvieews
        TextView nameTextview=findViewById(R.id.nameview);
        nameTextview.setText("Name: " + name);

        TextView classtextview= findViewById(R.id.classview);
        classtextview.setText("Class: " + clas);

        TextView depttextview= findViewById(R.id.deptview);
        depttextview.setText("Department: " + dept);

        TextView rankTextview=findViewById(R.id.rankview);
        rankTextview.setText("Rank : " + rank);

        TextView cityTextview=findViewById(R.id.cityview);
        cityTextview.setText("City : " + city);

        TextView hosteltextview= findViewById(R.id.hostelview);
        hosteltextview.setText("Hostel: " + hostel);

        TextView genderTextview=findViewById(R.id.genderview);
        genderTextview.setText("Gender : " + gender);

        TextView coursetextview= findViewById(R.id.courseview);
        coursetextview.setText("Course: " + course);

        TextView reftextview= findViewById(R.id.refidview);
        reftextview.setText("Refernce ID: " + id);

    }
}