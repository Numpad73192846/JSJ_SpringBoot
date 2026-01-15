package com.aloha.board.service;

import java.util.List;

import com.aloha.board.dto.Board;
import com.aloha.board.dto.Pagination;
import com.github.pagehelper.PageInfo;

public interface BoardService {

    // 게시글 목록
    public List<Board> list() throws Exception;

    // 페이징 목록 (Pagination)
    public List<Board> page(Pagination pagination) throws Exception;

    // 페이징 목록 (PageHelper)
    public PageInfo<Board> page(int page, int size) throws Exception;

    // 게시글 조회
    public Board select(int no) throws Exception;

    // 게시글 등록
    public boolean insert(Board board) throws Exception;

    // 게시글 수정
    public boolean update(Board board) throws Exception;

    // 게시글 삭제
    public boolean delete(int no) throws Exception;
    
}
