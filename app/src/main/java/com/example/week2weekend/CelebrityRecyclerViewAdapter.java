package com.example.week2weekend;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week2weekend.Celebrity;

import java.util.ArrayList;


public class CelebrityRecyclerViewAdapter extends RecyclerView.Adapter<CelebrityRecyclerViewAdapter.ViewHolder> {
    private ArrayList<Celebrity> celebrityList=new ArrayList<>();

    public CelebrityRecyclerViewAdapter(ArrayList<Celebrity> celebrityList) {
        this.celebrityList=celebrityList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);



        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull CelebrityRecyclerViewAdapter.ViewHolder holder, int position) {
        final Celebrity itemsCelebrity=celebrityList.get(position);
        holder.tvName.setText(celebrityList.get(position).getName());
        holder.tvDob.setText(celebrityList.get(position).getDob());
        holder.tvFav.setText(celebrityList.get(position).getFav());
        holder.btFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }
    public void addCelebrity(Celebrity celebrity){
        celebrityList.add(celebrity);
        this.notifyDataSetChanged();

    }


    @Override
    public int getItemCount() {
        return celebrityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDob;
        TextView tvFav;
        Button btFav;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvDob = itemView.findViewById(R.id.tvDob);
            tvFav = itemView.findViewById(R.id.tvFav);
            btFav=itemView.findViewById(R.id.btMakefavorite);

        }

    }
}
