package com.springbook.biz.board;

import java.util.List;

public interface BoardService {

	//�� ���
	void insertBoard(BoardDTO vo);

	//�� ����
	void updateBoard(BoardDTO vo);

	//�� ����
	void deleteBoard(BoardDTO vo);

	//�� �� ��ȸ
	BoardDTO getBoard(BoardDTO vo);

	//�� ��� ��ȸ
	List<BoardDTO> getBoardList(BoardDTO vo);

}