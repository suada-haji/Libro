package com.suadahaji.libro.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * @author Suada Haji (Suada.Haji@dstvdm.com)
 * @since 9/17/17 4:42 PM.
 */

public class BookResponse {
    @SerializedName("")
    private ArrayList<Book> books;

    private BookResponse(final ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
