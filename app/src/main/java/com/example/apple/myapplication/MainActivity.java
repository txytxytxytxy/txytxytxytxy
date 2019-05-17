package com.example.apple.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.apple.myapplication.CCTV2;
import com.example.apple.myapplication.CCTV3;
import com.example.apple.myapplication.CCTV4;
import com.example.apple.myapplication.R;
import com.example.apple.myapplication.VerticalAdapter;
import com.example.apple.myapplication.cctv1;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static  final String TAG=MainActivity.class.getCanonicalName();
    private List<String> mList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();


    }

    private void initData() {
        mList.add("CCTV1");
        mList.add("cctv2");
        mList.add("cctv3");
        mList.add("cctv4");

    }
    private void initView() {
        VerticalAdapter adapter = new VerticalAdapter(this);
        RecyclerView rcvVertical = findViewById(R.id.rcv_vertical);

        LinearLayoutManager managerVertical = new LinearLayoutManager(this);
        managerVertical.setOrientation(LinearLayoutManager.VERTICAL);

        rcvVertical.setLayoutManager(managerVertical);
        rcvVertical.setHasFixedSize(true);
        rcvVertical.setAdapter(adapter);

        adapter.setVerticalDataList(mList);

        adapter.setOnItemClickListener(new VerticalAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //定义相应的事件逻辑
                switch (position){
                    case 0: {
                        Intent intent1 = new Intent( MainActivity.this, cctv1.class );
                        MainActivity.this.startActivity( intent1 );
                        break;
                    }
                    case 1:{
                        Intent intent2 = new Intent( MainActivity.this, CCTV2.class );
                        MainActivity.this.startActivity( intent2 );
                        break;
                    }
                    case 2:{
                        Intent intent3 = new Intent( MainActivity.this, CCTV3.class );
                        MainActivity.this.startActivity( intent3 );
                        break;
                    }
                    case 3:{
                        Intent intent4 = new Intent( MainActivity.this, CCTV4.class );
                        MainActivity.this.startActivity( intent4 );
                        break;
                    }

                }
            }
        });

    }
}