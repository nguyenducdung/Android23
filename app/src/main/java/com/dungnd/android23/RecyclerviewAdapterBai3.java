package com.dungnd.android23;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerviewAdapterBai3 extends RecyclerView.Adapter<RecyclerviewAdapterBai3.ItemHoler>{
    private ArrayList<String> array;
    private Context context;
    public RecyclerviewAdapterBai3(Context context,ArrayList<String> array){
        this.context = context;
        this.array = array;
    }
    @NonNull
    @Override
    public ItemHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);
        return new ItemHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHoler holder, @SuppressLint("RecyclerView") int position) {
        String title = array.get(position);
        holder.textViewtitle.setText(title);
        holder.imageViewcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.imageViewedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = holder.textViewtitle.getText().toString();
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog);
                EditText editText = dialog.findViewById(R.id.edt_edit);
                Button buttonhuybo = dialog.findViewById(R.id.btn_cancel);
                Button buttondongy = dialog.findViewById(R.id.btn_dongy);
                editText.setText(title);
                buttonhuybo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                buttondongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String data = editText.getText().toString();
                        holder.textViewtitle.setText(data);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public class ItemHoler extends RecyclerView.ViewHolder {
        private ImageView imageViewedit;
        private ImageView imageViewcancel;
        private TextView textViewtitle;
        public ItemHoler(@NonNull View itemView) {
            super(itemView);
            imageViewedit = itemView.findViewById(R.id.img_edit);
            imageViewcancel = itemView.findViewById(R.id.img_cancel);
            textViewtitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
