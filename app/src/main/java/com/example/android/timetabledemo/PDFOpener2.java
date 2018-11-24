package com.example.android.timetabledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFOpener2 extends AppCompatActivity {

    private PDFView myPDFViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfopener2);

        myPDFViewer = (PDFView)findViewById(R.id.pdfViewer2);

        myPDFViewer.fromAsset("2.OG_Raumplan.pdf").load();
    }
}
