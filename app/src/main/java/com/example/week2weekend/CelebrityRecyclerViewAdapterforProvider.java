package com.example.week2weekend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CelebrityRecyclerViewAdapterforProvider extends RecyclerView.Adapter<CelebrityRecyclerViewAdapterforProvider.ViewHolder> {
    private ArrayList<Celebrity> celebrityList=new ArrayList<>();
    DatabaseHelper databaseHelper ;

    public CelebrityRecyclerViewAdapterforProvider(ArrayList<Celebrity> celebrityList) {
        this.celebrityList=celebrityList;
        if (this.celebrityList==null)celebrityList=new ArrayList<>();
    }
    @NonNull
    @Override
    public CelebrityRecyclerViewAdapterforProvider.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);



        CelebrityRecyclerViewAdapterforProvider.ViewHolder viewHolder=new CelebrityRecyclerViewAdapterforProvider.ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull CelebrityRecyclerViewAdapterforProvider.ViewHolder holder, int position) {
        final Celebrity itemsCelebrity=celebrityList.get(position);
        holder.tvName.setText(celebrityList.get(position).getName());
        holder.tvDob.setText(celebrityList.get(position).getDob());
        holder.tvFav.setText(celebrityList.get(position).getFav());
        holder.btFav.setVisibility(View.GONE);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }
    public void addCelebrity(Celebrity celebrity){
        if (celebrityList==null)celebrityList=new ArrayList<>();
        celebrityList.add(celebrity);
        this.notifyDataSetChanged();

    }


    @Override
    public int getItemCount() {
        if (celebrityList==null) return 0;
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
