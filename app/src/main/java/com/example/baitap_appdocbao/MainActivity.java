package com.example.baitap_appdocbao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvTieuDe;
    ArrayList<Tin> arrayNews;
    TinAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvTieuDe = findViewById(R.id.listviewTieuDe);
        arrayNews = new ArrayList<>();

        new ReadRSS().execute("https://vnexpress.net/rss/the-gioi.rss");
        adapter = new TinAdapter(MainActivity.this, R.layout.custom_listview,arrayNews);
        lvTieuDe.setAdapter(adapter);

        lvTieuDe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,TinActivity.class);
                intent.putExtra("link", arrayNews.get(position).getLink());
                startActivity(intent);
            }
        });
    }

    private class ReadRSS extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(strings[0]);

                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line="";
                while((line = bufferedReader.readLine())!=null){
                    content.append(line);
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {

            }catch (IOException e) {

            }
            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);

            NodeList nodeList = document.getElementsByTagName("item");
            String title = "", thoigian="",mota="", link="";
            int img = 0;
            for(int i = 0;i<nodeList.getLength();i++) {
                Element element = (Element) nodeList.item(i);
                title = parser.getValue(element, "title");
                link = parser.getValue(element, "link");
                thoigian = parser.getValue(element,"pubDate");
                mota = parser.getValue(element,"description");
                link = parser.getValue(element,"link");
                Tin tin = new Tin(title,0,thoigian,mota,link);
                arrayNews.add(tin);
            }
            adapter.notifyDataSetChanged();
        }

    }
}