package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.TeamService;

@Controller
@RequestMapping("team")
public class TeamController {
	
	@Autowired
	TeamService service;
	
	@RequestMapping("")
	public String showList(Model model) {
		
		model.addAttribute("teamList",service.findAll()) ;
		
		return "list";
		
	}

}
