package com.suadahaji.libro.mvp_list;

import com.suadahaji.libro.api.ApiManager;
import com.suadahaji.libro.models.Book;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * @author Suada Haji (Suada.Haji@dstvdm.com)
 * @since 9/17/17 4:31 PM.
 */

public class BookListPresenter implements BookListContract.Presenter<BookListContract.BooksView> {

    private BookListContract.BooksView view;

    private ApiManager apiManager;

    private final Scheduler subscribeOn;

    private final Scheduler observeOn;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public BookListPresenter(final ApiManager apiManager, final Scheduler subscribeOn, final Scheduler observeOn) {
        this.apiManager = apiManager;
        this.subscribeOn = subscribeOn;
        this.observeOn = observeOn;
    }


    @Override
    public void setView(final BookListContract.BooksView view) {
        this.view = view;
    }

    @Override
    public void displayBooks() {
        if (checkViewAttached()) {
            view.showProgressBar();

            Observable<List<Book>> booksresponse = apiManager.getBookResponse();

            compositeDisposable.add(booksresponse.subscribeOn(subscribeOn).observeOn(observeOn)
                    .subscribe(new Consumer<List<Book>>() {
                        @Override
                        public void accept(final List<Book> books) throws Exception {
                            if (books == null || books.size() == 0) {
                                view.showEmptyStateMessage();
                            }

                            view.hideProgressBar();
                            view.showBooks(books);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(final Throwable throwable) throws Exception {
                            view.hideProgressBar();
                            view.showErrorMessage();
                        }
                    }));
        }
    }

    @Override
    public void destroyView() {
        view = null;
        compositeDisposable.dispose();
    }

    public boolean checkViewAttached() {
        return view != null;
    }
}
