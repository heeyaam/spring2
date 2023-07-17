package com.yedam.web.board.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.web.board.service.BoardService;
import com.yedam.web.board.service.BoardVO;




@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	//전체조회 : url
	// : 모든데이터의 게시글 본호,제목,작성자, 작성일(2023년07월17일) 단건조회 넘어가게 해야힘
	@GetMapping("/boardList")
	public String selectBoardAllList(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/boardList";
	}
	
	//단건조회 
	@GetMapping("/boardInfo")
	public String selectBoardInfo(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.getBoardInfo(boardVO);
		model.addAttribute("boardInfo", findVO);
		return "board/boardInfo";
	}
	
	@GetMapping("/boardInsert")
	public String boardInsertForm() {
		return "board/boardInsert";
	}
	
	@PostMapping("/boardInsert")
	public String boardInsertProcess(BoardVO boardVO) {
		boardService.insertBoardInfo(boardVO);
		return "redirect:boardList";
	}
	
	@GetMapping("boardUpdate")
	public String boardUpdate(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.getBoardInfo(boardVO);
		model.addAttribute("boardInfo", findVO);
		return "board/boardUpdate";
	}
	
	@PostMapping("/boardUpdate")
	@ResponseBody
	public Map<String, Object> boardUpdateProcess(BoardVO boardVO) {
		boolean result = false;
		
		int boardNO = boardService.updateBoardInfo(boardVO);
		
		if(boardNO >-1) {
			result = true;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("result", result);
		map.put("boardInfo", boardVO);
		
		return map;
	}
	
	@GetMapping("/boardDelete")
	public String boardDelete(@RequestParam(name="bno",defaultValue="0") int boardNO) {
		boardService.deleteBoardInfo(boardNO);
		return "redirect:boardList";
	}
	
}