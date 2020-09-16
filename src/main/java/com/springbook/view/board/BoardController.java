package com.springbook.view.board;

import org.springframework.stereotype.Controller;
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
	public ModelAndView getBoard(BoardDTO vo , BoardDAO boardDAO, ModelAndView mav) {
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		return mav;
	}
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardDTO vo , BoardDAO boardDAO, ModelAndView mav) {
		mav.addObject("boardList", boardDAO.getBoardList(vo));
		mav.setViewName("getBoardList.jsp");
		return mav;
	}
}
