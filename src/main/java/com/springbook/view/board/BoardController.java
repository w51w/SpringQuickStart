package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.BoardService;

@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired//BoardService 타입의 BoardServiceImpl 객체가 의존성 주입된다.
	private BoardService boardService;
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardDTO vo) throws IOException{		
		//파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {//파일이 있다면 아래 코드 실행
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:\\Book_SpringQuickStart\\BoardWeb\\" + fileName));
		}
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardDTO vo) {	
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardDTO vo) {		
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardDTO vo , Model model) {
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard.jsp";
	}
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardDTO vo , Model model) {
		//null check , 로그인 성공 후 , 글 상세에서 글 목록으로 나올 때는 null인 상태이다.
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";
	}
}
