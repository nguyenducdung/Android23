package BTVN_buoi3_bai3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dungnd.android23.R;

import java.util.List;

import BTVN_buoi3_bai2.AdapterPDF;

public class AdapterBai3 extends RecyclerView.Adapter<AdapterBai3.Bai3ViewHolder> {
    private List<Bai3> bai3List = null;

    public AdapterBai3(List<Bai3> bai3List) {
        this.bai3List = bai3List;
    }

    public List<Bai3> getBai3List() {
        return bai3List;
    }

    public void setBai3List(List<Bai3> bai3List) {
        this.bai3List = bai3List;
    }

    @NonNull
    @Override
    public Bai3ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bai3, parent, false);
        return new Bai3ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Bai3ViewHolder holder, int position) {

        holder.filetext.setText(bai3List.get(position).getFiletext());
    }

    @Override
    public int getItemCount() {
        return bai3List != null ? bai3List.size() : 0;
    }

    class Bai3ViewHolder extends RecyclerView.ViewHolder {
        private TextView filetext;

        public Bai3ViewHolder(@NonNull View itemView) {
            super(itemView);
            filetext = itemView.findViewById(R.id.filetext);
        }
    }
}
