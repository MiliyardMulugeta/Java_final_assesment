package com.example.java_web_final_project.services;

import com.example.java_web_final_project.request.BookRequestDTO;
import com.example.java_web_final_project.util.ServiceResponse;

public interface BookServices {

	ServiceResponse addBook(BookRequestDTO bookRequestDTO);

	ServiceResponse updateBook(BookRequestDTO bookRequestDTO);

	ServiceResponse getAllBooks();

	ServiceResponse deleteBook(Long bookId);
}
