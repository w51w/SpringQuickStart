package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class UpdateBoardController implements Controller{

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ���� ó��");
		
		//1. ����� �Է� ���� ����
		//request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String seq = request.getParameter("seq");
		
		//2. DB ���� ó��
		BoardDTO vo = new BoardDTO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateBoard(vo);
		
		//3. ȭ�� �׺���̼�
		return "getBoardList.do";
	}

}
