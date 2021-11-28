package com.example.listview.Info;

import java.util.ArrayList;

public class DataAdapterInfo {

    public long visitListId;
    private ArrayList<ListItem> listItems;

    public static class ListItem{
        public long no;
        public int Status;
        public String name;
        public String detail;
        public long groupNo;
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


    public ArrayList<ListItem> getItems(long no){
        ArrayList<ListItem> list = new ArrayList<>();

        for(ListItem item : listItems){
            if(item.no == no){
                long groupNo = item.groupNo;
                //Group Confirm
                if(groupNo == 0){
                    list.add(item);
                }else{
                    for (ListItem tmp : listItems){
                        if(tmp.groupNo == groupNo){
                            list.add(tmp);
                        }
                    }
                }
            }
        }
        return list;
    }

//    private ListItem getItem(long no)
    /**
     *
     */

}
