package com.android.tabtest;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.ArrayList;


public class Items extends Fragment {
    BaseAdapter adapter;
    GridView gridView;

    public void setAdapter(BaseAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_items, null);
        gridView = (GridView) view.findViewById(R.id.gridview);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        gridView.setAdapter(adapter);
    }
}
