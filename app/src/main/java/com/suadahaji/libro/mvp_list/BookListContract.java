package com.suadahaji.libro.mvp_list;

import com.suadahaji.libro.models.Book;

import java.util.List;

/**
 * @author Suada Haji (Suada.Haji@dstvdm.com)
 * @since 9/17/17 4:32 PM.
 */

public interface BookListContract {

    interface BooksView  {
        void showBooks(List<Book> books);

        void showProgressBar();

        void hideProgressBar();

        void showErrorMessage();

        void showEmptyStateMessage();

        void onBookClicked(Book book);
    }

    interface Presenter<V> {
        void setView(V view);

        void displayBooks();

        void destroyView();
    }
}
