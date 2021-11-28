package com.example.listview.Info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VisitListInfo {

    private long visitListId = -1L;

    private ArrayList<VisitDetailItem> detailList;

    Map<Long, ArrayList<VisitDetailItem>> detailMap = new HashMap<>();

    public class VisitDetailItem{
        private long no;

//        private String status;

        private String name;

        private String text;

        public VisitDetailItem(long no, String name, String text){
            this.no = no;
//            this.status = status;
            this.name = name;
            this.text = text;
        }

        public long getNo() {return no; }

        public void setNo(long no) { this.no = no; }

//        public String getStatus() {return status; }

//        public void setStatus(String status) { this.status = status; }

        public String getName() {return name; }

        public void setName(String name) {this.name = name; }

        public String getText() {return text; }

        public void setText(String text) {this.text = text; }
    }
    private static VisitListInfo instance = new VisitListInfo();

    private VisitListInfo() {
        detailList = new ArrayList<>();
    }
    public static VisitListInfo getInstance(){return instance;}


    public ArrayList<VisitDetailItem> getDetailList() {
        return detailList;
    }

    public void setDetailList(ArrayList<VisitDetailItem> detailList) {
        this.detailList = detailList;
    }

    public long getVisitListId() {
        return visitListId;
    }

    public void setVisitListId(long visitListId) {
        this.visitListId = visitListId;
    }

    public void deleteInfo(){detailList.clear();}

    public int getItemIndex(long no){
        int idx = 0;
        VisitDetailItem item = null;
        for (; idx < detailList.size(); idx++){
            item = detailList.get(idx);
            if(item.no == no){
                return idx;
            }
        }
        return -1;
    }

    public Map<Long, ArrayList<VisitDetailItem>> getDetailMap() {
        return detailMap;
    }

    public void setDetailMap(Map<Long, ArrayList<VisitDetailItem>> detailMap) {
        this.detailMap = detailMap;
    }

    public void initDetailMap(){
        detailMap = new HashMap<>();
    }

    public void addDetailMap(long no, ArrayList<VisitDetailItem> list){
        detailMap.put(new Long(no), list);
    }

    public void removeDetailMap(long no){detailMap.remove(new Long(no));}
}
