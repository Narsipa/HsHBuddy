package com.example.android.timetabledemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.android.timetabledemo.Utils.LetterImageView;

public class DayDetail extends AppCompatActivity {

    private ListView listView;
    private android.support.v7.widget.Toolbar toolbar;
    public static String[] Montag;
    public static String[] Montag1;
    public static String[] Dienstag;
    public static String[] Mittwoch;
    public static String[] Donnerstag;
    public static String[] Freitag;
    public static String[] Samstag;
    public static String[] Time1;
    public static String[] Time2;
    public static String[] Time3;
    public static String[] Time4;
    public static String[] Time5;
    public static String[] Time6;
    private String[] PreferredDay;
    private String[] PreferredTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_detail);

        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews(){
        listView = (ListView)findViewById(R.id.lvDayDetail);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.ToolbarDayDetail);
    }

    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(WeekActivity.sharedPreferences.getString(WeekActivity.SEL_DAY, null));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView(){

        int zahl = (int)((Math.random()) * 6 + 1);

        Montag = getResources().getStringArray(R.array.Montag);
        Montag1 = getResources().getStringArray(R.array.Montag1);
        Dienstag = getResources().getStringArray(R.array.Dienstag);
        Mittwoch = getResources().getStringArray(R.array.Mittwoch);
        Donnerstag = getResources().getStringArray(R.array.Donnerstag);
        Freitag = getResources().getStringArray(R.array.Freitag);
        Samstag = getResources().getStringArray(R.array.Samstag);

        Time1 = getResources().getStringArray(R.array.time1);
        Time2 = getResources().getStringArray(R.array.time2);
        Time3 = getResources().getStringArray(R.array.time3);
        Time4 = getResources().getStringArray(R.array.time4);
        Time5 = getResources().getStringArray(R.array.time5);
        Time6 = getResources().getStringArray(R.array.time6);

        String selected_day = WeekActivity.sharedPreferences.getString(WeekActivity.SEL_DAY, null);

        if(selected_day.equalsIgnoreCase("Montag")){
            PreferredTime = Time1;
            if (zahl < 3){
                PreferredDay = Montag;
            } else PreferredDay = Montag1;

        }else if(selected_day.equalsIgnoreCase("Dienstag")){
            PreferredDay = Dienstag;
            PreferredTime = Time2;
        }else if(selected_day.equalsIgnoreCase("Mittwoch")){
            PreferredDay = Mittwoch;
            PreferredTime = Time3;
        }else if(selected_day.equalsIgnoreCase("Donnerstag")){
            PreferredDay = Donnerstag;
            PreferredTime = Time4;
        }else if(selected_day.equalsIgnoreCase("Freitag")){
            PreferredDay = Freitag;
            PreferredTime = Time5;
        }else{
            PreferredDay = Samstag;
            PreferredTime = Time6;
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(DayDetail.this, PreferredDay, PreferredTime);
        listView.setAdapter(simpleAdapter);

    }

    public class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView subject, time;
        private String[] subjectArray;
        private String[] timeArray;
        private LetterImageView letterImageView;

        public SimpleAdapter(Context context, String[] subjectArray, String[] timeArray){
            mContext = context;
            this.subjectArray = subjectArray;
            this.timeArray = timeArray;
            layoutInflater = LayoutInflater.from(context);
        }


        @Override
        public int getCount() {
            return subjectArray.length;
        }

        @Override
        public Object getItem(int position) {
            return subjectArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.day_detail_single_item, null);
            }

            subject = (TextView)convertView.findViewById(R.id.tvSubjectDayDetails);
            time = (TextView)convertView.findViewById(R.id.tvTimeDayDetail);
            letterImageView = (LetterImageView)convertView.findViewById(R.id.ivDayDetails);

            subject.setText(subjectArray[position]);
            time.setText(timeArray[position]);

            letterImageView.setOval(true);
            letterImageView.setLetter(subjectArray[position].charAt(0));

            return convertView;

        }
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
