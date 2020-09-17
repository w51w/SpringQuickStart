package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardDTO vo, BoardDAO boardDAO) {		
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardDTO vo, BoardDAO boardDAO) {		
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardDTO vo, BoardDAO boardDAO) {		
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardDTO vo , BoardDAO boardDAO, Model model) {
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard.jsp";
	}
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardDTO vo , BoardDAO boardDAO, Model model) {
		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp";
	}
}
