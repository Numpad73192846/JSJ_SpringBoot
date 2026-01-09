package com.aloha.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.board.dto.Files;

@Mapper
public interface FileMapper {

    // 파일 목록
    public List<Files> list() throws Exception;
    // 파일 조회
    public Files select(Integer no) throws Exception;
    public Files selectById(String id) throws Exception;
    // 파일 등록
    public int insert(Files board) throws Exception;
    // 파일 수정
    public int update(Files board) throws Exception;
    public int updateById(Files board) throws Exception;
    // 파일 삭제
    public int delete(Integer no) throws Exception;
    public int deleteById(String id) throws Exception;
    
    
}
