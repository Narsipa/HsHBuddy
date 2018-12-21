package com.example.android.timetabledemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class RSSActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss);

        //Array von Titel zu Preis geändert als Test ob die Übergabe funktioniert -> es funktioniert

        ArrayList<String> headlines = new ArrayList<>();
        ArrayList<String> preis = new ArrayList<>();

        RetrieveFeed getXML = new RetrieveFeed();
        getXML.execute();
        headlines = getXML.heads();
        preis = getXML.preis();

        //Künstliche Pause da sonst Feed unter Umständen nicht angezeigt wird
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            // Process exception
        }

        // Binding data
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, preis);

        setListAdapter(adapter);

    }
}