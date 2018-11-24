package com.example.android.timetabledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFOpener1 extends AppCompatActivity {

    private PDFView myPDFViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfopener1);

        myPDFViewer = (PDFView)findViewById(R.id.pdfViewer1);

        myPDFViewer.fromAsset("1.OG_Raumplan.pdf").load();
    }
}
