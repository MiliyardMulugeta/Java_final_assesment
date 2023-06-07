package com.example.java_web_final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_web_final_project.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
