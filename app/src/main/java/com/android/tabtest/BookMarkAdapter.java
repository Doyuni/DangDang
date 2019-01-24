package com.android.tabtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BookMarkAdapter extends BaseAdapter {
    private Manager mgr=Manager.getInstance();

    ArrayList<Mall> markedList=mgr.getMarkedData();

    @Override
    public int getCount() {
        return markedList.size();
    }

    public void remove(int position){
        markedList.remove(position);
    }

    @Override
    public Object getItem(int position) {
        return markedList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos=position;
        final Context context=parent.getContext();


        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.activity_mall,parent,false);
        }


        ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView);
        TextView numberView=(TextView) convertView.findViewById(R.id.textView);
        TextView nameView=(TextView) convertView.findViewById(R.id.textView2);


        Mall mall=markedList.get(position);



        imageView.setImageResource(mall.getResId());
        nameView.setText(mall.getName());



        return convertView;
    }
}
