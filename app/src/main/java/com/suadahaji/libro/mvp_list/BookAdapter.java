package com.suadahaji.libro.mvp_list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.suadahaji.libro.R;
import com.suadahaji.libro.models.Book;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Suada Haji (Suada.Haji@dstvdm.com)
 * @since 9/17/17 10:25 PM.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> bookList;

    private Context context;

    private BookListContract.BooksView view;

    private int lastPosition = -1;

    public BookAdapter(final List<Book> bookList, final BookListContract.BooksView view) {
        this.bookList = bookList;
        this.view = view;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.book_image)
        ImageView bookImage;

        public Book book;


        public BookViewHolder(final View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(final View view) {
            BookAdapter.this.view.onBookClicked(book);
        }
    }

    @Override
    public BookViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        context = parent.getContext();
        View root = LayoutInflater.from(context).inflate(R.layout.book_item_row, parent, false);
        return new BookViewHolder(root);
    }

    @Override
    public void onBindViewHolder(final BookViewHolder holder, final int position) {
        setAnimation(holder.itemView, position);
        holder.itemView.setOnClickListener(holder);
        holder.book = bookList.get(position);
        Picasso.with(context).load(holder.book.getImage()).into(holder.bookImage);

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setDuration(1000);
            viewToAnimate.startAnimation(anim);
            lastPosition = position;
        }
    }


}
