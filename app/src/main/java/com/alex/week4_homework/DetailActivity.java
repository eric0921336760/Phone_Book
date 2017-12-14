package com.alex.week4_homework;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    int position;
    ImageView img;
    EditText name,phone,note;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        Double width = dm.widthPixels * .8;
        Double height = dm.heightPixels * .6;

        getWindow().setLayout(width.intValue(),height.intValue());

        Intent it = getIntent();
        position=it.getIntExtra("position",0);

        img=(ImageView)findViewById(R.id.imageView);
        name=(EditText)findViewById(R.id.nametext);
        phone=(EditText)findViewById(R.id.phonetext);
        note=(EditText)findViewById(R.id.notetext);
        btn=(Button)findViewById(R.id.call);

        img.setImageResource(Data.members.get(position).getimgID());
        name.setText(Data.members.get(position).getNickname());
        phone.setText(Data.members.get(position).getTelephone());
        note.setText(Data.members.get(position).getNote());


    }

    public void Call(View view){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        Uri uri =Uri.parse("tel:"+phone.getText().toString());
        intent.setData(uri);
        startActivity(intent);

    }

    public void Modify(View view){
        //Data.members.set(position,new Data.Person(0,name.getText().toString(),phone.getText().toString(),img.getId()));
        Data.members.get(position).Nickname=name.getText().toString();
        Data.members.get(position).Telephone=phone.getText().toString();
        Data.members.get(position).Note=note.getText().toString();
        //不放圖了生氣氣
        Intent intent = new Intent();
        setResult(0,intent);
        this.finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent();
        setResult(-1,intent);
        this.finish();
        super.onBackPressed();
    }








}
