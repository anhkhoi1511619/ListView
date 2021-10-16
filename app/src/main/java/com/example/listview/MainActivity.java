package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] items = {"Nguyen Tran Anh Khoi", "Le Nguyen Hoang Phi", "Nguyen Van Phuong"};

        listView = (ListView) findViewById(R.id.list_view);

        DataAdapter adapter = new DataAdapter(this,items);
        listView.setAdapter(adapter);
    }
}