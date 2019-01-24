package com.android.tabtest;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ListViewAdapter extends BaseAdapter implements Filterable{


   private Manager mgr=Manager.getInstance();
   private ArrayList<Mall> mallList =mgr.getData();


   private ArrayList<Mall> filteredList=mallList;


   Filter listFilter;


   public ListViewAdapter(){

   }


   @Override
   public int getCount() {
       return filteredList.size();
   }


   @Override
   public Object getItem(int position) {
       return filteredList.get(position);
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





       Mall mall=filteredList.get(position);


           numberView.setText(String.valueOf(mall.getNum()));
           imageView.setImageResource(mall.getResId());
           nameView.setText(mall.getName());



       return convertView;
   }
   public void addItem(String name,int num,int resId,String url){
       Mall m=new Mall();

       m.setNum(num);
       m.setName(name);
       m.setResId(resId);
       m.setUrl(url);

       mallList.add(m);
   }

   @Override
   public Filter getFilter() {
       if(listFilter==null){
           listFilter=new ListFilter();
       }
       return listFilter;
   }
   private class ListFilter extends Filter{


       @Override
       protected FilterResults performFiltering(CharSequence constraint) {
           FilterResults results=new FilterResults();

           if(constraint==null||constraint.length()==0){ //검색어 없으면 원래 리스트
               results.values=mallList;
               results.count=mallList.size();
           }else{

               ArrayList<Mall> mList=new ArrayList<Mall>();

               for(Mall m:mallList){
                   if(m.getName().contains((constraint.toString())))
                       mList.add(m);
               }
               results.values=mList;
               results.count=mList.size();
           }
           return results;
       }

       @Override
       protected void publishResults(CharSequence constraint, FilterResults results) {
           //업데이트된 리스트뷰
           filteredList=(ArrayList<Mall>)results.values;

           if(results.count>0){ //result가 갱신되었으면
               notifyDataSetChanged(); //데이터 바꾸고
           }else{
               notifyDataSetInvalidated(); //데이터안바꿔도됨
           }
       }
   }
}
