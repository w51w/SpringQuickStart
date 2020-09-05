package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO  {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String BOARD_INSERT = "insert into board(title, writer, content) values(?,?,?)";
	//seq Į�� autoincrement
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	//�� ���
	public void insertBoard(BoardDTO vo) {
		System.out.println("===>JDBC�� insertBoard() ��� ó��");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(pstmt, conn);
		}
	}
	//�� ����
	public void updateBoard(BoardDTO vo) {
		System.out.println("===>JDBC�� updateBoard() ��� ó��");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getSeq());
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(pstmt, conn);
		}
	}
	//�� ����
	public void deleteBoard(BoardDTO vo) {
		System.out.println("===>JDBC�� deleteBoard() ��� ó��");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	//�� �� ��ȸ
	public BoardDTO getBoard(BoardDTO vo) {
		System.out.println("===>JDBC�� getBoard() ��� ó��");
		BoardDTO board = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, vo.getSeq());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new BoardDTO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(rs, pstmt, conn);
		}
		return board;
	}
	
	//�� ��� ��ȸ
	public List<BoardDTO> getBoardList(BoardDTO vo){
		System.out.println("===>JDBC�� getBoardList() ��� ó��");
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			JDBCUtil.close(rs, pstmt, conn);
		}
		return boardList;
	}
}
