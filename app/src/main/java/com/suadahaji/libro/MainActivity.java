package com.suadahaji.libro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.suadahaji.libro.api.ApiManager;
import com.suadahaji.libro.dagger.BaseApplication;
import com.suadahaji.libro.models.Book;
import com.suadahaji.libro.mvp_list.BookListContract;
import com.suadahaji.libro.mvp_list.BookListPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements BookListContract.BooksView {

    private BookListPresenter presenter;

    private ArrayList<Book> books = new ArrayList<>();

    public static final String BOOK = "BOOK";

    private static final String TAG = "MainActivity";
    @Inject
    ApiManager apiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((BaseApplication) getApplicationContext()).getAppComponent().inject(this);

        presenter = new BookListPresenter(apiManager, Schedulers.io(), AndroidSchedulers.mainThread());


    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
        presenter.displayBooks();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.destroyView();
    }

    @Override
    public void showBooks(final List<Book> books) {
        this.books.clear();
        this.books.addAll(books);
        Log.d(TAG, "showBooks size : " + books.size());

    }

    @Override
    public void showProgressBar() {
        Log.d(TAG, "showProgressBar: ");

    }

    @Override
    public void hideProgressBar() {
        Log.d(TAG, "hideProgressBar: ");

    }

    @Override
    public void showErrorMessage() {
        Log.d(TAG, "showErrorMessage: ");

    }

    @Override
    public void showEmptyStateMessage() {
        Log.d(TAG, "showEmptyStateMessage: ");

    }

    @Override
    public void onBookClicked(final Book book) {

    }
}
