package com.example.goldm.weekfourdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

        final static String LOG_TAG = MainActivity.class.getName().toString();
        String[] mClasses;
        List<String> listClasses;
        Button mBtn;
        TextView mTV;
        LinearLayout mLinearLayout;
        String Str="";
        ListView mLv;
        ArrayAdapter<String> adapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLinearLayout = (LinearLayout) findViewById(R.id.main_layout_id);

        mBtn.setOnClickListener(this::change_name);

        mBtn = new Button(this);
        mBtn.setText("CLick");
        mLinearLayout.addView((mBtn));

        mClasses = getResources().getStringArray(R.array.fsc_bcs_classes);
        mLv = new ListView(this);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listClasses);
        mLinearLayout.addView(mLv);
        mLv.setAdapter(adapter);

        listClasses = new ArrayList<String>(Arrays.asList(mClasses));


        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
               // Toast.makeText(MainActivity.this, "You clicked item number" + i, Toast.LENGTH_SHORT).show();

                listClasses.remove(i);
                adapter.notifyDataSetChanged();
                mLv.invalidateViews();

            }
        });


        mBtn = new Button(this);
        mBtn.setText("CLick");
        mBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mTV.setText("Mike G");
            }


        });


        mLinearLayout.addView((mBtn));

        mTV = (TextView) findViewById(R.id.tv1);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOG_TAG, "this activity is onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOG_TAG, "this activity is onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG, "this activity is onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LOG_TAG, "activity is onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG_TAG, "this activity is onResume");
    }

    public void change_name(View view){
        mTV.setText("Mike");
    }








}
