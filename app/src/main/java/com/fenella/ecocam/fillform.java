package com.fenella.ecocam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.regex.Pattern;

public class fillform extends AppCompatActivity {

    TextView textViewic, textViewname, textViewaddress;
    TextView textViewN;
    String[] info;
    Pattern pattern;
    String icno, name, address, nationality, phone;
    String[] temp;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillform);
        textViewic = findViewById(R.id.form_icno);
        textViewname = findViewById(R.id.form_name);
        textViewaddress = findViewById(R.id.form_address);
        textViewN = findViewById(R.id.form_passnationality);
        editText = findViewById(R.id.form_input);

        Intent ii=getIntent();
        Bundle b=ii.getExtras();
        if (b!=null){
            String j=(String) b.get("personaldata");
            showInfo(j);
            textViewic.setText(icno);
            textViewname.setText(name);
            textViewaddress.setText(address);
        }

        Intent iin=getIntent();
        Bundle c=iin.getExtras();
        if (c!=null){
            String j=(String) c.get("fnationality");
            nationality = j;
            textViewN.setText(nationality);
        }

    }

    public void showInfo(String j){
        //using String split function
        info = j.split(" ");
        //using java.util.regex Pattern
        pattern = Pattern.compile("\n");
        info = pattern.split(j);

        icno = info[0];
        name = info[1];

        temp = new String[] {info[2], info[3], info[4]};
        address = Arrays.toString(temp);
    }

    public void Proceedtofinal(View view) {
        phone = editText.getText().toString();

        Intent i = new Intent(fillform.this,finalpage.class); //go to next page in this shit line
        i.putExtra("ICno", icno);
        i.putExtra("Name", name);
        i.putExtra("Address", address);
        i.putExtra("Nationality", nationality);
        i.putExtra("PhoneNumber", phone);
        startActivity(i);
        finish();
    }
}