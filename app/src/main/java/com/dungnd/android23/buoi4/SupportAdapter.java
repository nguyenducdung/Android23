package com.dungnd.android23.buoi4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dungnd.android23.R;

import java.util.List;

class SupportAdapter extends RecyclerView.Adapter<SupportAdapter.SupportViewHolder> {

    private List<Support> supports;

    public SupportAdapter(List<Support> products) {
        this.supports = products;
    }

    @NonNull
    @Override
    public SupportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_support, parent, false);
        return new SupportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SupportViewHolder holder, int position) {
        holder.setData(supports.get(position));
    }

    @Override
    public int getItemCount() {
        return supports.size();
    }

    class SupportViewHolder extends RecyclerView.ViewHolder {
        private TextView tvSupport;

        public SupportViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSupport = itemView.findViewById(R.id.tvSupport);
        }

        public void setData(Support support) {
            tvSupport.setText(support.getSupport());
        }
    }
}
