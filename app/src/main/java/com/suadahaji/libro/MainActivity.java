package com.suadahaji.libro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.suadahaji.libro.api.ApiManager;
import com.suadahaji.libro.dagger.BaseApplication;
import com.suadahaji.libro.models.Book;
import com.suadahaji.libro.mvp_list.BookAdapter;
import com.suadahaji.libro.mvp_list.BookListContract;
import com.suadahaji.libro.mvp_list.BookListPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements BookListContract.BooksView {

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.empty_tv)
    TextView emptyStateTextView;

    @BindView(R.id.error_tv)
    TextView errorStateTextView;

    @BindView(R.id.books_recyclerview)
    RecyclerView recyclerView;

    private BookListPresenter presenter;

    private BookAdapter adapter;

    private ArrayList<Book> books = new ArrayList<>();

    public static final String BOOK = "BOOK";

    private static final String TAG = "MainActivity";
    @Inject
    ApiManager apiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.books);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }

        ButterKnife.bind(this);

        ((BaseApplication) getApplicationContext()).getAppComponent().inject(this);

        presenter = new BookListPresenter(apiManager, Schedulers.io(), AndroidSchedulers.mainThread());
        presenter.setView(this);
        presenter.displayBooks();

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new BookAdapter(books, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        presenter.destroyView();
    }

    @Override
    public void showBooks(final List<Book> books) {
        this.books.clear();
        this.books.addAll(books);
        Log.d(TAG, "showBooks size : " + books.size());
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgressBar() {
        Log.d(TAG, "showProgressBar: ");
        recyclerView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        Log.d(TAG, "hideProgressBar: ");
        recyclerView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage() {
        Log.d(TAG, "showErrorMessage: ");
        errorStateTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showEmptyStateMessage() {
        Log.d(TAG, "showEmptyStateMessage: ");
        emptyStateTextView.setVisibility(View.VISIBLE);

    }

    @Override
    public void onBookClicked(final Book book) {
        Intent intent = new Intent(this, BookDetailActivity.class);
        intent.putExtra(BOOK, book);
        startActivity(intent);
    }
}
