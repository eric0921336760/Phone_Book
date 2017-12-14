package com.alex.week4_homework;


import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddMemberFragment extends Fragment {
    EditText nickname,phonenumber;
    Button btn;
    public AddMemberFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_add_member, container, false);


        nickname=(EditText)view.findViewById(R.id.Nickname);
        phonenumber=(EditText)view.findViewById(R.id.Phonenumber);
        btn=(Button)view.findViewById(R.id.button);
        return view;
    }
    @Override
    public  void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data.members.add(new Data.Person("",nickname.getText().toString(),phonenumber.getText().toString(), R.drawable.none));
                Toast toast =Toast.makeText(getActivity(),"已新增連絡人",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }






}
