package com.aloha.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aloha.board.dto.Board;
import com.aloha.board.dto.Files;
import com.aloha.board.dto.Pagination;
import com.aloha.board.dto.Params;
import com.aloha.board.dto.ParentTable;
import com.aloha.board.mapper.BoardMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service    // 서비스 역할의 스프링 빈
public class BoardServiceImpl implements BoardService {
    
    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private FileService fileService;

    /**
     * 게시글 목록 조회
     */
    @Override
    public List<Board> list() throws Exception {
        // TODO : boardMapper 로 list() 호출
        /*
         *        ➡ List<Board> boardList 로 받아옴
         *        ➡ return boardList
         */
        List<Board> boardList = boardMapper.list();
        return boardList;
    }

    /**
     * 게시글 조회
     * - no 매개변수로 게시글 번호를 전달받아서
     *   데이터베이스에 조회 요청
     */
    @Override
    public Board select(int no) throws Exception {
        // TODO : boardMapper 로 select(no) 호출
        /*
         *        ➡ Board board 로 받아옴
         *        ➡ return board
         */
        Board board = boardMapper.select(no);
        return board;        
    }

    /**
     * 게시글 등록
     */
    @Override
    public boolean insert(Board board) throws Exception {
        // TODO : boardMapper 로 insert(Board) 호출
        /*
        *        ➡ int result 로 데이터 처리 행(개수) 받아옴
        *        ➡ return result
        */
        // 게시글 등록
        int result = boardMapper.insert(board);
        int parentNo = board.getNo();

        // 파일 업로드
        int fileResult = fileService.upload(board.getFiles(), ParentTable.BOARD, parentNo);
        log.info( "파일 업로드 - {}개 파일 등록", fileResult);

        return result > 0;
    }

    /**
     * 게시글 수정
     */
    @Override
    public boolean update(Board board) throws Exception {
        // TODO : boardMapper 로 update(Board) 호출
        /*
         *        ➡ int result 로 데이터 처리 행(개수) 받아옴
         *        ➡ return result
         */
        int result = boardMapper.update(board);
        int parentNo = board.getNo();

        // 파일 업로드
        int fileResult = fileService.upload(board.getFiles(), ParentTable.BOARD, parentNo);
        log.info( "파일 업로드 - {}개 파일 등록", fileResult);

        return result > 0;
    }

    /**
     * 게시글 삭제
     */
    @Override
    @Transactional
    // 트랜잭션 처리 : 2개 이상의 데이터 베이스 요청에서
    //                하나라도 실패 하면 전체를 롤백 한다.
    public boolean delete(int no) throws Exception {
        // TODO : boardMapper 로 delete(no) 호출
        /*
         *        ➡ int result 로 데이터 처리 행(개수) 받아옴
         *        ➡ return result
         */
        // 게시글 삭제
        int result = boardMapper.delete(no);

        // 첨부파일 삭제
        Files file = new Files();
        file.setParentTable(ParentTable.BOARD.value());
        file.setParentNo(no);
        int fileResult = fileService.deleteByParent(file);

        log.info("파일 삭제 - {} 개 파일 삭제", fileResult);
        return result > 0;
    }

    @Override
    public List<Board> page(Pagination pagination) throws Exception {
        // 데이터 수 조회
        long total = boardMapper.count();
        pagination.setTotal(total);
        
        List<Board> list = boardMapper.page(pagination);
        return list;
    }

    @Override
    public PageInfo<Board> page(int page, int size) throws Exception {
        // PageHelper.startPage( 현재 번호, 페이지 당 데이터 수 )
        PageHelper.startPage(page, size);
        List<Board> list = boardMapper.list();

        // PageInfo<DTO>( 리스트, 노출 페이지 수 )
        PageInfo<Board> pageInfo = new PageInfo<>(list, 10);
        return pageInfo;
    }

    @Override
    public PageInfo<Board> page(int page, int size, int count) throws Exception {
        // PageHelper.startPage( 현재 번호, 페이지 당 데이터 수 )
        PageHelper.startPage(page, size);
        List<Board> list = boardMapper.list();

        // PageInfo<DTO>( 리스트, 노출 페이지 수 )
        PageInfo<Board> pageInfo = new PageInfo<>(list, count);
        return pageInfo;
    }
    
    @Override
    public PageInfo<Board> page(Params params) throws Exception {
        // PageHelper.startPage( 현재 번호, 페이지 당 데이터 수 )
        PageHelper.startPage(params.getPage(), params.getSize());
        // List<Board> list = boardMapper.list();
        List<Board> list = boardMapper.listWithParam(params);
    
        // PageInfo<DTO>( 리스트, 노출 페이지 수 )
        PageInfo<Board> pageInfo = new PageInfo<>(list, params.getCount());
        return pageInfo;
    }


}
