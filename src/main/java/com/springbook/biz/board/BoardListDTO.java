package com.springbook.biz.board;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

//XML������ �ݵ�� �� �ϳ��� ��Ʈ ������Ʈ�� ������ �Ѵ�.
//BoardDTO�� �ϳ��� �Խñ��� ����
//������ �츮�� ���� �Խñ� ����� XML�� ǥ���ؾ� �Ѵ�.
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
