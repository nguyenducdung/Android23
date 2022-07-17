package com.dungnd.android23.buoi4bai3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dungnd.android23.R;

import java.util.List;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.FolderViewHolder> {

    private List<Folder> mListFolder;

    public FolderAdapter(List<Folder> mListFolder) {
        this.mListFolder = mListFolder;
    }

    @NonNull
    @Override
    public FolderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_folder,parent,false);

        return new FolderViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull FolderViewHolder holder, int position) {
        Folder folder = mListFolder.get(position);
        if (folder == null){
            return;
        }
        holder.tvName.setText(folder.getTv_name());
    }


    @Override
    public int getItemCount() {

        return mListFolder != null ? mListFolder.size() : 0;
    }

    protected class FolderViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName;

        public FolderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);

        }
    }
}
