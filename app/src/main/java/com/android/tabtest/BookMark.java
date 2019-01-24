package com.android.tabtest;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class BookMark extends Activity {

    private static final int BOOKMARK = 101;
    private Manager mgr = Manager.getInstance();
    private BookMarkAdapter adapter;
    private ListView listview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_mark);

        listview2=(ListView)findViewById(R.id.listview2);

        adapter=new BookMarkAdapter();
        listview2.setAdapter(adapter);

        registerForContextMenu(listview2); //context메뉴 쓰기 위해서는 등록필수
        ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFCC66")));
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(Menu.NONE,BOOKMARK,Menu.NONE,"즐겨찾기삭제");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==BOOKMARK){
            AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

            Mall m=(Mall)adapter.getItem(info.position);
            m.setFavor(0);

            adapter.remove(info.position);


            Toast.makeText(this, "즐겨찾기해제되었습니다", Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}
