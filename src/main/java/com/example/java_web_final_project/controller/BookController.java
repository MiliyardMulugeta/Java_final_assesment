package com.example.java_web_final_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_web_final_project.request.BookRequestDTO;
import com.example.java_web_final_project.servicesImp.BookServicesImp;
import com.example.java_web_final_project.util.ResponseCodes;
import com.example.java_web_final_project.util.ServiceResponse;

@RestController
@RequestMapping("/api/v1/book/")
public class BookController {

	@Autowired
	private BookServicesImp bookServicesImp;

	@PostMapping("add")
	public ServiceResponse addBook(@RequestBody BookRequestDTO bookRequestDTO) {
		ServiceResponse response = null;
		try {
			response = bookServicesImp.addBook(bookRequestDTO);
		} catch (Exception ex) {
			response = new ServiceResponse(ResponseCodes.FAILED, ex.getMessage(), null);
		}
		return response;
	}

	@PostMapping("update")
	public ServiceResponse updateBook(@RequestBody BookRequestDTO bookRequestDTO) {
		ServiceResponse response = null;
		try {
			response = bookServicesImp.updateBook(bookRequestDTO);
		} catch (Exception ex) {
			response = new ServiceResponse(ResponseCodes.FAILED, ex.getMessage(), null);
		}
		return response;
	}

	@GetMapping
	public ServiceResponse getAllBooks() {
		ServiceResponse response = null;
		try {
			response = bookServicesImp.getAllBooks();
		} catch (Exception ex) {
			response = new ServiceResponse(ResponseCodes.FAILED, ex.getMessage(), null);
		}
		return response;
	}

	@DeleteMapping("{bookId}")
	public ServiceResponse deleteBook(@PathVariable Long bookId) {
		ServiceResponse response = null;
		try {
			response = bookServicesImp.deleteBook(bookId);
		} catch (Exception ex) {
			response = new ServiceResponse(ResponseCodes.FAILED, ex.getMessage(), null);
		}
		return response;
	}
}
