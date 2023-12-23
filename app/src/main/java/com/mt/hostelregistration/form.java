package com.mt.hostelregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class form extends AppCompatActivity {
EditText name, dept, city, clas, rank;

Button submit;
Spinner hostel;
RadioButton ug, pg, phd;
RadioButton M, F;
public String[] hostels={"Hostel 1", "Hostel 2","Hostel 3", "Hostel 4" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        name=findViewById(R.id.name);
        city=findViewById(R.id.city);
        dept=findViewById(R.id.dept);
        clas=findViewById(R.id.clas);
        rank=findViewById(R.id.rank);
        hostel=findViewById(R.id.hostel);
        ug=findViewById(R.id.ug);
        pg=findViewById(R.id.pg);
        phd=findViewById(R.id.phd);
        M=findViewById(R.id.M);
        F=findViewById(R.id.F);
        hostel=findViewById(R.id.hostel);
        ArrayAdapter<String> myAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, hostels);
        hostel.setAdapter(myAdapter);
        submit=findViewById(R.id.Submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gender="";
                String hostelnumber="";
                //determine gender
                if(M.isChecked())

                {
                    gender="Male";
                }
                else if(F.isChecked())
                {
                    gender="Female";
                }
                //determine hostel number
                String selectedHostel= hostel.getSelectedItem().toString();
                if(selectedHostel.equals("Hostel 1"))
                {
                    hostelnumber ="1";
                }
                else if (selectedHostel.equals("Hostel 2")) {
                    {
                        hostelnumber="2";
                    }
                }
                else if (selectedHostel.equals("Hostel 3")) {
                    {
                        hostelnumber="3";
                    }
            }
                else if (selectedHostel.equals("Hostel 4"))
                    {
                        hostelnumber = "4";
                    }
                    String course=" ";
                    if(ug.isChecked())
                    {
                        course="UG";
                    }
                    else if(pg.isChecked())
                    {
                        course="PG";
                    } else if (phd.isChecked()) {
                        course="Phd";
                    }
if(city.getText().toString().toLowerCase().trim().equals("chandigarh") || city.getText().toString().trim().toLowerCase().equals("mohali"))
{
    Toast.makeText(form.this, "Sorry, You cant take the hostel", Toast.LENGTH_SHORT).show();
    return;
}
if(!name.getText().toString().isEmpty()&& !dept.getText().toString().isEmpty() && !clas.getText().toString().isEmpty()&& !rank.getText().toString().isEmpty()&& !city.getText().toString().isEmpty() && !gender.isEmpty()) {
    //generate the id
    String id = gender + "/" + clas.getText() + "/" + dept.getText().toString() + "/" + gender.substring(0, 2) + hostelnumber + "/" + System.currentTimeMillis();

//display toast
    Toast.makeText(form.this, "Reference ID: " + id, Toast.LENGTH_SHORT).show();
    Intent intent = new Intent(form.this, data.class);
    intent.putExtra("Name", name.getText().toString());
    intent.putExtra("Class", clas.getText().toString());
    intent.putExtra("dept", dept.getText().toString());
    intent.putExtra("Rank", rank.getText().toString());
    intent.putExtra("City", city.getText().toString());
    intent.putExtra("Hostel",  hostelnumber);
    intent.putExtra("Gender", gender);
    intent.putExtra("course", course);
    intent.putExtra("id", id);
    startActivity(intent);
}
else {
    Toast.makeText(form.this, "Invalid input", Toast.LENGTH_SHORT).show();

}
            }

});

    }
        }