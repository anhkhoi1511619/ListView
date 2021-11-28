package com.example.listview.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listview.Info.DataAdapterInfo;
import com.example.listview.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String SETTING_INTENT_FLAG = "isSetting";
    private ListView listView;
    ArrayList<DataAdapterInfo.ListItem> listItems;
    DataAdapterInfo dataAdapterInfo;
    DataAdapter dataAdapter;
    public static final String KeyListNo = "listNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(MainActivity.class.getSimpleName(), "onCreate: ");


        listView = (ListView) findViewById(R.id.list_view);
        Test();
        listItems = dataAdapterInfo.getInstance().getListItems();
        dataAdapter = new DataAdapter(this, 0, listItems);
        listView.setAdapter(dataAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (view.getId()){
                    case R.id.displayDetailInfo:{
                        Log.d(MainActivity.class.getSimpleName(), "onItemClick: ");
                        DataAdapterInfo.ListItem item = listItems.get(i);
                        Intent intent = new Intent(MainActivity.this, DetailListActivity.class);
                        intent.putExtra(SETTING_INTENT_FLAG, true);
                        intent.putExtra(KeyListNo, item.no);
                        startActivity(intent);
                        break;
                    }
                }
            }

        });
    }

    public void Test(){
        //試験用
//        listItems.clear();
        //List1
        DataAdapterInfo.ListItem item = new DataAdapterInfo.ListItem();
        item.no = 100;
        item.Status = 0;
        item.name = "Nguyen Tran Anh Khoi";
        item.detail = "NDS.TS";
        item.groupNo = 1;
        DataAdapterInfo.getInstance().getListItems().add(item);


        //List2
        DataAdapterInfo.ListItem item2 = new DataAdapterInfo.ListItem();
        item2.no = 200;
        item2.Status = 1;
        item2.name = "Le Nguyen Hoang Phi";
        item2.detail = "NDS.TS";
        item2.groupNo = 1;
        DataAdapterInfo.getInstance().getListItems().add(item2);


        DataAdapterInfo.ListItem item3 = new DataAdapterInfo.ListItem();
        item3.no = 300;
        item3.Status = 2;
        item3.name = "Tran Le Tuong Vy";
        item3.detail = "NDS.TS";
        item3.groupNo = 3;
        DataAdapterInfo.getInstance().getListItems().add(item3);


        //
        DataAdapterInfo.ListItem item4 = new DataAdapterInfo.ListItem();
        item4.no = 400;
        item4.Status = 4;
        item4.name = "Nguyen Van Diem";
        item4.detail = "NDS.TS";
        item4.groupNo = 4;
        DataAdapterInfo.getInstance().getListItems().add(item4);
    }
}