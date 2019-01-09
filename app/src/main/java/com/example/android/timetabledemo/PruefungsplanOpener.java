package com.example.android.timetabledemo;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;

public class PruefungsplanOpener extends AppCompatActivity {

    private Toolbar toolbar;
    private PDFView myPDFViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pruefungsplanopener);

        setupUIViews();
        initToolbar();

        myPDFViewer.fromAsset("Pruefungsplan_1.pdf").load();

    }

    private void setupUIViews() {
        toolbar = (Toolbar) findViewById(R.id.pdfopener);
        myPDFViewer = (PDFView)findViewById(R.id.pdfViewerPruefungsplan);
    }

    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("1. Studienabschnitt");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pruefungsplan_auswahl_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.abschnitt_1: {
                myPDFViewer.fromAsset("Pruefungsplan_1.pdf").load();
                getSupportActionBar().setTitle("1. Studienabschnitt");
                break;
            }
            case R.id.abschnitt_2: {
                myPDFViewer.fromAsset("Pruefungsplan_2.pdf").load();
                getSupportActionBar().setTitle("2. Studienabschnitt");
                break;
            }
            case android.R.id.home : {
                onBackPressed();
            }

        }
        return super.onOptionsItemSelected(item);
    }
}

