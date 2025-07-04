package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVO;

@Repository
public class GuestbookDAO {

	// 필드
	@Autowired
	private SqlSession sqlSession;
	// 0. import java.sql.*;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/guestbook_db";
	private String id = "guestbook";
	private String pw = "guestbook";


	private void connect() {
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);
			// System.out.println("접속성공");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	private void close() {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	//전체데이터 가져오기
	public List<GuestbookVO> guestbookSelect() {
		System.out.println("GuestbookDAO.guestbookSelect()");
		
		//SqlSession sqlSession = new SqlSession();
		List<GuestbookVO> guestbookList = sqlSession.selectList("guestbook.selectList");
		
		
		return guestbookList;
	}

	//저장하기
	public int guestbookInsert(GuestbookVO guestbookVO) {
		System.out.println("GuestbookDAO.guestbookInsert()");
		
		int count = sqlSession.insert("guestbook.insert", guestbookVO);
		
		return count;
	}

	
	public int guestbookDelete(GuestbookVO guestbookVO) {
		System.out.println("GuestbookDAO.guestbookDelete()");
		
		int count = sqlSession.delete("guestbook.delete", guestbookVO);
		
		
		return count;
	}

}
