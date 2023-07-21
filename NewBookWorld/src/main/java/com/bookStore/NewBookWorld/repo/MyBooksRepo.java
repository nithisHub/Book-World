package com.bookStore.NewBookWorld.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookStore.NewBookWorld.entity.MyBooks;

public interface MyBooksRepo extends JpaRepository<MyBooks, Integer> {

}
