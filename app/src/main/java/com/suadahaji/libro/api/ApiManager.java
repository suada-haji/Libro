package com.suadahaji.libro.api;

import com.suadahaji.libro.models.Book;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;


/**
 * @author Suada Haji (Suada.Haji@dstvdm.com)
 * @since 9/17/17 9:06 PM.
 */

public interface ApiManager {
    @GET("books.json")
    Observable<List<Book>> getBookResponse();
}
