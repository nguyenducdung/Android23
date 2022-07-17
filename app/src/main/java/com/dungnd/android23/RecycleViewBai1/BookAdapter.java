package com.dungnd.android23.RecycleViewBai1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dungnd.android23.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> mListBook;

    public BookAdapter(List<Book> mListBook) {
        this.mListBook = mListBook;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = mListBook.get(position);
        if (book == null){
            return;
        }
        holder.imgAvatar.setImageResource(book.getResourceId());
        holder.tvName.setText(book.getName());
        holder.tvbai.setText(book.getBaiviet());
        holder.tvFan.setText(book.getFan());
        holder.tvNhom.setText(book.getNhom());
    }

    @Override
    public int getItemCount() {


        return mListBook != null ? mListBook.size() : 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgAvatar;
        private TextView tvName;
        private TextView tvFan;
        private TextView tvNhom;
        private TextView tvbai;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.img_avatar);
            tvName = itemView.findViewById(R.id.tv_name);
            tvFan = itemView.findViewById(R.id.tvFan);
            tvNhom = itemView.findViewById(R.id.tvNhom);
            tvbai = itemView.findViewById(R.id.tvBai);



        }
    }
}
