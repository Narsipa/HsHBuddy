package com.example.android.timetabledemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MontagActivity extends AppCompatActivity {
    private Toolbar toolbar;

    SharedPreferences sharedpreferences;
    EditText fach1;
    EditText fach2;
    EditText fach3;
    EditText fach4;
    EditText fach5;
    EditText fach6;
    private static final String mypreference = "montag";
    private static final String Fach1 = "fach1Key";
    private static final String Fach2 = "fach2Key";
    private static final String Fach3 = "fach3Key";
    private static final String Fach4 = "fach4Key";
    private static final String Fach5 = "fach5Key";
    private static final String Fach6 = "fach6Key";

    private void setupUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarMontag);
    }

    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Montag");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.montag);

        setupUIViews();
        initToolbar();


        fach1 = (EditText) findViewById(R.id.moFach1);
        fach2 = (EditText) findViewById(R.id.moFach2);
        fach3 = (EditText) findViewById(R.id.moFach3);
        fach4 = (EditText) findViewById(R.id.moFach4);
        fach5 = (EditText) findViewById(R.id.moFach5);
        fach6 = (EditText) findViewById(R.id.moFach6);

        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Fach1)) {
            fach1.setText(sharedpreferences.getString(Fach1, ""));
        }
        if (sharedpreferences.contains(Fach2)) {
            fach2.setText(sharedpreferences.getString(Fach2, ""));
        }
        if (sharedpreferences.contains(Fach3)) {
            fach3.setText(sharedpreferences.getString(Fach3, ""));
        }
        if (sharedpreferences.contains(Fach4)) {
            fach4.setText(sharedpreferences.getString(Fach4, ""));
        }
        if (sharedpreferences.contains(Fach5)) {
            fach5.setText(sharedpreferences.getString(Fach5, ""));
        }
        if (sharedpreferences.contains(Fach6)) {
            fach6.setText(sharedpreferences.getString(Fach6, ""));
        }
    }



    public void Save(View view) {
        String fe = fach1.getText().toString();
        String fz = fach2.getText().toString();
        String fd = fach3.getText().toString();
        String fv = fach4.getText().toString();
        String ff = fach5.getText().toString();
        String fs = fach6.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Fach1, fe);
        editor.putString(Fach2, fz);
        editor.putString(Fach3, fd);
        editor.putString(Fach4, fv);
        editor.putString(Fach5, ff);
        editor.putString(Fach6, fs);
        editor.commit();

        Toast.makeText(MontagActivity.this, "Gespeichert",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home : {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }

}