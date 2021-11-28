package com.example.listview.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.listview.Info.DataAdapterInfo;
import com.example.listview.Info.VisitListInfo;
import com.example.listview.R;

import java.util.ArrayList;

public class DetailListActivity extends FragmentActivity {


    public static class DetailFragment extends Fragment{
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            View layout = inflater.inflate(R.layout.fragment_info_detail, container, false);

            Bundle bundle = getArguments();
            String title = bundle.getString("title");
            TextView textView = (TextView) layout.findViewById(R.id.textView_detailList);
            textView.setText(title);

            return layout;
        }
    }

    //
    private ViewPager2 viewPager2;
    private ViewPager2 next_viewPager2;
    //
    private static final int NUM_PAPER = 1;
    //
    ArrayList<DataAdapterInfo.ListItem> listItems;
    ArrayList<DataAdapterInfo.ListItem> next_listItems;
    DataAdapterInfo dataAdapterInfo;
    public class DetailViewPaperAdapter extends FragmentStateAdapter {

        private ArrayList<VisitListInfo.VisitDetailItem> mlist ;
        public DetailViewPaperAdapter(FragmentActivity fragmentActivity, ArrayList<VisitListInfo.VisitDetailItem> list){
            super(fragmentActivity);
            this.mlist = list;
        }

        @Override
        public Fragment createFragment(int position) {

            VisitListInfo.VisitDetailItem item = mlist.get(position);
            Bundle bundle = new Bundle();
            bundle.putString("title", item.getName());

            DetailFragment fragment = new DetailFragment();
            fragment.setArguments(bundle);
            return fragment;
        }


        @Override
        public int getItemCount() {
            return mlist.size();
        }
    }
    //
    private DetailViewPaperAdapter adapter;
    private DetailViewPaperAdapter next_adapter;
    private Long visitListNo;
    public static final String KeyListNo = "listNo";
    private ArrayList<VisitListInfo.VisitDetailItem> detailList = new ArrayList<>();
    private ArrayList<VisitListInfo.VisitDetailItem> mDetailListNextPage = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list);

        Intent intent = getIntent();
        visitListNo = (Long) intent.getSerializableExtra(KeyListNo);
//        Test();
//        listItems = dataAdapterInfo.getInstance().getListItems();

        Log.d(DetailListActivity.class.getSimpleName(), "onCreate: ");
        viewPager2 = findViewById(R.id.pager);
        adapter = new DetailViewPaperAdapter(this, detailList);
        viewPager2.setAdapter(adapter);
        getDetailInfo(visitListNo, detailList);
        adapter.notifyDataSetChanged();
        //
        visitListNo += 100;
        next_viewPager2 = findViewById(R.id.nextpaper);
        next_adapter = new DetailViewPaperAdapter(this,mDetailListNextPage);
        next_viewPager2.setAdapter(next_adapter);
        getDetailInfo(visitListNo,mDetailListNextPage);
        next_adapter.notifyDataSetChanged();
        Log.d(DetailListActivity.class.getSimpleName(), "Adapter Created: ");
    }


    private void getDetailInfo(Long visitListNo, ArrayList<VisitListInfo.VisitDetailItem> adapterList){

        ArrayList<DataAdapterInfo.ListItem> list = DataAdapterInfo.getInstance().getItems(visitListNo);

        if(list == null || list.size() == 0){
            return;
        }
        if(visitListNo > 0){
            VisitListInfo.getInstance().setVisitListId(visitListNo);
            VisitListInfo.getInstance().setDetailList(adapterList);

            for (DataAdapterInfo.ListItem tmp : list){
                VisitListInfo.VisitDetailItem item =
                        VisitListInfo.getInstance().new VisitDetailItem(
                                tmp.no,
                                tmp.name,
                                ""
                        );
                adapterList.add(item);
            }
        }
    }

}
