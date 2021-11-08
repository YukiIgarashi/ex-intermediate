package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("")
	public String input() {
		
		return "input";
		
	}
	
	@RequestMapping("/searchByprice")
	public String searchByprice(String price,Model model) {
		String trimedPrice = price.replaceAll(" ", "");
		trimedPrice = trimedPrice.replaceAll("　", "");
		
		if("".equals(trimedPrice)) {
			model.addAttribute("hotelList",service.findByPrice());
		}else {
			int integerPrice = Integer.parseInt(trimedPrice);
			model.addAttribute("hotelList",service.findByPrice(integerPrice));
		}
		
		
		return "input";
		
	}
	


}
