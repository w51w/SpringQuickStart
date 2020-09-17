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
@SessionAttributes("board") 	//Model�� "board"��� �̸����� ����Ǵ� �����Ͱ� �ִٸ�
								//�� �����͸� ����(HttpSession)���� �ڵ� �����϶�� ����
public class BoardController {
	//�˻� ���� ��� ����
	//�Ʒ��� ������̼��� View(jsp)���� ����� �����͸� �����ϴ� �뵵�� ����� ���� �ִ�.
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardDTO vo, BoardDAO boardDAO) {		
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	@RequestMapping("/updateBoard.do")
	//������ �����̳ʴ� �켱@ModelAttribute("board") ������ �ؼ��Ͽ� board��� �̸����� ����� �����Ͱ� �ִ� ���� Ȯ���Ѵ�.
	//�ִٸ� ���ǿ��� ���� �Ű������� ����� vo ������ �Ҵ� �׸��� ����ڰ� �Է��� �Ķ���͸� vo ��ü�� �Ҵ� �׸��� �ٽ� ���� ����
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
