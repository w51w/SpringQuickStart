package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController  {

	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardDTO vo, BoardDAO boardDAO) {		
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	
}
