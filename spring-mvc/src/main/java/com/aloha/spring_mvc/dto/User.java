package com.aloha.spring_mvc.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {
	
	private Long no;
	private String id;
	private String username;
	private String password;
	private String name;
	private LocalDate birth;

}
