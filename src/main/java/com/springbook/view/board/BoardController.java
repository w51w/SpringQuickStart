package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board") 	//Model에 "board"라는 이름으로 저장되는 데이터가 있다면
								//그 데이터를 세션(HttpSession)에도 자동 저장하라는 설정
public class BoardController {
	//검색 조건 목록 설정
	//아래의 어노테이션은 View(jsp)에서 사용할 데이터를 설정하는 용도로 사용할 수도 있다.
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardDTO vo, BoardDAO boardDAO) {		
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	@RequestMapping("/updateBoard.do")
	//스프링 컨테이너는 우선@ModelAttribute("board") 설정을 해석하여 board라는 이름으로 저장된 데이터가 있는 지를 확인한다.
	//있다면 세션에서 꺼내 매개변수로 선언된 vo 변수에 할당 그리고 사용자가 입력한 파라미터를 vo 객체에 할당 그리고 다시 세션 유지
	public String updateBoard(@ModelAttribute("board") BoardDTO vo, BoardDAO boardDAO) {	
		System.out.println(vo.toString());
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
		System.out.println(vo.getSeq());
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard.jsp";
	}
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardDTO vo , BoardDAO boardDAO, Model model) {
		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp";
	}
}
