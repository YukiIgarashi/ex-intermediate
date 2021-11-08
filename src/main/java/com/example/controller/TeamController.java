package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.TeamService;

/**
 * HTMLへの遷移、HTMLからのリクエストを受けるコントローラークラス
 * @author igayuki
 *
 */
@Controller
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	TeamService service;
	
	/**
	 * チームリストを表示するメソッド
	 * @param model　DBから手に入れたチームリストオブジェクトを詰めるスコープ
	 * @return　リストページへの遷移
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		
		model.addAttribute("teamList",service.findAll()) ;
		
		return "list";
		
	}
	
	/**
	 * 詳細ページを表示するメソッド
	 * @param id　詳細を表示したいチームのID
	 * @param model　表示するチームオブジェクトを詰めるスコープ
	 * @return　詳細ページへの遷移
	 */
	@RequestMapping("/showDetail")
	public String showDetail(Integer id,Model model) {
		
		model.addAttribute("team", service.findById(id));
		
		return "detail";
		
	}

}
