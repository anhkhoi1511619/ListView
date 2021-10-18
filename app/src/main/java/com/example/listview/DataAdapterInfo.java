package com.example.listview;

import java.util.ArrayList;

public class DataAdapterInfo {

    private ArrayList<ListItem> listItems;

    public static class ListItem{
        public long no;
        public int Status;
        public String name;
        public String detail;
//        public DataAdapterInfo dataAdapterInfo = new DataAdapterInfo();
    }

    private static DataAdapterInfo instance = new DataAdapterInfo();
    public static DataAdapterInfo getInstance(){
        return instance;
    }

    private DataAdapterInfo(){
        listItems = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public ArrayList<ListItem> getListItems() {
        return listItems;
    }


    /**
     *
     */

}
