package com.stickyheader.stickyheader.adapter;


import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stickyheader.stickyheader.R;
import com.stickyheader.stickyheader.models.Item;
import com.stickyheader.stickyheader.utils.HeaderItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> implements HeaderItemDecoration.StickyHeaderInterface{

    ArrayList<Item> listItem;
    Context mContext;
    HeaderItemDecoration.StickyHeaderInterface mStickyHeaderInterface;

    @Override
    public int getHeaderPositionForItem(int itemPosition) {
        int headerPosition = 0;
        do {
            if (this.isHeader(itemPosition)) {
                headerPosition = itemPosition;
                break;
            }
            itemPosition -= 1;
        } while (itemPosition >= 0);
        return headerPosition;
    }

    @Override
    public int getHeaderLayout(int headerPosition) {

        return R.layout.item_list_row;

    }

    @Override
    public void bindHeaderData(View header, int headerPosition) {

      Item mItem=listItem.get(headerPosition);
      TextView headerTitle=(TextView)  header.findViewById(R.id.title);
        TextView headerDescription=(TextView)  header.findViewById(R.id.description);
        LinearLayout headerlayoutView=(LinearLayout)header.findViewById(R.id.itemLayout);
        headerTitle.setText(mItem.title);
        headerDescription.setText(mItem.description);
        headerlayoutView.setBackgroundColor(Color.parseColor("#2DA427"));
    }

    @Override
    public boolean isHeader(int itemPosition) {
        if(itemPosition==0 || itemPosition%10==0){
           return true;
        }else{
          return false;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;
        public LinearLayout itemLayout;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            description = (TextView) view.findViewById(R.id.description);
            itemLayout=(LinearLayout)view.findViewById(R.id.itemLayout);
        }
    }


    public RecyclerAdapter(Context context, ArrayList<Item> itemList){
        this.listItem=itemList;
        this.mContext=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Item mItem = listItem.get(position);
        holder.title.setText(mItem.title);
        holder.description.setText(mItem.description);
        if(position==0 || position%10==0){
            holder.itemLayout.setBackgroundColor(Color.parseColor("#2DA427"));
        }else{
            holder.itemLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }
}
