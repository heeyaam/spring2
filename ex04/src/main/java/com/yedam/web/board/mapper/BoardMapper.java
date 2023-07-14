package com.yedam.web.board.mapper;

import java.util.List;

import com.yedam.web.board.service.BoardVO;

public interface BoardMapper {
	
	// mapper.xml을 만들때 database-context 확인하여 mybatis 관련 이름설정확인
	//전체조회
	public List<BoardVO> selectBoardAllList();
	
	//단건조회
	public BoardVO selectBoardInfo(BoardVO boardVO);
	
	//등록
	public int insertBoardInfo(BoardVO boardVO);
	
	//1. 게시글 번호는 자동생성
	//2. 테이블을 참조해서 필수값과 옵션값을 구분해서 등록
	
	//수정(제목 || 내용 || 이미지)
	// 2) updatedate : 수정날짜는 항상 수정 
	public int updateBoardInfo(BoardVO boardVO);
	
	//삭제
	public int deleteBoardInfo(int bno);

}
