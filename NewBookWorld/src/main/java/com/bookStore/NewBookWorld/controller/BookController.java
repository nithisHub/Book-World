package com.bookStore.NewBookWorld.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.bookStore.NewBookWorld.entity.Book;
import com.bookStore.NewBookWorld.entity.MyBooks;
import com.bookStore.NewBookWorld.service.BookService;
import com.bookStore.NewBookWorld.service.MyBooksService;

@Controller
public class BookController {
  @Autowired
  private BookService bookService;
  
  @Autowired
  private MyBooksService myBooksService;

  @GetMapping("/")
  public String home() {
    return "home";
  }

  @GetMapping("/book_register")
  public String bookRegister() {
    return "bookRegister";
  }

  @GetMapping("/available_books")
  public ModelAndView availableBooks() {
    List<Book> list = bookService.showAllbooks();
    return new ModelAndView("availableBook", "book", list);
  }

  @PostMapping("/save")
  public String addBook(@ModelAttribute Book book) {
    bookService.saveBook(book);
    return "redirect:/available_books";
  }

  @GetMapping("/my_books")
  public String getMyBooks(Model model) {
    List<MyBooks>myBookList=myBooksService.getAllMyBooks();
    model.addAttribute("book", myBookList);
    return "mybooks";
  }

  @RequestMapping("/mylist/{id}")
  public String getMyList(@PathVariable("id") int id) {
    Book book= bookService.getBookById(id);
    MyBooks my=new MyBooks(book.getId(),book.getName(),book.getAuthor(),book.getPrize()); 
    myBooksService.saveMyBooks(my);
    return "redirect:/my_books";
  }
  
  @GetMapping("/editBook/{id}")
  public String editBook(@PathVariable("id") int id, Model model) {
    Book b=bookService.getBookById(id);
    model.addAttribute("bEdit",b);
    return "bookEdit";
  }
  
  @GetMapping("/deleteBook/{id}")
  public String deleteBook(@PathVariable("id") int id) {
    bookService.deleteById(id);
    return "redirect:/available_books";
  }
  
}
    
