package com.dungnd.android23.buoi4;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dungnd.android23.R;

import java.util.List;

public class AdapterBuoi4Bai1 extends RecyclerView.Adapter<AdapterBuoi4Bai1.Buoi4ViewHolder> {
    private List<Buoi4Bai1> buoi4List;

    public AdapterBuoi4Bai1(List<Buoi4Bai1> buoi4List) {
        this.buoi4List = buoi4List;
    }

    public List<Buoi4Bai1> getBuoi4List() {
        return buoi4List;
    }

    public void setBuoi4List(List<Buoi4Bai1> buoi4List) {
        this.buoi4List = buoi4List;
    }

    @NonNull
    @Override
    public Buoi4ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_buoi4, parent, false);

        return new Buoi4ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Buoi4ViewHolder holder, int position) {
        holder.setData(buoi4List.get(position));

    }

    @Override
    public int getItemCount() {
        return buoi4List != null ? buoi4List.size() : 0;
    }




    protected class Buoi4ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgHinh;
        private TextView txtTenNhom;
        private TextView txtFan;
        private TextView txtBaiViet;
        private TextView txtTrangThai;
        public Buoi4ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgHinh = itemView.findViewById(R.id.imgHinh);
            txtTenNhom = itemView.findViewById(R.id.txtTenNhom);
            txtFan = itemView.findViewById(R.id.txtFan);
            txtBaiViet = itemView.findViewById(R.id.txtBaiViet);
            txtTrangThai = itemView.findViewById(R.id.txtTrangThai);

        }

        public void setData(Buoi4Bai1 buoi4){

            imgHinh.setBackgroundResource(buoi4.getHinh());
            txtTenNhom.setText(buoi4.getTennhom());
            txtFan.setText(buoi4.getFan());
            txtBaiViet.setText(buoi4.getBaiviet());
            txtTrangThai.setText(buoi4.getTrangthai());
            if (buoi4.getTrangthai().equals("NHÓM KÍN")){
                txtTrangThai.setTextColor(Color.RED);
            }else if (buoi4.getTrangthai().equals("NHÓM MỞ")){
                txtTrangThai.setTextColor(Color.BLUE);
            }
        }
    }
}
