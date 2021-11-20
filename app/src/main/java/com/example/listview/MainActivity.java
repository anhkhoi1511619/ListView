package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String SETTING_INTENT_FLAG = "isSetting";
    private ListView listView;
    ArrayList<DataAdapterInfo.ListItem> listItems;
    DataAdapterInfo dataAdapterInfo;
    DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.list_view);
        Test(true);
        listItems = dataAdapterInfo.getInstance().getListItems();
        dataAdapter = new DataAdapter(this, 0, listItems);
        listView.setAdapter(dataAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (view.getId()){
                    case R.id.displayDetailInfo:{
                        Intent intent = new Intent(MainActivity.this, WebViewListActivity.class);
                        intent.putExtra(SETTING_INTENT_FLAG, true);
                        startActivity(intent);
                        break;
                    }
                }
            }

        });
    }

    public void Test(boolean isTest){
        //試験用
//        listItems.clear();
        //List1
        DataAdapterInfo.ListItem item = new DataAdapterInfo.ListItem();
        item.no = 100;
        item.Status = 0;
        item.name = "Nguyen Tran Anh Khoi";
        item.detail = "NDS.TS";
        DataAdapterInfo.getInstance().getListItems().add(item);

        //List2
        DataAdapterInfo.ListItem item2 = new DataAdapterInfo.ListItem();
        item2.no = 200;
        item2.Status = 1;
        item2.name = "Le Nguyen Hoang Phi";
        item2.detail = "NDS.TS";
        DataAdapterInfo.getInstance().getListItems().add(item2);
    }
}