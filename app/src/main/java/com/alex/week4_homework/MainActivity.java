package com.alex.week4_homework;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView menu;
    String[] Menu_List= new String[] {"新增連絡人","瀏覽"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Toast toast =Toast.makeText(MainActivity.this,"haha",Toast.LENGTH_SHORT);
        // toast.show();

        menu=(ListView)findViewById(R.id.Menu);

        ArrayAdapter<String> adapter_menu  = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,Menu_List);

        menu.setAdapter(adapter_menu);

        menu.setOnItemClickListener(menu_listener);
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


    }




    private ListView.OnItemClickListener menu_listener =
            new ListView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view , int position, long id){
                    Intent it = new Intent();
                    Configuration conf =getResources().getConfiguration();
                   switch (position){
                       case 0:
                            //點選新增連絡人
                           if(conf.orientation==Configuration.ORIENTATION_PORTRAIT){
                               //直的
                               it.setClass(MainActivity.this , AddMember_Activity.class);
                               startActivity(it);
                           }
                           else {
                               // 橫的
                                AddMemberFragment addMemberFragment = new AddMemberFragment();
                                FragmentManager fragmentManager =getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.framelayout,addMemberFragment);
                                fragmentTransaction.commit();

                           }
                           break;

                       case 1:
                           //點選瀏覽

                           if(conf.orientation==Configuration.ORIENTATION_PORTRAIT){
                               //直的
                               it.setClass(MainActivity.this , MemberInfo_Activity.class);
                               startActivity(it);
                           }
                           else {
                               // 橫的
                               MemberFragment memberFragment = new MemberFragment();
                               FragmentManager fragmentManager =getSupportFragmentManager();
                               FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                               fragmentTransaction.replace(R.id.framelayout,memberFragment);
                               fragmentTransaction.commit();
                           }

                           break;
                   }

                }
            };
}
