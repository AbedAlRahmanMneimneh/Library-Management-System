package com.library_entity_controllers;

import java.io.File;

public class Book {
    private Integer ISBN;
    private String title;
    private Integer edition;
    private String genre;
    private Integer numOfPages;
    private String publisher;
    private String datePublished;
    private Integer numberInStock;
    private Integer available;
    private String bookDescription;
    private File bookImage;
    private String author;





    public Integer getISBN() {

        return ISBN;
    }

    public void setISBN(Integer ISBN) {

        this.ISBN = ISBN;
    }

    public Integer getEdition() {

        return edition;
    }

    public void setEdition(Integer edition) {

        this.edition = edition;
    }

    public Integer getNumOfPages() {

        return numOfPages;
    }

    public void setNumOfPages(Integer numOfPages) {

        this.numOfPages = numOfPages;
    }

    public String getPublisher() {

        return publisher;
    }

    public void setPublisher(String publisher) {

        this.publisher = publisher;
    }

    public String getDatePublished() {

        return datePublished;
    }

    public void setDatePublished(String datePublished) {

        this.datePublished = datePublished;
    }

    public Integer getNumberInStock() {

        return numberInStock;
    }

    public void setNumberInStock(Integer numberInStock) {

        this.numberInStock = numberInStock;
    }

    public Integer getAvailable() {

        return available;
    }

    public void setAvailable(Integer available) {


        this.available = available;
    }

    public String getBookDescription() {


        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {


        this.bookDescription = bookDescription;
    }

    public File getBookImage() {


        return bookImage;
    }

    public void setBookImage(File bookImage) {

        this.bookImage = bookImage;
    }
    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public String getGenre() {

        return genre;
    }

    public void setGenre(String genre) {

        this.genre = genre;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }
}
