package com.bookStore.NewBookWorld.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookStore.NewBookWorld.entity.Book;
import com.bookStore.NewBookWorld.repo.BookRepo;


@Service
public class BookService {
  
  @Autowired
  public BookRepo bookRepo;

  public void saveBook(Book book) {
    bookRepo.save(book);
  }
  
  public List<Book> showAllbooks() {
   return bookRepo.findAll();
  }

  public Book getBookById(int id) {
   return  bookRepo.findById(id).get();
  }
  
  public void deleteById(int id) {
     bookRepo.deleteById(id);
  }
}
