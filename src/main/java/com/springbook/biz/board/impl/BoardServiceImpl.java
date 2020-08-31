package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardDTO vo) {
		if(vo.getSeq() == 0) {
			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
		}
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardDTO vo) {
		boardDAO.updateBoard(vo);		
	}

	@Override
	public void deleteBoard(BoardDTO vo) {
		boardDAO.deleteBoard(vo);		
	}

	@Override
	public BoardDTO getBoard(BoardDTO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardDTO> getBoardList(BoardDTO vo) {
		return boardDAO.getBoardList(vo);
	}

}
