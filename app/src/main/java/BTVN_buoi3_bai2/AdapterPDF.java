package BTVN_buoi3_bai2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dungnd.android23.R;

import java.util.List;

public class AdapterPDF extends RecyclerView.Adapter<AdapterPDF.PDFViewHolder> {
    private List<PDF> pdfList = null;

    public AdapterPDF(List<PDF> pdfList) {

        this.pdfList = pdfList;
    }

    public List<PDF> getPdfList() {
        return pdfList;
    }

    public void setPdfList(List<PDF> pdfList) {
        this.pdfList = pdfList;
    }

    @NonNull
    @Override
    public PDFViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bai2, parent, false);
        return new PDFViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PDFViewHolder holder, int position) {
        holder.abode.setText(pdfList.get(position).getAbode());


    }

    @Override
    public int getItemCount() {
        return pdfList != null ? pdfList .size() : 0;
    }

    class PDFViewHolder extends RecyclerView.ViewHolder{
        private TextView abode;
        public PDFViewHolder(@NonNull View itemView) {
            super(itemView);
            abode = itemView.findViewById(R.id.abodetext);
        }
    }
}
