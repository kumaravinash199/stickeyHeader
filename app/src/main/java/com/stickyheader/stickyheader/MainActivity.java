package com.stickyheader.stickyheader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.stickyheader.stickyheader.adapter.RecyclerAdapter;
import com.stickyheader.stickyheader.models.Item;
import com.stickyheader.stickyheader.utils.HeaderItemDecoration;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerAdapter mRecyclerAdapter;
    ArrayList<Item> itemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemArrayList=new ArrayList<Item>();
        mLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,
                false);
        initViews();
        initData();
    }

    public void initViews(){
        mRecyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerAdapter=new RecyclerAdapter(this,itemArrayList);

        HeaderItemDecoration headerItemDecoration =new HeaderItemDecoration(mRecyclerView,(HeaderItemDecoration.StickyHeaderInterface) mRecyclerAdapter);
        mRecyclerView.addItemDecoration(headerItemDecoration);
        mRecyclerView.setAdapter(mRecyclerAdapter);

    }
    public  void initData(){

        for(int i=0;i<100;i++){
            Item mItem= new Item();
            mItem.title="Item at "+i;
            mItem.description="item description at "+i;
            itemArrayList.add(mItem);
        }
        mRecyclerAdapter.notifyDataSetChanged();
    }

}
