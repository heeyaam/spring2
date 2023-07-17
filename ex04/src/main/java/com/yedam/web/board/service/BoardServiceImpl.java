package com.yedam.web.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.web.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	
	@Override
	public List<BoardVO> getBoardList() {
		
		return boardMapper.selectBoardAllList();
	}

	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		
		return boardMapper.selectBoardInfo(boardVO);
	}

	@Override
	public int insertBoardInfo(BoardVO boardVO) {
		int result = boardMapper.insertBoardInfo(boardVO);
		if(result ==1) {
			return boardVO.getBno();
		}else {
			return -1;
		}
	}

	@Override
	public int updateBoardInfo(BoardVO boardVO) {
		int result = boardMapper.updateBoardInfo(boardVO);
		if(result ==1) {
			return boardVO.getBno();
		}else {
			return -1;
		}
	}


	@Override
	public int deleteBoardInfo(int bno) {
		int result = boardMapper.deleteBoardInfo(bno);
				if(result == 1) {
					return bno;
				}else {
					return -1;
				}
	}



}
