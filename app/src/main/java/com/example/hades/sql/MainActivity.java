package com.example.hades.sql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
MyDatabase database;
ArrayList<String> ds=new ArrayList<String>();
ListView lv;
Button bt;
EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.listview);
        bt=findViewById(R.id.button);
        et1=findViewById(R.id.editText);
        et2=findViewById(R.id.editText2);
        database=new MyDatabase(MainActivity.this);
        capnhatgiaodien();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noidung=et1.getText().toString();
                String thoigian=et2.getText().toString();
                database.themcongviec(noidung,thoigian);
                capnhatgiaodien();
            }
        });

    }
    public void capnhatgiaodien(){
        ds=database.xemCongViec();
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,ds);
        lv.setAdapter(adapter);
    }
}
