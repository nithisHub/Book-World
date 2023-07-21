package com.bookStore.NewBookWorld.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookStore.NewBookWorld.entity.MyBooks;
import com.bookStore.NewBookWorld.repo.MyBooksRepo;

@Service
public class MyBooksService {

  @Autowired
  private MyBooksRepo myBooksRepo;

  public void saveMyBooks(MyBooks myBooks) {
    myBooksRepo.save(myBooks);
  }

  public List<MyBooks> getAllMyBooks() {
    return myBooksRepo.findAll();
  }
  public void deleteById(int id) {
    myBooksRepo.deleteById(id);
  }
}
