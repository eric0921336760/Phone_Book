package com.alex.week4_homework;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MemberInfo_Activity extends AppCompatActivity {
    private ListView Member_list;
    //String[] members = new String[] {"明翰","建宇","執恩"};
    String[] MemberInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberinfo);


        MemberInfo = new String[Data.members.size()];


        Configuration conf =getResources().getConfiguration();
        if(conf.orientation== Configuration.ORIENTATION_LANDSCAPE){
            finish();
        }
        Member_list=(ListView)findViewById(R.id.Memberlist);

        //ArrayAdapter<String> adaptermembers = new ArrayAdapter<String>(
                //this,android.R.layout.simple_list_item_1,members);

        MyAdapter adaptermembers = new MyAdapter(this);

        Member_list.setAdapter(adaptermembers);
        Member_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent it = new Intent();
                it.setClass(MemberInfo_Activity.this , DetailActivity.class);
                it.putExtra("position",position);
                startActivityForResult(it,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode==1){
            if(resultCode==0){
                 this.finish();
            }
            else if(resultCode == -1){

            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    public static class MyAdapter extends BaseAdapter{
        private LayoutInflater myInflater;
        public MyAdapter(Context c){
            myInflater = LayoutInflater.from(c);
        }
        @Override
        public int getCount(){
            return Data.members.size();
        }
        @Override
        public Object getItem(int position){
            return Data.members.get(position);
        }
        @Override
        public long getItemId(int position){
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            convertView = myInflater.inflate(R.layout.list_memberinfo,null);
            ImageView photo = (ImageView)convertView.findViewById(R.id.photo);
            TextView nickname = (TextView)convertView.findViewById(R.id.nickname);
            TextView phonenumber = (TextView)convertView.findViewById(R.id.phonenumber);
            photo.setImageResource(Data.members.get(position).getimgID());
            nickname.setText(Data.members.get(position).getNickname());
            phonenumber.setText(Data.members.get(position).getTelephone());


            return convertView;
        }


    }


}
