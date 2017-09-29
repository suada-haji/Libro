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
    private double ratings;

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
        ratings = in.readDouble();
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
        parcel.writeDouble(ratings);
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(final String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(final String pages) {
        this.pages = pages;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(final double ratings) {
        this.ratings = ratings;
    }
}
