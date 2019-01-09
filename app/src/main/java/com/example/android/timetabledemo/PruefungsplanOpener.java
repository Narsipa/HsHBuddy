package com.example.android.timetabledemo;

import android.content.Intent;
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
        getSupportActionBar().setTitle("Prüfungsplan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

