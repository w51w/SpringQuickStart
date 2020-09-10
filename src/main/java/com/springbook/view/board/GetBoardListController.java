package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;


public class GetBoardListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ��� �˻� ó��");
		
		//1. ����� �Է� ���� ����(�˻� ����� ���߿�)
		//2. DB ���� ó��
		BoardDTO vo = new BoardDTO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardDTO> boardList = boardDAO.getBoardList(vo);
		
//		//3. �˻� ����� ���ǿ� �����ϰ� ��� ȭ������ �̵��Ѵ�.
//		���߿� HttpServlet��ü�� �ٲ� �� 
//		�ֳĸ� HttpSession�� �������� ���� �޸𸮿� �ϳ��� �����Ǳ⿡ ������ �δ㽺����
//		HttpSession session = request.getSession();
//		session.setAttribute("boardList", boardList);
//		return "getBoardList";
		
		//3. �˻� ����� ȭ�� ������ ModelAndView�� �����Ͽ� �����Ѵ�.
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList");
		return mav;
	}
}
