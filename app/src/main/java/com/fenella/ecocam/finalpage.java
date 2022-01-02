package com.fenella.ecocam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class finalpage extends AppCompatActivity {

    TextView viewic, viewname, viewaddress, viewnationality, viewphone, viewdate;
    String ICNO, NAME, ADDRESS, NATIONALITY, PHONENUMBER;
    FirebaseFirestore db;
    String  currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
    int v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpage);
        db = FirebaseFirestore.getInstance();
        viewic = findViewById(R.id.final_icno);
        viewname = findViewById(R.id.final_name);
        viewaddress = findViewById(R.id.final_address);
        viewnationality = findViewById(R.id.final_passnationality);
        viewphone = findViewById(R.id.final_phonenumber);
        viewdate = findViewById(R.id.final_datetime);

        Intent ii=getIntent();
        Bundle b=ii.getExtras();

        if (b!=null){
            ICNO=(String) b.get("ICno");
            NAME=(String) b.get("Name");
            ADDRESS=(String) b.get("Address");
            NATIONALITY=(String) b.get("Nationality");
            PHONENUMBER=(String) b.get("PhoneNumber");

            viewic.setText(ICNO);
            viewname.setText(NAME);
            viewaddress.setText(ADDRESS);
            viewnationality.setText(NATIONALITY);
            viewphone.setText(PHONENUMBER);
            viewdate.setText(currentDateTimeString);
        }

    }


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.final_check:
                if (checked){
                    v=69;
                }
                // Put some meat on the sandwich
                else{
                    v=0;
                }
                // Remove the meat
                break;
            // TODO: Veggie sandwich
        }
    }


        public void RestartToMain(View view){
        Intent ii=getIntent();
        Bundle b=ii.getExtras();

        if (b!=null){
            ICNO=(String) b.get("ICno");
            NAME=(String) b.get("Name");
            ADDRESS=(String) b.get("Address");
            NATIONALITY=(String) b.get("Nationality");
            PHONENUMBER=(String) b.get("PhoneNumber");
        }

        Map<String, Object> visitorData = new HashMap<>();
        visitorData.put("IC Number", ICNO);
        visitorData.put("Name", NAME);
        visitorData.put("Address", ADDRESS);
        visitorData.put("Nationality", NATIONALITY);
        visitorData.put("Phone Number", PHONENUMBER);
        visitorData.put("Date Time", currentDateTimeString);

        if (v==69){
            db.collection("visitorData")
                    .add(visitorData)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(finalpage.this,"Register Successfully",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(finalpage.this,proveresult.class); //go to next page in this shit line
                            i.putExtra("ICNO", ICNO);
                            i.putExtra("NAME", NAME);
                            i.putExtra("ADDRESS", ADDRESS);
                            i.putExtra("NATIONALITY", NATIONALITY);
                            i.putExtra("PHONENUMBER", PHONENUMBER);
                            i.putExtra("currentDateTimeString", currentDateTimeString);
                            startActivity(i);
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @NotNull Exception e) {
                    Toast.makeText(finalpage.this,"Register Failed",Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            Toast.makeText(finalpage.this,"Please check the Terms and Conditions.",Toast.LENGTH_SHORT).show();
        }





    }
}