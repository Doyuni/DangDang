package com.android.tabtest;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private ArrayList<Mall> data=new ArrayList<>();
    //싱글톤디자인 패턴
    //1
    private Manager(){



        data.add(new Mall("딸기슈슈",1,R.drawable.ddalki,"http://ddalkishushu.com/"));
        data.add(new Mall("도기몰",2,R.drawable.doggymall,"http://doggymall.co.kr/"));
        data.add(new Mall("플라이퍼피",3,R.drawable.flypuppy,"http://flypuppy.co.kr"));
        data.add(new Mall("졸리",4,R.drawable.joli,"http://joli-chiot.co.kr/"));
        data.add(new Mall("메이크럭키",5,R.drawable.makelucky,"http://www.forpuppy.co.kr/"));
        data.add(new Mall("멜리",6,R.drawable.mely,"http://melymely.com/"));
        data.add(new Mall("피타",7,R.drawable.pita,"http://painintheass.co.kr/"));
        data.add(new Mall("벨르독",8,R.drawable.belledog,"http://www.xn--iq1bu1ij0c.com/"));
        data.add(new Mall("펍왈왈",9,R.drawable.puppywal,"http://www.pupwalwal.com/"));
        data.add(new Mall("못된강아지",10,R.drawable.baddog,"http://xn--939a65mjufk7l9nf.com/"));
        data.add(new Mall("멍뭉이마트",11,R.drawable.mart,"http://painintheass.co.kr/"));
        data.add(new Mall("그린강아지",12,R.drawable.greendog,"http://www.greenpuppy.co.kr/"));
        data.add(new Mall("띠로리",13,R.drawable.ddirori,"http://www.ddirori.co.kr/"));
        data.add(new Mall("슈나리버",14,R.drawable.schnariever,"http://schnariever.co.kr/"));
        // data.add(new Mall("비바펫",7,R.drawable.pita," http://www.vivadogs.co.kr/"));


    }
    //2
    private static Manager instance=new Manager(); //instance는 manager의 객체이름
    //3
    public static Manager getInstance() {
        return instance;
    }

    public void add(Mall m){//메모한개 추가하는 작업
        data.add(m);
    }
    public void add(int index,Mall m){data.add(index,m);}
    public Mall get(int index){
        return data.get(index);
    }
    public void update(int index,Mall m){
        data.set(index,m);
    }
    public void delete(int index){
        data.remove(index);
    }
    public void set(Mall m){m.setFavor(1);}
    public ArrayList<Mall> getData() { //MemoList의 화면에 현재 시점의 data가 뿌려지도록
        return data;
    }
    public ArrayList<Mall>getMarkedData(){
        ArrayList<Mall> markedList=new ArrayList<>();
        for (Mall mall : data) {
            if(mall.getFavor()==1)
               markedList.add(mall);
        }
        for (Mall mall : data) {
            if(mall.getFavor()==0)
                markedList.remove(mall);
        }
       return markedList;
    }

}
