package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("guest")
public class GuestbookController {

	//필드
	
	
	//생성자
	
	
	//메소드gs
	
	
	//메소드 일반
	@RequestMapping(value= "/addlist", method = {RequestMethod.GET, RequestMethod.POST})
	public String select() {
		System.out.println("GuestbookController()");
		
		return "";
	}
	
	@RequestMapping(value = "/remove", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete() {
		System.out.println("GuestbookController.delete()");
		
		return "";
	}
	
	
	
}
