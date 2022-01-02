package com.fenella.ecocam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ScannerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String Dnationality;
    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        mySpinner = (Spinner) findViewById(R.id.second_option);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(ScannerActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.nationality));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Dnationality = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void ProceedtoCamera(View view) {
        Intent i = new Intent(ScannerActivity.this,CameraPage.class); //go to next page in this shit line
        i.putExtra("Cnationality", Dnationality);
        startActivity(i);
        finish();
    }


}