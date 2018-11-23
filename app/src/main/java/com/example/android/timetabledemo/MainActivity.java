package com.example.android.timetabledemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarMain);
        listView = (ListView)findViewById(R.id.lvMain);
    }

    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("HsH Buddy");
    }

    private void setupListView(){

        String[] title = getResources().getStringArray(R.array.Main);
        String[] Beschreibung = getResources().getStringArray(R.array.Beschreibung);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title, Beschreibung);
        listView.setAdapter(simpleAdapter);
                                                                                                                //Test.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {                                      //Weiterleitung auf die jeweilige Activity
                switch(position){
                    case 0: {
                        Intent intent = new Intent(MainActivity.this, WeekActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 1: {
                        break;
                    }
                    case 2: {
                        break;
                    }
                    case 3: {
                        break;
                    }
                }
            }
        });
    }

    public class SimpleAdapter extends BaseAdapter{

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title, Beschreibung;
        private String[] titleArray;
        private String[] BeschreibungArray;
        private ImageView imageView;

        public SimpleAdapter(Context context, String[] title, String[] Beschreibung){
            mContext = context;
            titleArray = title;
            BeschreibungArray = Beschreibung;
            layoutInflater = LayoutInflater.from(context);
        }


        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.main_activity_single_item, null);
            }

            title = (TextView)convertView.findViewById(R.id.tvMain);
            Beschreibung = (TextView)convertView.findViewById(R.id.tvBeschreibung);
            imageView = (ImageView)convertView.findViewById(R.id.ivMain);

            title.setText(titleArray[position]);
            Beschreibung.setText(BeschreibungArray[position]);

            if(titleArray[position].equalsIgnoreCase("Stundenplan")){
                imageView.setImageResource(R.drawable.timetable);
            }else if(titleArray[position].equalsIgnoreCase("Mensa")){
                imageView.setImageResource(R.drawable.book);
            }else if(titleArray[position].equalsIgnoreCase("Schwarzes Brett")){
                imageView.setImageResource(R.drawable.contact);
            }else{
                imageView.setImageResource(R.drawable.settings);
            }

            return convertView;

        }
    }

}
