package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class DeleteBoardController  {

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardDTO vo, BoardDAO boardDAO) {		
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
}
