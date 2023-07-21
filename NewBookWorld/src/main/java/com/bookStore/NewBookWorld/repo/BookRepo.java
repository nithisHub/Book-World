package com.bookStore.NewBookWorld.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookStore.NewBookWorld.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}
