package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.entities.Book;

@Service
public class BookServices {
    private static List<Book> list = new ArrayList<>();

    static{
        list.add(new Book(10,"C++","Pranav"));
        list.add(new Book(20,"C","Yash"));
        list.add(new Book(30,"Python","Om"));
    }

    //get all book
    public List<Book> getAllBooks(){
        return list;
    }

    //get book by id
    public Book getBookById(int id){
        Book b = null;
        b = list.stream().filter(e-> e.getId()==id).findFirst().get();
        return b;
    }

    //adding book
    public Book addBook(Book b){
        list.add(b);
        return b;
    }

    //deleting book
    public void deleteBook(int id){
            list = list.stream().filter(book -> book.getId()!=id).collect(Collectors.toList());

            //list = list.stream().filter(book ->{
            //     if (book.getId() != id) {
            //         return true;
            //     }else{
            //         return false;
            //     }
            // }).collect(Collectors.toList());
    }

    //updating book
    public void updateBook(Book book, int id){
        list = list.stream().map(b -> {
            if(b.getId()==id){
                b.setName(book.getName());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
