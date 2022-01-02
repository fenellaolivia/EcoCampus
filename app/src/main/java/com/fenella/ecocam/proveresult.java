package com.fenella.ecocam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class proveresult extends AppCompatActivity {

    TextView viewic, viewname, viewaddress, viewnationality, viewphone, viewdate;
    String ICNO, NAME, ADDRESS, NATIONALITY, PHONENUMBER, currentDateTimeString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proveresult);
        viewic = findViewById(R.id.final_icno);
        viewname = findViewById(R.id.final_name);
        viewaddress = findViewById(R.id.final_address);
        viewnationality = findViewById(R.id.final_passnationality);
        viewphone = findViewById(R.id.final_phonenumber);
        viewdate = findViewById(R.id.final_datetime);

        Intent ii=getIntent();
        Bundle b=ii.getExtras();

        if (b!=null){
            ICNO=(String) b.get("ICNO");
            NAME=(String) b.get("NAME");
            ADDRESS=(String) b.get("ADDRESS");
            NATIONALITY=(String) b.get("NATIONALITY");
            PHONENUMBER=(String) b.get("PHONENUMBER");
            currentDateTimeString=(String) b.get("currentDateTimeString");

            viewic.setText(ICNO);
            viewname.setText(NAME);
            viewaddress.setText(ADDRESS);
            viewnationality.setText(NATIONALITY);
            viewphone.setText(PHONENUMBER);
            viewdate.setText(currentDateTimeString);
        }
    }

    public void onDestroy(View view){
        Intent i = new Intent(proveresult.this,MainActivity.class); //go to next page in this shit line
        startActivity(i);
        finish();
    }
}