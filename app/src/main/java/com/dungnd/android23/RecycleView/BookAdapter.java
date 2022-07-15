package com.dungnd.android23.RecycleView;

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
    }

    @Override
    public int getItemCount() {
        if (mListBook != null){
            return mListBook.size();
        }

        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgAvatar;
        private TextView tvName;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.img_avatar);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
