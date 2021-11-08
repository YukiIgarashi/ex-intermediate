package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.repository.HotelRepository;
import com.example.service.HotelService;

/**
 * 演習2　リクエスト＆レスポンス用コントローラ
 * @author igayuki
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	HotelService service;
	
	@RequestMapping("/")
	public String input() {
		
		return "input";
		
	}
	
	@RequestMapping("/search")
	public String search(Integer price,Model model) {
		
		model.addAttribute("hotelList",service.findByPrice(price));
		
		return "/hotel/";
		
	}

}
