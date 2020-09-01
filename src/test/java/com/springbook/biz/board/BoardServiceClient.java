package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {

		//1. Spring �����̳� ����
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring �����̳ʷκ��� BoardServiceImpl ��ü�� Lookup�Ѵ�.
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		BoardDTO vo = new BoardDTO();
		
		vo.setTitle("�ӽ� ����");
		vo.setWriter("ȫ�浿");
		vo.setContent("�ӽ� ����....");
		boardService.insertBoard(vo);

		
		List<BoardDTO> boardList = boardService.getBoardList(vo);
		for(BoardDTO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
		container.close();
	}

}
