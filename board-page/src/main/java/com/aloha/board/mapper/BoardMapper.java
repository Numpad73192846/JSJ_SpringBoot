package com.aloha.board.mapper;

import java.rmi.server.ExportException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.board.dto.Board;
import com.aloha.board.dto.Pagination;

@Mapper
public interface BoardMapper {

    // 게시글 목록
    public List<Board> list() throws Exception;

    // 페이징 목록
    public List<Board> page(Pagination pagination) throws Exception;

    // 게시글 조회
    public Board select(int no) throws Exception;

    // 게시글 등록
    public int insert(Board board) throws Exception;

    // 게시글 수정
    public int update(Board board) throws Exception;

    // 게시글 삭제
    public int delete(int no) throws Exception;

    // 데이터 수
    public long count() throws Exception;
    
    
}