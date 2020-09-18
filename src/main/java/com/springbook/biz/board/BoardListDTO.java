package com.springbook.biz.board;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

//XML문서는 반드시 단 하나의 루트 엘리먼트를 가져야 한다.
//BoardDTO는 하나의 게시글의 정보
//하지만 우리는 여러 게시글 목록을 XML로 표현해야 한다.
@XmlRootElement(name = "boardList")
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardListDTO {
	@XmlElement(name = "board")
	private List<BoardDTO> boardList;

	public List<BoardDTO> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<BoardDTO> boardList) {
		this.boardList = boardList;
	}
	
}
