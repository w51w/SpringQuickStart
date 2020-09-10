package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class GetBoardController implements Controller{

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회 처리");
		
		//1. 검색할 게시글 번호 추출
		String seq = request.getParameter("seq");
		//2. DB 연동 처리
		BoardDTO vo = new BoardDTO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardDTO board = boardDAO.getBoard(vo);
		
		//3. 응답 화면 구성
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		return "getBoard";
	}
	
}
