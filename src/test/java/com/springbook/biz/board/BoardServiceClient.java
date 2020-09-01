package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {

		//1. Spring 컨테이너 구동
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring 컨테이너로부터 BoardServiceImpl 객체를 Lookup한다.
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		BoardDTO vo = new BoardDTO();
		
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용....");
		boardService.insertBoard(vo);

		
		List<BoardDTO> boardList = boardService.getBoardList(vo);
		for(BoardDTO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
		container.close();
	}

}
