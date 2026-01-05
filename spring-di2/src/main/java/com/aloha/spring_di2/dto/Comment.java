package com.aloha.spring_di2.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Comment {
	
	private Long no;
	private String id;
	private String writer;
	private String content;
	private Date createdAt;
	private Date updatedAt;

}
