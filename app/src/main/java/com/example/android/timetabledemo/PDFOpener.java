package com.example.android.timetabledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFOpener extends AppCompatActivity {

    private PDFView myPDFViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfopener);

        myPDFViewer = (PDFView)findViewById(R.id.pdfViewer);

        myPDFViewer.fromAsset("Erdgeschoss_Raumplan.pdf").load();

    }
}
