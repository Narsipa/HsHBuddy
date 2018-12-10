package com.example.android.timetabledemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFOpener1 extends AppCompatActivity {

    private Toolbar toolbar;
    private PDFView myPDFViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfopener1);

        setupUIViews();
        initToolbar();

        myPDFViewer.fromAsset("1.OG_Raumplan.pdf").load();
    }

    private void setupUIViews() {
        toolbar = (Toolbar) findViewById(R.id.pdfopener);
        myPDFViewer = (PDFView)findViewById(R.id.pdfViewer1);
    }

    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Raumplan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pdf_option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.pdf: {
                myPDFViewer.fromAsset("Erdgeschoss_Raumplan.pdf").load();
                break;
            }
            case R.id.pdf1: {
                myPDFViewer.fromAsset("1.OG_Raumplan.pdf").load();
                break;
            }

            case R.id.pdf2: {
                myPDFViewer.fromAsset("2.OG_Raumplan.pdf").load();
                break;
            }
            case android.R.id.home : {
                onBackPressed();
            }

        }
        return super.onOptionsItemSelected(item);
    }
}
