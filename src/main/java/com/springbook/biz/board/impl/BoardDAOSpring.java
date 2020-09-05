package com.springbook.biz.board.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardDTO;

@Repository
public class BoardDAOSpring{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values(?,?,?,?)";
	//seq 칼럼 autoincrement
	private final String BOARD_UPDATE = "update from board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	
	public void insertBoard(BoardDTO vo) {
		System.out.println("===>Spring JDBC로 insertBoard() 기능 처리");
		jdbcTemplate.update(BOARD_INSERT,vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	public void updateBoard(BoardDTO vo) {
		System.out.println("===>Spring JDBC로 updateBoard() 기능 처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	public void deleteBoard(BoardDTO vo) {
		System.out.println("===>Spring JDBC로 deleteBoard() 기능 처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	
	public BoardDTO getBoard(BoardDTO vo) {
		System.out.println("===>Spring JDBC로 getBoard() 기능 처리");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	public List<BoardDTO> getBoardList(BoardDTO vo){
		System.out.println("===>Spring JDBC로 getBoardList() 기능 처리");
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
}
