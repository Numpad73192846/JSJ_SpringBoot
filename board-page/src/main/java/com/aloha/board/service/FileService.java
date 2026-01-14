package com.aloha.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.aloha.board.dto.Files;
import com.aloha.board.dto.ParentTable;

public interface FileService {

    // 파일 목록
    public List<Files> list() throws Exception;
    // 파일 조회
    public Files select(Integer no) throws Exception;
    public Files selectById(String id) throws Exception;
    // 파일 등록
    public Boolean insert(Files board) throws Exception;
    // 파일 수정
    public Boolean update(Files board) throws Exception;
    public Boolean updateById(Files board) throws Exception;
    // 파일 삭제
    public Boolean delete(Integer no) throws Exception;
    public Boolean deleteById(String id) throws Exception;

    // 파일 업로드
	public int upload(List<MultipartFile> files, ParentTable parentTable, Integer parentNo) throws Exception;

    // 부모 기준 목록
    public List<Files> listByParent(Files files) throws Exception;
    
    // 부모 기준 파일 삭제
    public int deleteByParent(Files files) throws Exception;

    // 파일 순서 변경
    public boolean updateSortOrder(List<Map<String, Object>> sortOrderList) throws Exception;
    public boolean updateFileSortOrder(List<Files> fileList) throws Exception;
}