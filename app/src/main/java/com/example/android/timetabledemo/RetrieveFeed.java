package com.example.android.timetabledemo;

import android.os.AsyncTask;
import android.util.Xml;
import android.view.View;
import android.widget.ProgressBar;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class RetrieveFeed extends AsyncTask {
    URL url;
    ArrayList<String> headlines = new ArrayList();
    ArrayList<String> links = new ArrayList();

    @Override
    protected Object doInBackground(Object[] objects) {
        // Initializing instance variables


        try {
            url = new URL("https://politepol.com/feed/42168");

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(false);
            XmlPullParser xpp = factory.newPullParser();


            xpp.setInput(url.openConnection().getInputStream(), "UTF_8");


            boolean insideItem = false;


            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {

                    if (xpp.getName().equalsIgnoreCase("item")) {
                        insideItem = true;
                    } else if (xpp.getName().equalsIgnoreCase("title")) {
                        if (insideItem)
                            headlines.add(xpp.nextText());
                    }
                } else if (eventType == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")) {
                    insideItem = false;
                }

                eventType = xpp.next();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return headlines;
    }


public InputStream getInputStream(URL url) {
        try {
            return url.openConnection().getInputStream();
        } catch (IOException e) {
            return null;
        }
    }

    public ArrayList<String> heads() {
        return headlines;
    }
}


//      } else if (xpp.getName().equalsIgnoreCase("li")) {
//          if (insideItem)
//              links.add(xpp.nextText());