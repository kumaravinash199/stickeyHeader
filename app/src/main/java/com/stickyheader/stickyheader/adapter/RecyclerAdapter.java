package com.stickyheader.stickyheader.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.stickyheader.stickyheader.models.Item;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.>{

    RecyclerAdapter(ArrayList<Item> itemList){

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
