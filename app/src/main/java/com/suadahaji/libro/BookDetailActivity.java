package com.suadahaji.libro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.suadahaji.libro.models.Book;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookDetailActivity extends AppCompatActivity {

    public Book book;

    @BindView(R.id.bookname)
    TextView bookName;

    @BindView(R.id.book_description)
    TextView bookDescription;

    @BindView(R.id.book_rating)
    TextView bookRating;

    @BindView(R.id.book_isbn)
    TextView bookIsbn;

    @BindView(R.id.book_date)
    TextView bookDate;

    @BindView(R.id.book_pages)
    TextView bookPages;

    @BindView(R.id.book_author)
    TextView bookAuthor;

    @BindView(R.id.book_image)
    ImageView bookImage;

    @BindView(R.id.ratingBar)
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.books);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            book = extras.getParcelable(MainActivity.BOOK);

            bookName.setText(book.getName());
            bookDate.setText(getString(R.string.published_on) + book.getDate());
            bookDescription.setText(book.getDescription());
            bookAuthor.setText(getString(R.string.by) + book.getAuthor());
            bookIsbn.setText(book.getIsbn());
            bookPages.setText(book.getPages());
            bookRating.setText(String.valueOf(book.getRatings()));
            Picasso.with(this).load(book.getImage()).into(bookImage);

            ratingBar.setRating((float) book.getRatings());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
