package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Cloth;
import com.example.service.ClothService;

@Controller
@RequestMapping("/cloth")
public class ClothController {
	
	@Autowired
	ClothService service;
	
	@RequestMapping("")
	public String search(Model model) {
		
		List<String> colorList = new ArrayList<>();
		
		colorList.add("赤");
		colorList.add("青");
		colorList.add("白");
		colorList.add("黄");
		
		model.addAttribute("colorList", colorList);
		
		return "search";
		
	}
	
	@RequestMapping("/result")
	public String result(Model model,Integer gender,String color) {
		
		List<Cloth> clothList = service.findByGenderAndColor(gender, color);
		model.addAttribute("clothList",clothList);
		
		return search(model);
		
	}
	
	

}
