package com.springbook.biz.board;

import java.util.List;


public interface BoardService {

	//글 등록
	void insertBoard(BoardDTO vo);

	//글 수정
	void updateBoard(BoardDTO vo);

	//글 삭제
	void deleteBoard(BoardDTO vo);

	//글 상세 조회
	BoardDTO getBoard(BoardDTO vo);

	//글 목록 조회
	List<BoardDTO> getBoardList(BoardDTO vo);

}