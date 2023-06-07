package com.example.java_web_final_project.request;


import javax.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class BookRequestDTO {

	/*
	 * book Id is Used for Update Only
	 */
	private Long bookId;
	@NotBlank(message = "Please Provide Book Title")
	private String title;
	@NotBlank(message = "Please Provide Book's Author Name")
	private String authorName;

}
