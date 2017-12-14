package com.alex.week4_homework;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddMember_Activity extends AppCompatActivity {

    EditText nickname,phonenumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member_);
        Configuration conf =getResources().getConfiguration();
        if(conf.orientation== Configuration.ORIENTATION_LANDSCAPE){
            finish();
        }
        nickname=(EditText)findViewById(R.id.Nickname);
        phonenumber=(EditText)findViewById(R.id.Phonenumber);


    }

    public void add(View view){
         //int position = Data.Members.length;
        Data.members.add(new Data.Person("",nickname.getText().toString(),phonenumber.getText().toString(), R.drawable.none));
         //Data.Members[position]=new Data.Person(position+2,nickname.getText().toString(),phonenumber.getText().toString(), R.drawable.brook);
         Toast toast =Toast.makeText(this,"已新增連絡人",Toast.LENGTH_SHORT);
         toast.show();
         finish();
    }
}
