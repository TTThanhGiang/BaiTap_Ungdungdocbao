package com.example.baitap_appdocbao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TinAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Tin> listNews;

    public TinAdapter(Context context, int layout, ArrayList<Tin> listNews) {
        this.context = context;
        this.layout = layout;
        this.listNews = listNews;
    }


    @Override
    public int getCount() {
        return this.listNews.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.tv_title_news = convertView.findViewById(R.id.tv_title_news);
            holder.tv_time_news = convertView.findViewById(R.id.tv_time_news);
//            holder.img = convertView.findViewById(R.id.img_item);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Tin news = listNews.get(position);
        holder.tv_title_news.setText(news.getTitle());
        //holder.img.setImageResource(news.getImg());
        holder.tv_time_news.setText(news.getThoigian());
        return convertView;
    }


    private class ViewHolder{
        TextView tv_title_news,tv_time_news;
        ImageView img;
    }
}
