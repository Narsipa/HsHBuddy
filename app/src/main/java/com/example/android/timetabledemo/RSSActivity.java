package com.example.android.timetabledemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class RSSActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss);

        ArrayList<String> headlines = new ArrayList<>();

        RetrieveFeed getXML = new RetrieveFeed();
        getXML.execute();
        headlines = getXML.heads();


        // Binding data
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, headlines);

        setListAdapter(adapter);

    }
}