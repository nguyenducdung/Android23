package com.dungnd.android23.pdfrecyclerview;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dungnd.android23.R;

import java.util.List;

// Co 2 cach truyen du lieu vao adapter(constructor, set va get).
public class AdapterPDF extends RecyclerView.Adapter<AdapterPDF.PDFViewHolder> {
    // Cách 1: truyền data vào adapter bằng constructor.
    private List<PDF> pdfList;
    private OnItemClick onItemClick;
    public AdapterPDF(List<PDF> pdfList) {
        this.pdfList = pdfList;
    }

    // Cach 2: truyền dữ liệu data bằng set va get.
    public List<PDF> getPdfList() {
        return pdfList;
    }

    public void setOnItemClick(AdapterPDF.OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public void setPdfList(List<PDF> pdfList) {
        this.pdfList = pdfList;
    }

    //Các class đc import vào.
    //onCreateViewHolder tạo ra item(View holder là một cái view giữ data).
    @NonNull
    @Override
    public PDFViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Sau khi truyền dữ liệu vào thì tạo 1 view holder bằng cách ìnlate.
        // from la truyen mot context
        // parent chinh la recycleview
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pdf, parent, false);
        return new PDFViewHolder(view);
    }

    //onBindViewHolder set các dữ liệu cần thiết cho view holder vào đây.
    @Override
    public void onBindViewHolder(@NonNull PDFViewHolder holder, @SuppressLint("RecyclerView") int position) {
        /* Cach 1:
        holder.txtName.setText(pdfList.get(position).getName());
        */

        //Cach 2:
        holder.setData(pdfList.get(position));
        holder.txtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.clickName(pdfList.get(position).getName());
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.clickItem();
            }
        });
    }

    //Hiển thị số lượng item mà các bạn muốn(hoặc item đề  bài yêu cầu).
    @Override
    public int getItemCount() {
        return pdfList != null ? pdfList.size() : 0;
    }

    // Trong adapter tạo một view holder, dễ quản lý xóa sửa.
    protected class PDFViewHolder extends RecyclerView.ViewHolder{
        private TextView txtName;
        public PDFViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
        }

        public void setData(PDF pdf){
            txtName.setText(pdf.getName());
        }
    }

    public interface OnItemClick{
        void clickName(String name);
        void clickItem();
    }
}

