package com.dungnd.android23;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ItemHolder>{
    private ArrayList<ItemUser> array;
    private Context context;
    public RecyclerviewAdapter(Context context, ArrayList<ItemUser> array){
        this.context = context;
        this.array = array;
    }
    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        ItemUser itemUser = array.get(position);
        holder.imageViewanh.setImageResource(itemUser.getAnh());
        holder.textViewtitle.setText(itemUser.getTitle());
        holder.textViewfan.setText(itemUser.getFan());
        holder.textViewsobaiviet.setText(itemUser.getBaivietmoinhat());
        holder.textViewnhom.setText(itemUser.getNhom());
        if(itemUser.getNhom() == "nhóm đóng"){
            holder.textViewnhom.setTextColor(ContextCompat.getColor(context, R.color.white));
        }else if(itemUser.getNhom() == "nhóm kín"){
            holder.textViewnhom.setTextColor(ContextCompat.getColor(context, R.color.orange));
        }else if(itemUser.getNhom() == "nhóm mở"){
            holder.textViewnhom.setTextColor(ContextCompat.getColor(context, R.color.blue));
        }
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        ImageView imageViewanh;
        TextView textViewtitle, textViewfan, textViewsobaiviet, textViewnhom;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imageViewanh = itemView.findViewById(R.id.img_anh);
            textViewtitle = itemView.findViewById(R.id.tv_title);
            textViewfan = itemView.findViewById(R.id.tv_fan);
            textViewsobaiviet = itemView.findViewById(R.id.tv_sobaiviet);
            textViewnhom = itemView.findViewById(R.id.tv_nhom);
        }
    }
}
