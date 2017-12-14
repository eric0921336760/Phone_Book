package com.alex.week4_homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex on 2017/10/6.
 */

public class Data {
    /**
     * Created by Alex on 2017/10/6.

    public static Person[] Members = {
        new Person(1,"魯夫","0911111111", R.drawable.luffy),
        new Person(2,"索隆","0922222222",R.drawable.zoro),
        new Person(3,"娜美","0933333333",R.drawable.nami)
    };
     */
   // public ArrayList<Person> members = new ArrayList<Person>();

    public static ArrayList<Person> members = new ArrayList<Person>(
            Arrays.asList(
                    new Person("","魯夫","0911111111", R.drawable.luffy),
                    new Person("","索隆","0922222222",R.drawable.zoro),
                    new Person("","娜美","0933333333",R.drawable.nami)
            )
    );
    Data(){

    }

    public static class Person {
        public String Note;
        public String Nickname;
        public String Telephone;
        public int imgID;

        public Person(String note,String nickname,String telephone,int imgId){
            this.Note=note;
            this.Nickname=nickname;
            this.Telephone=telephone;
            this.imgID=imgId;
        }

        String getNote() {return Note;}
        String getNickname(){ return Nickname;}
        String getTelephone(){return Telephone;}
        int getimgID() {return imgID;}

    }
}
