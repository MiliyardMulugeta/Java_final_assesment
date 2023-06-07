package com.example.java_web_final_project.servicesImp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java_web_final_project.entity.Book;
import com.example.java_web_final_project.repository.BookRepository;
import com.example.java_web_final_project.request.BookRequestDTO;
import com.example.java_web_final_project.services.BookServices;
import com.example.java_web_final_project.util.ResponseCodes;
import com.example.java_web_final_project.util.ResponseDesc;
import com.example.java_web_final_project.util.ServiceResponse;

@Service
public class BookServicesImp implements BookServices {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public ServiceResponse addBook(BookRequestDTO bookRequestDTO) {
		ServiceResponse response = null;

		try {
			Book book = new Book();
			book.setTitle(bookRequestDTO.getTitle());
			book.setAuthorName(bookRequestDTO.getAuthorName());
			book.setCreatedAt(new Date());
			bookRepository.save(book);
			response = new ServiceResponse(ResponseCodes.SUCCESS, ResponseDesc.SUCCESS, null);
		} catch (Exception ex) {
			response = new ServiceResponse(ResponseCodes.FAILED, ex.getMessage(), null);
		}
		return response;
	}

	@Override
	public ServiceResponse updateBook(BookRequestDTO bookRequestDTO) {
		ServiceResponse response = null;
		try {
			if (bookRequestDTO.getBookId() == null) {
				response = new ServiceResponse(ResponseCodes.FAILED, ResponseDesc.ERROR_BOOK_ID, null);
			} else if (!bookRepository.existsById(bookRequestDTO.getBookId())) {
				response = new ServiceResponse(ResponseCodes.FAILED, ResponseDesc.ERROR_BOOK__NOT_FOUND, null);
			} else {
				Book book = bookRepository.getById(bookRequestDTO.getBookId());
				if (book != null) {
					book.setTitle(bookRequestDTO.getTitle());
					book.setAuthorName(bookRequestDTO.getAuthorName());
					book.setUpdateAt(new Date());
					bookRepository.save(book);
					response = new ServiceResponse(ResponseCodes.SUCCESS, ResponseDesc.SUCCESS, null);
				}

			}

		} catch (Exception ex) {
			response = new ServiceResponse(ResponseCodes.FAILED, ex.getMessage(), null);
		}
		return response;
	}

	@Override
	public ServiceResponse getAllBooks() {
		return new ServiceResponse(ResponseCodes.SUCCESS, ResponseDesc.SUCCESS, bookRepository.findAll());
	}

	@Override
	public ServiceResponse deleteBook(Long bookId) {
		ServiceResponse response = null;
		try {
			if (bookId == null) {
				response = new ServiceResponse(ResponseCodes.FAILED, ResponseDesc.ERROR_BOOK_ID, null);
			} else if (!bookRepository.existsById(bookId)) {
				response = new ServiceResponse(ResponseCodes.FAILED, ResponseDesc.ERROR_BOOK__NOT_FOUND, null);
			} else {
				bookRepository.deleteById(bookId);
				response = new ServiceResponse(ResponseCodes.SUCCESS, ResponseDesc.SUCCESS, null);
			}
		} catch (Exception ex) {
			response = new ServiceResponse(ResponseCodes.FAILED, ex.getMessage(), null);
		}

		return response;
	}

}
