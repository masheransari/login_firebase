package com.example.asheransari.prototype.Adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asheransari.prototype.Variable.CardViewVariables;
import com.example.asheransari.prototype.Variable.MainRecyclerViewVariables;
import com.example.asheransari.prototype.R;

import java.util.ArrayList;

/**
 * Created by asher.ansari on 5/19/2017.
 */

public class RecyclerViewMainAdapter extends RecyclerView.Adapter<RecyclerViewMainAdapter.ItemViewHolder> {

    private ArrayList<MainRecyclerViewVariables> arrayList;
    private Context mContext;
/*    private onItemClickInterface itemClickInterface;*/

    public RecyclerViewMainAdapter(Context mContext, ArrayList<MainRecyclerViewVariables> arrayList) {
        this.arrayList = arrayList;
        this.mContext = mContext;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, null);
//        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null);
        ItemViewHolder itemViewHolder = new ItemViewHolder(v);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        String name = null;
        name = arrayList.get(position).getTitle();
        ArrayList<CardViewVariables> cardViewVariablesArrayList = arrayList.get(position).getCardViewItemArrayList();
        holder.titleView.setText(name);

        //yeha ab cardView ka adapter aye ga..
        CardViewAdapter cardViewAdapter = new CardViewAdapter(mContext,cardViewVariablesArrayList);
        holder.mCardViewRecyclerView.setHasFixedSize(true);
        holder.mCardViewRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        holder.mCardViewRecyclerView.setAdapter(cardViewAdapter);


        holder.mCardViewRecyclerView.setNestedScrollingEnabled(false);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
//    public void setClickListner(onItemClickInterface clickListner)
//    {
//        this.itemClickInterface = clickListner;
//    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView titleView;
        private RecyclerView mCardViewRecyclerView;

        public ItemViewHolder(View view) {
            super(view);
            this.titleView = (TextView) view.findViewById(R.id.producttitleName);
            this.mCardViewRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerCardView);
        }

    }
}
