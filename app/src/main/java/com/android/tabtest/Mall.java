package com.android.tabtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Mall {
    String name;
    int num;  //넘버링
    int resId; //아이콘이미지
    String url;
    int favor=0; //즐겨찾기추가, 0이 기본값, 1이 되면 즐겨찾기추가

    public Mall() {

    }

    public Mall(String name, int num, int resId, String url) {
        this.name = name;
        this.num = num;
        this.resId = resId;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFavor() {
        return favor;
    }

    public void setFavor(int favor) {
        this.favor = favor;
    }
}

