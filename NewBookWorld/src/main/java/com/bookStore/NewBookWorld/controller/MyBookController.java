package com.bookStore.NewBookWorld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bookStore.NewBookWorld.entity.MyBooks;
import com.bookStore.NewBookWorld.repo.MyBooksRepo;
import com.bookStore.NewBookWorld.service.MyBooksService;

@Controller
public class MyBookController {

  @Autowired
  private MyBooksService myBooksService;

  @RequestMapping("/deleteMyList/{id}")
  public String deleteMyBook(@PathVariable("id") int id) {
    myBooksService.deleteById(id);
    return "redirect:/my_books";
  }
}
