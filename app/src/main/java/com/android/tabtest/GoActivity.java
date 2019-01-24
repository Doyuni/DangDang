package com.android.tabtest;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class GoActivity extends Activity {

    private static final int BOOKMARK = 101;
    private static Typeface typeface;
    private Manager mgr=Manager.getInstance();
   private  ListView listview;
   private  ListViewAdapter adapter;
   private EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go);



        //어댑터 생성
        adapter=new ListViewAdapter();

        //리스트뷰참조,어댑터 연결
        listview=(ListView)findViewById(R.id.listview);
        search=(EditText)findViewById(R.id.search);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String filterText=s.toString();
//                if(filterText.length()>0){
//                    listview.setFilterText(filterText);
//                }else{
//                    listview.clearTextFilter();
//                }
                ((ListViewAdapter)listview.getAdapter()).getFilter().filter(filterText) ;



            }
        });
        listview.setAdapter(adapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Mall item=(Mall)adapter.getItem(position);
                String url=item.getUrl();
                Intent i= new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);



            }
        });
        registerForContextMenu(listview); //context메뉴 쓰기 위해서는 등록필수
        ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFCC66")));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,BOOKMARK,Menu.NONE,"등록")
                .setIcon(android.R.drawable.ic_input_add)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==BOOKMARK){
            Intent i=new Intent();
            i.setClass(GoActivity.this,BookMark.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(Menu.NONE,BOOKMARK,Menu.NONE,"즐겨찾기추가");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==BOOKMARK){
            AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

            Mall m=mgr.get(info.position);
            m.setFavor(1);

            Intent i=new Intent();
            i.setClass(GoActivity.this,BookMark.class);
            startActivity(i);



            Toast.makeText(this, "즐겨찾기추가되었습니다", Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();
            return true;
        }
        return super.onContextItemSelected(item);
    }


}
