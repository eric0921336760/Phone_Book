package com.alex.week4_homework;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/*
public class MemberFragment extends Fragment {
    String[] MemberInfo;
    //ArrayList<Data.Person> members;
    public MemberFragment() {
        // Required empty public constructor

        MemberInfo = new String[Data.members.size()];
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       super.onCreateView(inflater,container,savedInstanceState);
        //if(container==null)return null;
        View view =inflater.inflate(R.layout.fragment_member, container, false);

        for(int i=0;i<Data.members.size();i++){
            MemberInfo[i]= Data.members.get(i).getNickname();
        }

        ListView Member_list=(ListView)view.findViewById(R.id.Memberlist);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,MemberInfo);

        Member_list.setAdapter(adapter);

        return view;
    }

}
*/

public class MemberFragment extends Fragment {
    private ListView Member_list;
    //String[] members = new String[] {"明翰","建宇","執恩"};
    String[] MemberInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        //setContentView(R.layout.fragment_member);

        View view =inflater.inflate(R.layout.fragment_member, container, false);

        MemberInfo = new String[Data.members.size()];

        Member_list=(ListView)view.findViewById(R.id.Memberlist);

        MemberInfo_Activity.MyAdapter adaptermembers = new MemberInfo_Activity.MyAdapter(getActivity());



        Member_list.setAdapter(adaptermembers);
        Member_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent it = new Intent();
                it.setClass(getActivity() , DetailActivity.class);
                it.putExtra("position",position);
                startActivityForResult(it,1);
            }
        });

        return view;
    }

}

