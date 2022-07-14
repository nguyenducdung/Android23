package com.dungnd.android23.buoi4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dungnd.android23.R;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterBuoi4Bai3 extends RecyclerView.Adapter<AdapterBuoi4Bai3.Buoi4Bai3ViewHolder> {
    private List<Buoi4Bai3> buoi4Bai3List;

    public AdapterBuoi4Bai3(List<Buoi4Bai3> buoi4Bai3List) {
        this.buoi4Bai3List = buoi4Bai3List;
    }

    public List<Buoi4Bai3> getBuoi4Bai3List() {
        return buoi4Bai3List;
    }

    public void setBuoi4Bai3List(List<Buoi4Bai3> buoi4Bai3List) {
        this.buoi4Bai3List = buoi4Bai3List;
    }

    @NonNull
    @Override
    public Buoi4Bai3ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_buoi4_bai3, parent, false);
        return new Buoi4Bai3ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Buoi4Bai3ViewHolder holder, int position) {
        holder.setData(buoi4Bai3List.get(position));
    }

    @Override
    public int getItemCount() {
        return buoi4Bai3List != null ? buoi4Bai3List.size() : 0;
    }

    protected class Buoi4Bai3ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgHinhThuMuc;
        private TextView txtThuMuc;
        private ImageButton imgbSua;
        private ImageButton imgbXoa;
        public Buoi4Bai3ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhThuMuc = itemView.findViewById(R.id.imgHinhThuMuc);
            txtThuMuc = itemView.findViewById(R.id.txtThuMuc);
            imgbSua = itemView.findViewById(R.id.imgbSua);
            imgbXoa = itemView.findViewById(R.id.imgbXoa);
        }

        public void setData(Buoi4Bai3 buoi4Bai3){
            imgHinhThuMuc.setBackgroundResource(buoi4Bai3.getHinhthumuc());
            txtThuMuc.setText(buoi4Bai3.getTenthumuc());
            imgbSua.setBackgroundResource(buoi4Bai3.getHinhsua());
            imgbXoa.setBackgroundResource(buoi4Bai3.getHinhxoa());
        }
    }
}
