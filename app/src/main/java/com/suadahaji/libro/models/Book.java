package com.suadahaji.libro.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * @author Suada Haji (Suada.Haji@dstvdm.com)
 * @since 9/17/17 4:32 PM.
 */

public class Book implements Parcelable {

    @SerializedName("id")
    private int id;
    @SerializedName("author")
    private String author;
    @SerializedName("date")
    private String date;
    @SerializedName("description")
    private String description;
    @SerializedName("image")
    private String image;
    @SerializedName("isbn")
    private String isbn;
    @SerializedName("name")
    private String name;
    @SerializedName("pages")
    private String pages;
    @SerializedName("ratings")
    private Double ratings;

    private Book() {
    }

    protected Book(Parcel in) {
        id = in.readInt();
        author = in.readString();
        date = in.readString();
        description = in.readString();
        image = in.readString();
        isbn = in.readString();
        name = in.readString();
        pages = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel parcel, final int i) {
        parcel.writeInt(id);
        parcel.writeString(author);
        parcel.writeString(date);
        parcel.writeString(description);
        parcel.writeString(image);
        parcel.writeString(isbn);
        parcel.writeString(name);
        parcel.writeString(pages);
    }

    private int getId() {
        return id;
    }

    private void setId(final int id) {
        this.id = id;
    }

    private String getAuthor() {
        return author;
    }

    private void setAuthor(final String author) {
        this.author = author;
    }

    private String getDate() {
        return date;
    }

    private void setDate(final String date) {
        this.date = date;
    }

    private String getDescription() {
        return description;
    }

    private void setDescription(final String description) {
        this.description = description;
    }

    private String getImage() {
        return image;
    }

    private void setImage(final String image) {
        this.image = image;
    }

    private String getIsbn() {
        return isbn;
    }

    private void setIsbn(final String isbn) {
        this.isbn = isbn;
    }

    private String getName() {
        return name;
    }

    private void setName(final String name) {
        this.name = name;
    }

    private String getPages() {
        return pages;
    }

    private void setPages(final String pages) {
        this.pages = pages;
    }

    private Double getRatings() {
        return ratings;
    }

    private void setRatings(final Double ratings) {
        this.ratings = ratings;
    }
}
