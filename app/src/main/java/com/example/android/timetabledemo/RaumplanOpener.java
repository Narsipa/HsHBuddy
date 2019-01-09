package com.example.android.timetabledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;

public class RaumplanOpener extends AppCompatActivity {

    private Toolbar toolbar;
    private PDFView myPDFViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfopener);

        setupUIViews();
        initToolbar();

        myPDFViewer.fromAsset("Erdgeschoss_Raumplan.pdf").load();

    }

    private void setupUIViews() {
        toolbar = (Toolbar) findViewById(R.id.pdfopener);
        myPDFViewer = (PDFView)findViewById(R.id.pdfViewer);
    }

    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Erdgeschoss");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.raumplan_auswahl_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.eg: {
                myPDFViewer.fromAsset("Erdgeschoss_Raumplan.pdf").load();
                getSupportActionBar().setTitle("Erdgeschoss");
                break;
            }
            case R.id.erste_etage: {
                myPDFViewer.fromAsset("1.OG_Raumplan.pdf").load();
                getSupportActionBar().setTitle("1. Etage");
                break;
            }

            case R.id.zweite_etage: {
                myPDFViewer.fromAsset("2.OG_Raumplan.pdf").load();
                getSupportActionBar().setTitle("2. Etage");
                break;
            }
            case android.R.id.home : {
                onBackPressed();
            }

        }
        return super.onOptionsItemSelected(item);
    }
}
