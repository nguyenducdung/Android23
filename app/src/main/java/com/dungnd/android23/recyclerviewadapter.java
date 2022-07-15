package com.dungnd.android23;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerviewadapter extends RecyclerView.Adapter<recyclerviewadapter.itemholer>{
    ArrayList<FileItem> array;
    public recyclerviewadapter(ArrayList<FileItem> array){
        this.array = array;
    }
    @NonNull
    @Override
    public itemholer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout, parent, false);
        return new itemholer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemholer holder, int position) {
        FileItem fileItem = array.get(position);
        holder.textViewfilename.setText(fileItem.getFilename());
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public class itemholer extends RecyclerView.ViewHolder {
        TextView textViewfilename;
        public itemholer(@NonNull View itemView) {
            super(itemView);
            textViewfilename = itemView.findViewById(R.id.tv_filename);
        }
    }
}
