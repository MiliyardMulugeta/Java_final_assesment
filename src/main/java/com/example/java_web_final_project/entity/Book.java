package com.example.java_web_final_project.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "BOOK")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "AUTHOR_NAME")
	private String authorName;

	@Column(name = "CREATED_AT")
	private Date createdAt;

	@Column(name = "UPDATE_AT")
	private Date updateAt;
}
