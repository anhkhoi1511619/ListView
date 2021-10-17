package com.example.listview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DataAdapter extends BaseAdapter {

    private Activity activity;
    private String[] items;

    public DataAdapter(Activity activity, String[] items){
        this.activity = activity;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Goi layoutInflater ra de bat dau anh xa data view va data.
        LayoutInflater inflater = activity.getLayoutInflater();

        //Do du lieu vao bien View, view nay chinh la nhung gi nam trong item_name.xml
        view = inflater.inflate(R.layout.item_name, null);

        //Dat chu cho tung view trong danh sach.
        TextView textView = (TextView) view.findViewById(R.id.buttonStatus);
        textView.setText(items[i]);

        //Tra ve view ket qua.
        return view;
    }
}
