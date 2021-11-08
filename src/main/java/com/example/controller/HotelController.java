package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.repository.HotelRepository;

/**
 * 演習2　リクエスト＆レスポンス用コントローラ
 * @author igayuki
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	HotelRepository repository;
	
	@RequestMapping("/")
	public String input() {
		
		return "input";
		
	}

}
