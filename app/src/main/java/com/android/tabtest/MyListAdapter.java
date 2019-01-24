package com.android.tabtest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {
    Context context;
    ArrayList<ItemObject> list_itemArrayList;

    ViewHolder viewHolder;
    class ViewHolder {
        ImageView item_img;
        TextView item_name;
        TextView item_price;
        CardView card_view;
    }

    public MyListAdapter(Context context, ArrayList<ItemObject> list_itemArrayList) {
        this.context = context;
        this.list_itemArrayList = list_itemArrayList;
    }

    @Override
    public int getCount() {
        return this.list_itemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return list_itemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
            viewHolder = new ViewHolder();
            viewHolder.item_img = (ImageView)convertView.findViewById(R.id.item_img);
            viewHolder.item_name = (TextView)convertView.findViewById(R.id.item_name);
            viewHolder.item_price= (TextView)convertView.findViewById(R.id.item_price);
            viewHolder.card_view = (CardView)convertView.findViewById(R.id.card_view);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        final ItemObject list = list_itemArrayList.get(position);
        viewHolder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(list.getLink()));
                i.addCategory(Intent.CATEGORY_DEFAULT);
                context.startActivity(i);
            }
        });
        Glide.with(context).load(list_itemArrayList.get(position).getImage()).into(viewHolder.item_img);
        viewHolder.item_name.setText(list_itemArrayList.get(position).getName());
        viewHolder.item_name.setSelected(true);
        viewHolder.item_price.setText(list_itemArrayList.get(position).getPrice());
        return convertView;
    }
}