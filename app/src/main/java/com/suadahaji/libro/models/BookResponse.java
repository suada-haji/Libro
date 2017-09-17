package com.suadahaji.libro.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * @author Suada Haji (Suada.Haji@dstvdm.com)
 * @since 9/17/17 4:42 PM.
 */

public class BookResponse {
    @SerializedName("books")
    private ArrayList<Book> movies;

    private BookResponse(final ArrayList<Book> movies) {
        this.movies = movies;
    }

    private ArrayList<Book> getMovies() {
        return movies;
    }
}
