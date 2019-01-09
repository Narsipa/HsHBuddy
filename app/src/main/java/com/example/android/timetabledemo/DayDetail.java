package com.example.android.timetabledemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
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
    public static String[] Montag1;
    public static String[] Montag2;
    public static String[] Montag3;
    public static String[] Dienstag1;
    public static String[] Dienstag2;
    public static String[] Dienstag3;
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
    public static String[] RaumMontag1;
    public static String[] RaumDienstag1;
    public static String[] RaumMittwoch1;
    public static String[] RaumDonnerstag1;
    public static String[] RaumFreitag1;
    private String[] PreferredDay;
    private String[] PreferredTime;
    private String[] PreferredRoom;

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

        Montag1 = getResources().getStringArray(R.array.Montag1);
        Montag2 = getResources().getStringArray(R.array.Montag2);
        Montag3 = getResources().getStringArray(R.array.Montag3);
        Dienstag1 = getResources().getStringArray(R.array.Dienstag1);
        Dienstag2 = getResources().getStringArray(R.array.Dienstag2);
        Dienstag3 = getResources().getStringArray(R.array.Dienstag3);
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

        RaumMontag1 = getResources().getStringArray(R.array.RaumMontag1);
        RaumDienstag1 = getResources().getStringArray(R.array.RaumDienstag1);
        RaumMittwoch1 = getResources().getStringArray(R.array.RaumMittwoch1);
        RaumDonnerstag1 = getResources().getStringArray(R.array.RaumDonnerstag1);
        RaumFreitag1 = getResources().getStringArray(R.array.RaumFreitag1);

        String selected_day = WeekActivity.sharedPreferences.getString(WeekActivity.SEL_DAY, null);

        int semester;
        semester = WeekActivity.semester;

        if(selected_day.equalsIgnoreCase("Montag")){
            PreferredTime = Time1;
            if (semester == 1){
                PreferredDay = Montag1;
                PreferredRoom = RaumMontag1;
            } else if (semester == 2){
                PreferredDay = Montag2;
            } else if (semester == 3){
                PreferredDay = Montag3;
            }

        }else if(selected_day.equalsIgnoreCase("Dienstag")){
            PreferredTime = Time2;
            if (semester == 1){
                PreferredDay = Dienstag1;
                PreferredRoom = RaumDienstag1;
            } else if (semester == 2){
                PreferredDay = Dienstag2;
            } else if (semester == 3){
                PreferredDay = Dienstag3;
            }

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

        SimpleAdapter simpleAdapter = new SimpleAdapter(DayDetail.this, PreferredDay, PreferredTime, PreferredRoom);
        listView.setAdapter(simpleAdapter);

    }

    public class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView subject, time, room;
        private String[] subjectArray;
        private String[] timeArray;
        private String[] roomArray;
        private LetterImageView letterImageView;

        public SimpleAdapter(Context context, String[] subjectArray, String[] timeArray, String[] roomArray){
            mContext = context;
            this.subjectArray = subjectArray;
            this.timeArray = timeArray;
            this.roomArray = roomArray;
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
            room = (TextView)convertView.findViewById(R.id.tvRoomDetail);
            subject = (TextView)convertView.findViewById(R.id.tvSubjectDayDetails);
            time = (TextView)convertView.findViewById(R.id.tvTimeDayDetail);
            letterImageView = (LetterImageView)convertView.findViewById(R.id.ivDayDetails);

            subject.setText(subjectArray[position]);
            time.setText(timeArray[position]);
            room.setText(roomArray[position]);
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
