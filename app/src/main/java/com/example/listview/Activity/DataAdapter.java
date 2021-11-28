package com.example.listview.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.listview.Info.DataAdapterInfo;
import com.example.listview.R;

import java.util.ArrayList;


public class DataAdapter extends ArrayAdapter<DataAdapterInfo.ListItem> {

    private LayoutInflater layoutInflater;

    DataAdapter.ViewHolder holder;
    private class ViewHolder {
        TextView buttonStatus;
        TextView textName;
        TextView detailText;
        LinearLayout textDetailInfo;
        Button displayDetailInfo;
    }

    public DataAdapter(Context context, int resource,
                       ArrayList<DataAdapterInfo.ListItem> items){
        super(context, resource, items);
        this.layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        );
    }
    @Override
    public int getCount() {
        return super.getCount();
    }


    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        //Goi layoutInflater ra de bat dau anh xa data view va data.
//        LayoutInflater inflater = activity.getLayoutInflater();
//
//        //Do du lieu vao bien View, view nay chinh la nhung gi nam trong item_name.xml
//        view = inflater.inflate(R.layout.list_item, null);

        view = layoutInflater.inflate(R.layout.list_item, viewGroup, false);

        //Dat chu cho tung view trong danh sach.
        DataAdapterInfo.ListItem item = (DataAdapterInfo.ListItem) getItem(i);
        holder = new ViewHolder();
        holder.textName = (TextView) view.findViewById(R.id.textName);
        holder.textName.setText(item.name);
        holder.buttonStatus = (TextView) view.findViewById(R.id.buttonStatus);
//        holder.buttonStatus.toString().set
        holder.detailText = (TextView) view.findViewById(R.id.textView_detailList);
        holder.detailText.setText(item.detail);

        holder.displayDetailInfo = (Button) view.findViewById(R.id.displayDetailInfo);
        holder.displayDetailInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ListView)viewGroup).performItemClick(view,i,R.id.displayDetailInfo);
            }
        });

        holder.textDetailInfo = view.findViewById(R.id.include_view).findViewById(R.id.layoutText);
        if(item.Status == 0){
            holder.textDetailInfo.setVisibility(View.GONE);
        }
        else {
            holder.textDetailInfo.setVisibility(View.VISIBLE);
        }

        //Tra ve view ket qua.
        return view;
    }
}