package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDAO;
import com.javaex.vo.GuestbookVO;

@Service
public class GuestbookService {

	//필드
	@Autowired
	private GuestbookDAO guestbookDAO;
	//생성자
	
	//메소드 gs
	
	//메소드 일반
	//-전체 방명록 리스트 가져오기
	public List<GuestbookVO> exeGetGuestbookList() {
		System.out.println("GuestbookService.exeGetGuestbookList");
		
		//GuestbookDAO guestbookDAO = new GuestbookDAO();
		List<GuestbookVO> guestbookList = guestbookDAO.guestbookSelect();
		
		return guestbookList;
	}
	
	//-방명록 글 저장하기
	public int exeGuestbookAdd(GuestbookVO guestbookVO) {
		//System.out.println("GuestbookService.exeGuestbookAdd");
		
		//dao를 통해서 일한다
		//GuestbookDAO guestbookDAO = new GuestbookDAO();
		int count = guestbookDAO.guestbookInsert(guestbookVO);
		
		return count;
	}
	
	//방명록 삭제
	public int exeGuestbookRemove(GuestbookVO guestbookVO) {
		//System.out.println("GuestbookService.exeGuestbookRemove");
		
		//GuestbookDAO guestbookDAO = new GuestbookDAO();
		
		int count = guestbookDAO.guestbookDelete(guestbookVO);
		
		return count;
	}
	
}
