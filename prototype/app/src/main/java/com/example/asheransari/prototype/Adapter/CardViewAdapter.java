package com.example.asheransari.prototype.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.asheransari.prototype.Variable.CardViewVariables;
import com.example.asheransari.prototype.Activities.CheckOut;
import com.example.asheransari.prototype.R;

import java.util.ArrayList;

/**
 * Created by asher.ansari on 5/19/2017.
 */

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.itemViewHolder> {

    private ArrayList<CardViewVariables> arrayList = new ArrayList<>();
    private Context mContext;

    public CardViewAdapter(Context c, ArrayList<CardViewVariables> arrayList) {
        this.mContext = c;
        this.arrayList = arrayList;
    }

    @Override
    public itemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, null);
        itemViewHolder card_item = new itemViewHolder(v);
        return card_item;
    }

    @Override
    public void onBindViewHolder(itemViewHolder holder, int position) {
        CardViewVariables cardViewVariables = arrayList.get(position);


        holder.mTextView.setText(cardViewVariables.getDetails());

        Glide.with(mContext)
                .load(cardViewVariables.getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

//    @Override
//    public void onClick(View view) {
//        Toast.makeText(mContext, "this "+arrayList.get().getMoreDetails(), Toast.LENGTH_SHORT).show();
//    }


    public class itemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView mImageView;
        private TextView mTextView;

        public itemViewHolder(final View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image_cardView);
            mTextView = (TextView) itemView.findViewById(R.id.item_name_card);
//            Intent i = new Intent(itemView.getContext(),CheckOut.class);
//            i.putExtra("detail",arrayList.get(getAdapterPosition()).getMoreDetails());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(), "" + mTextView.getText(), Toast.LENGTH_SHORT).show();
                }
            });
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            Toast.makeText(mContext, ""+getPosition(), Toast.LENGTH_SHORT).show();
            Intent i = new Intent(view.getContext(),CheckOut.class);
//            view.startACtivity
//            i.putExtra()
            CardViewVariables cardViewVariables =arrayList.get(getPosition());
//            Bundle args = new Bundle();
            i.putExtra("data",cardViewVariables);
            view.getContext().startActivity(i);

        }
        public void getPosition(int postion)
        {
            Intent i = new Intent(itemView.getContext(),CheckOut.class);

        }
    }


}

