package com.bookStore.NewBookWorld.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MyBooks {
  @Id
  private int id;
  private String name;
  private String author;
  private String prize;

  public MyBooks(int id, String name, String author, String prize) {
    this.id = id;
    this.name = name;
    this.author = author;
    this.prize = prize;
  }

  public MyBooks() {}

}
