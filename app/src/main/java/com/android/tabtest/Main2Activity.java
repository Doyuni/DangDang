package com.android.tabtest;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main2Activity extends Activity {
    ArrayList<ItemObject> mydata;
    MyListAdapter adapter;

    private class CheckTypesTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog asyncDialog = new ProgressDialog(
                Main2Activity.this);

        @Override
        protected void onPreExecute() {
            asyncDialog.setMessage("주인님 기다려주세요!");
            asyncDialog.show();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            asyncDialog.dismiss();
            super.onPostExecute(result);
        }
    }
    CheckTypesTask task;

    class ClothTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mydata.clear();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                ItemObject l;
                int count = 0;
                String s = "http:";
                String d = "http://ddalkishushu.com";
                Document doc = Jsoup.connect("http://ddalkishushu.com/category/top/25/").get();
                Elements els = doc.select("div.xans-product-listrecommend > ul > li.xans-record-");
                for (Element e : els) {
                    if (count == 2) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s + e.select("img").attr("src"), e.select("p.name span+span").text(), e.select("ul > li:nth-child(1) > span").text(), d + e.select("a").first().attr("href"));
                    mydata.add(l);
                }
                doc = Jsoup.connect("http://ddalkishushu.com/category/dress/26/").get();
                els = doc.select("div.xans-product-listrecommend > ul > li.xans-record-");
                for (Element e : els) {
                    if (count == 2) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s + e.select("img").attr("src"), e.select("p.name span+span").text(), e.select("ul > li:nth-child(1) > span").text(), d + e.select("a").first().attr("href"));
                    mydata.add(l);
                }
                doc = Jsoup.connect("http://ddalkishushu.com/category/all-in-one/27/").get();
                els = doc.select("div.xans-product-listrecommend > ul > li.xans-record-");
                for (Element e : els) {
                    if(count ==2) {
                        count =0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s+e.select("img").attr("src"), e.select("p.name span+span").text(), e.select("ul > li:nth-child(1) > span").text(), d+e.select("a").first().attr("href"));
                    mydata.add(l);
                }
                /**/
                d = "http://flypuppy.co.kr";
                doc = Jsoup.connect("http://flypuppy.co.kr/product/list.html?cate_no=4").get();
                els = doc.select(".grid3 > li.xans-record-");
                for (Element e : els) {
                    if (count == 2) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s + e.select("img").attr("src"), e.select("strong.name span+span").text(), e.select("ul li:nth-child(2) strong + span").text(), d + e.select("a").first().attr("href"));
                    mydata.add(l);
                }
                doc = Jsoup.connect("http://flypuppy.co.kr/product/list.html?cate_no=26").get();
                els = doc.select(".grid3 > li.xans-record-");
                for (Element e : els) {
                    if (count == 2) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s + e.select("img").attr("src"), e.select("strong.name span+span").text(), e.select("ul li:nth-child(2) strong + span").text(), d + e.select("a").first().attr("href"));
                    mydata.add(l);
                }
                doc = Jsoup.connect("http://flypuppy.co.kr/product/list.html?cate_no=31").get();
                els = doc.select(".grid3 > li.xans-record-");
                for (Element e : els) {
                    if(count ==2) {
                        count =0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s+e.select("img").attr("src"), e.select("strong.name span+span").text(), e.select("ul li:nth-child(2) strong + span").text(), d+e.select("a").first().attr("href"));
                    mydata.add(l);
                }
                doc = Jsoup.connect("http://flypuppy.co.kr/product/list.html?cate_no=7").get();
                els = doc.select(".grid3 > li.xans-record-");
                for (Element e : els) {
                    if(count ==2) {
                        count =0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s+e.select("img").attr("src"), e.select("strong.name span+span").text(), e.select("ul li:nth-child(2) strong + span").text(), d+e.select("a").first().attr("href"));
                    mydata.add(l);
                }
                doc = Jsoup.connect("http://flypuppy.co.kr/product/list.html?cate_no=27").get();
                els = doc.select(".grid3 > li.xans-record-");
                for (Element e : els) {
                    if(count ==2) {
                        count =0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s+e.select("img").attr("src"), e.select("strong.name span+span").text(), e.select("ul li:nth-child(2) strong + span").text(), d+e.select("a").first().attr("href"));
                    mydata.add(l);
                }

                /**/
                doc = Jsoup.connect("http://www.forpuppy.co.kr/goods/goods_list.php?cateCd=010&sort=&pageNum=6").get();
                els = doc.select("div.item_gallery_type > ul > li");
                for (Element e : els) {
                    if (count == 2) {
                        count = 0;
                        break;
                    }
                    count++;
                    s = "http://www.forpuppy.co.kr";
                    l = new ItemObject(s + e.select("img").attr("src"), e.select("img").attr("alt"), e.select("div > div.item_info_cont > div.item_money_box > strong > span").text(), s + e.select("a").first().attr("href"));
                    mydata.add(l);
                }
                s = "http:";
                d = "http://painintheass.co.kr";
                doc = Jsoup.connect("http://painintheass.co.kr/product/list.html?cate_no=24").get();
                els = doc.select("ul.column3 > li");
                for (Element e : els) {
                    if (count == 2) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s + e.select("img").attr("src"), e.select("p > strong > a > span:nth-child(2)").text(), e.select("ul > li > span:nth-child(2)").text(), d + e.select("a").attr("href"));
                    mydata.add(l);
                }
                s = "http:";
                d = "http://www.vivadogs.co.kr";
                doc = Jsoup.connect("http://www.vivadogs.co.kr/product/list.html?cate_no=79").get();
                els = doc.select("ul.column5 > li");
                for (Element e : els) {
                    if (count == 2) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s + e.select("img").attr("src"), e.select("p > strong > a > span:nth-child(2)").text(), e.select("ul > li:nth-child(1) > span:nth-child(2)").text(), d + e.select("a").attr("href"));
                    mydata.add(l);
                }
                s = "http:";
                d = "http://www.pupwalwal.com";
                doc = Jsoup.connect("http://www.pupwalwal.com/category/wear/25/").get();
                els = doc.select("ul.grid4 > li");
                for (Element e : els) {
                    if (count == 4) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s + e.select("a > img").attr("src"), e.select("a > img").attr("alt"), e.select("ul > li:nth-child(2) > span:nth-child(2)").text(), d + e.select("a").attr("href"));
                    mydata.add(l);
                }

                d = "http://www.greenpuppy.co.kr";
                doc = Jsoup.connect("http://www.greenpuppy.co.kr/shop/?cate=12").get();
                els = doc.select("body > div:nth-child(7) > div > div > div > table > tbody > tr > td[align=center]");
                for (Element e : els) {
                    if (count == 6) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(d+ e.select("div > a > div > img").attr("src"), e.select("div > a > div > img").attr("alt"), e.select("div:nth-child(3) > table > tbody > tr > td:nth-child(1) > div").text(), d + e.select("div > a").attr("href"));
                    mydata.add(l);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.notifyDataSetChanged();
        }
    }

    class FoodTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mydata.clear();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                ItemObject l;
                int count = 0;
                String s = "http:";
                String d = "http://melymely.com";
                Document doc = Jsoup.connect("http://melymely.com/category/%EB%A9%9C%EB%A6%AC%EC%B8%84-%EC%88%98%EC%A0%9C%EA%B0%84%EC%8B%9D/592/").get();
                Elements els = doc.select("div.-items > div.xans-record-");
                for (Element e : els) {
                    if (count == 2) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s + e.attr("data-small"), e.select("div.-detail a span+span").text(), e.attr("data-price") + "원", d + e.attr("data-href"));
                    mydata.add(l);
                }

                d = "http://www.vivadogs.co.kr";
                doc = Jsoup.connect("http://www.vivadogs.co.kr/product/list.html?cate_no=44").get();
                els = doc.select("ul.column5 > li");
                for (Element e : els) {
                    if (count == 4) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(e.select("img").attr("src"), e.select("p > strong > a > span:nth-child(2)").text(), e.select("ul > li:nth-child(1) > span:nth-child(2)").text(), d + e.select("a").attr("href"));
                    mydata.add(l);
                }
                d = "http://벨르독.com";
                doc = Jsoup.connect("http://xn--iq1bu1ij0c.com/goods/goods_list.php?cateCd=005").get();
                els = doc.select("div.item_gallery_type > ul > li");
                for (Element e : els) {
                    if(count ==4) {
                        count =0;
                        break;
                    }
                    count++;
                    l = new ItemObject(d+e.select("img").attr("src"), e.select("img").attr("alt"), e.select("div.item_money_box > strong > span").text(), d+e.select("a").attr("href"));
                    mydata.add(l);
                }
                s = "http:";
                d = "http://www.pupwalwal.com";
                doc = Jsoup.connect("http://www.pupwalwal.com/category/%EC%82%AC%EB%A3%8C/102/").get();
                els = doc.select("ul.grid4 > li");
                for (Element e : els) {
                    if (count == 4) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s + e.select("a > img").attr("src"), e.select("a > img").attr("alt"), e.select("ul > li:nth-child(2) > span:nth-child(2)").text(), d + e.select("a").attr("href"));
                    mydata.add(l);
                }
                s = "http:";
                d = "http://www.mmemart.com";
                doc = Jsoup.connect("http://www.mmemart.com/product/list.html?cate_no=258").get();
                els = doc.select("ul.grid4 > li");
                for (Element e : els) {
                    if (count == 4) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s+ e.select("div > a > img").attr("src"), e.select("div > a > img").attr("alt"), e.select("ul > li > span:nth-child(2)").text(), d + e.select("div > a").attr("href"));
                    mydata.add(l);
                }
                s = "http:";
                d = "http://www.mmemart.com";
                doc = Jsoup.connect("http://www.mmemart.com/product/list.html?cate_no=26").get();
                els = doc.select("ul.grid4 > li");
                for (Element e : els) {
                    if (count == 4) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s+ e.select("div > a > img").attr("src"), e.select("div > a > img").attr("alt"), e.select("ul > li > span:nth-child(2)").text(), d + e.select("div > a").attr("href"));
                    mydata.add(l);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.notifyDataSetChanged();
        }
    }

    class HouseTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mydata.clear();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                ItemObject l;
                int count = 0;
                String s = "http:";
                String d = "http://melymely.com";

                Document doc = Jsoup.connect("http://melymely.com/category/%EC%BF%A0%EC%85%98%ED%95%98%EC%9A%B0%EC%8A%A4/281/").get();
                Elements els = doc.select("div.-items > div.xans-record-");
                for (Element e : els) {
                    if (count == 2) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s + e.attr("data-small"), e.select("div.-detail a span+span").text(), e.attr("data-price") + "원", d + e.attr("data-href"));
                    mydata.add(l);
                }

                d = "http://www.vivadogs.co.kr";
                doc = Jsoup.connect("http://www.vivadogs.co.kr/product/list.html?cate_no=52").get();
                els = doc.select("ul.column5 > li");
                for (Element e : els) {
                    if (count == 4) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(e.select("img").attr("src"), e.select("p > strong > a > span:nth-child(2)").text(), e.select("ul > li:nth-child(1) > span:nth-child(2)").text(), d + e.select("a").attr("href"));
                    mydata.add(l);
                }

                s = "http:";
                d = "http://www.pupwalwal.com";
                doc = Jsoup.connect("http://www.pupwalwal.com/category/%ED%95%98%EC%9A%B0%EC%8A%A4/60/").get();
                els = doc.select("ul.grid4 > li");
                for (Element e : els) {
                    if (count == 4) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s + e.select("a > img").attr("src"), e.select("a > img").attr("alt"), e.select("ul > li:nth-child(2) > span:nth-child(2)").text(), d + e.select("a").attr("href"));
                    mydata.add(l);
                }
                s = "http:";
                d = "http://www.mmemart.com";
                doc = Jsoup.connect("http://www.mmemart.com/product/list.html?cate_no=357#none").get();
                els = doc.select("ul.grid4 > li");
                for (Element e : els) {
                    if (count == 6) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s+ e.select("div > a > img").attr("src"), e.select("div > a > img").attr("alt"), e.select("ul > li > span:nth-child(2)").text(), d + e.select("div > a").attr("href"));
                    mydata.add(l);
                }

                d = "http://www.greenpuppy.co.kr";
                doc = Jsoup.connect("http://www.greenpuppy.co.kr/shop/?cate=13").get();
                els = doc.select("body > div:nth-child(7) > div > div > div > table > tbody > tr > td[align=center]");
                for (Element e : els) {
                    if (count == 6) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(d+ e.select("div > a > div > img").attr("src"), e.select("div > a > div > img").attr("alt"), e.select("div:nth-child(3) > table > tbody > tr > td:nth-child(1) > div").text(), d + e.select("div > a").attr("href"));
                    mydata.add(l);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.notifyDataSetChanged();
        }
    }

    class ToyTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mydata.clear();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                ItemObject l;
                int count = 0;
                String s = "http:";
                String d = "http://melymely.com";
                Document doc = Jsoup.connect("http://melymely.com/category/%EC%9E%A5%EB%82%9C%EA%B0%90/46/").get();
                Elements els = doc.select("div.-items > div.xans-record-");
                for (Element e : els) {
                    if (count == 2) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s + e.attr("data-small"), e.select("div.-detail a span+span").text(), e.attr("data-price") + "원", d + e.attr("data-href"));
                    mydata.add(l);
                }
                d = "http://www.vivadogs.co.kr";
                doc = Jsoup.connect("http://www.vivadogs.co.kr/product/list.html?cate_no=71").get();
                els = doc.select("ul.column5 > li");
                for (Element e : els) {
                    if (count == 4) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(e.select("img").attr("src"), e.select("p > strong > a > span:nth-child(2)").text(), e.select("ul > li:nth-child(1) > span:nth-child(2)").text(), d + e.select("a").attr("href"));
                    mydata.add(l);
                }
                d = "http://벨르독.com";
                doc = Jsoup.connect("http://xn--iq1bu1ij0c.com/goods/goods_list.php?cateCd=008").get();
                els = doc.select("div.item_gallery_type > ul > li");
                for (Element e : els) {
                    if(count ==4) {
                        count =0;
                        break;
                    }
                    count++;
                    l = new ItemObject(d+e.select("img").attr("src"), e.select("img").attr("alt"), e.select("div.item_money_box > strong > span").text(), d+e.select("a").attr("href"));
                    mydata.add(l);
                }

                s = "http:";
                d = "http://www.mmemart.com";
                doc = Jsoup.connect("http://www.mmemart.com/product/list.html?cate_no=422").get();
                els = doc.select("ul.grid4 > li");
                for (Element e : els) {
                    if (count == 6) {
                        count = 0;
                        break;
                    }
                    count++;
                    l = new ItemObject(s+ e.select("div > a > img").attr("src"), e.select("div > a > img").attr("alt"), e.select("ul > li > span:nth-child(2)").text(), d + e.select("div > a").attr("href"));
                    mydata.add(l);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.notifyDataSetChanged();
        }
    }

    ActionBar.Tab[] ta = new ActionBar.Tab[4];

    ActionBar abar;
    int width;
    float prex;
    int pos;

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            prex = event.getX();
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            if (event.getX() - prex < -width) {
                pos = (pos + 1) % 4;
                abar.selectTab(ta[pos]);
            } else if (event.getX() - prex > width) {
                pos = ((pos - 1 < 0) ? 3 : (pos - 1)) % 4;
                abar.selectTab(ta[pos]);
            }
        }
        return super.dispatchTouchEvent(event);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mydata = new ArrayList<>();
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x / 3;

        abar = getActionBar();

        abar.setDisplayShowHomeEnabled(false);
        abar.setDisplayShowTitleEnabled(false);
        abar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab cloth_tab = abar.newTab();
        ta[0] = cloth_tab;
        cloth_tab.setIcon(R.drawable.clothes);
//        cloth_tab.setText("Clothes");
        TabTestListener<Items> a = new TabTestListener<>(this, "0", Items.class);
        cloth_tab.setTabListener(a);

        ActionBar.Tab food_tab = abar.newTab();
        ta[1] = food_tab;
        food_tab.setIcon(R.drawable.food);
//        food_tab.setText("Food");
        TabTestListener<Items> b = new TabTestListener<>(this, "1", Items.class);
        food_tab.setTabListener(b);

        ActionBar.Tab house_tab = abar.newTab();
        ta[2] = house_tab;
        house_tab.setIcon(R.drawable.house);
//        house_tab.setText("House");
        TabTestListener<Items> c = new TabTestListener<>(this, "2", Items.class);
        house_tab.setTabListener(c);

        ActionBar.Tab toy_tab = abar.newTab();
        ta[3] = toy_tab;
        toy_tab.setIcon(R.drawable.toy);
        TabTestListener<Items> d = new TabTestListener<>(this, "3", Items.class);
        toy_tab.setTabListener(d);

        abar.addTab(cloth_tab);
        abar.addTab(food_tab);
        abar.addTab(house_tab);
        abar.addTab(toy_tab);

        abar.selectTab(cloth_tab); // 첫 화면
        pos = abar.getSelectedNavigationIndex();


    }

    class TabTestListener<T extends Fragment> implements ActionBar.TabListener {
        private Fragment mFragment;
        private final Activity mActivity;
        private final String mTag;
        private final Class<T> mClass;

        public TabTestListener(Activity activity, String tag, Class<T> clz) {
            mActivity = activity;
            mTag = tag;
            mClass = clz;
        }

        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

                task = new CheckTypesTask();
            if (mTag.equals("0")) {
                new ClothTask().execute();
                task.execute();
                pos = 0;
            } else if (mTag.equals("1")) {
                new FoodTask().execute();
                task.execute();
                pos = 1;
            } else if (mTag.equals("2")) {
                new HouseTask().execute();
                task.execute();
                pos = 2;
            } else {
                new ToyTask().execute();
                task.execute();
                pos = 3;
            }
            adapter = new MyListAdapter(mActivity, mydata);
            mFragment = Fragment.instantiate(mActivity, mClass.getName());
            ((Items) mFragment).setAdapter(adapter);
            ft.add(android.R.id.content, mFragment, mTag);
        }

        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            if (mFragment != null) {
                ft.detach(mFragment);
            }
        }

        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }
    }
}
