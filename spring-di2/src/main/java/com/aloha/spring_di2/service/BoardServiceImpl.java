package com.aloha.spring_di2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.aloha.spring_di2.dao.BoardDAO;
import com.aloha.spring_di2.dto.Board;
import com.aloha.spring_di2.dto.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Primary
@Service
public class BoardServiceImpl implements PostService {

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<Post> list() {
		List<Board> boardList = boardDAO.list();
		List<Post> postList = new ArrayList<>(boardList);
		log.info("boardList : {}", boardList);
		return postList;
	}
	
}
