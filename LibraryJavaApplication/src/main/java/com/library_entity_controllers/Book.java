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
    private Integer numberInStock =0;
    private Integer available;
    private String bookDescription;
    private File bookImage;
    private String author;


    public Book(Integer ISBN, String title, Integer edition, String genre, Integer numOfPages, String publisher, String datePublished,
                Integer numberInStock, Integer available, String bookDescription, File bookImage, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.edition = edition;
        this.genre = genre;
        this.numOfPages = numOfPages;
        this.publisher = publisher;
        this.datePublished = datePublished;
        this.numberInStock = numberInStock;
        this.available = available;
        this.bookDescription = bookDescription;
        this.bookImage = bookImage;
        this.author = author;
    }

    public Book() {
    }

    public Book(Integer ISBN, String title, Integer edition, String genre, Integer numOfPages, String publisher,
                String datePublished, Integer available, String bookDescription, File bookImage, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.edition = edition;
        this.genre = genre;
        this.numOfPages = numOfPages;
        this.publisher = publisher;
        this.datePublished = datePublished;
        this.available = available;
        this.bookDescription = bookDescription;
        this.bookImage = bookImage;
        this.author = author;
    }

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
