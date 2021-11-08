package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Cloth;
import com.example.repository.ClothRepository;

/**
 * コントローラーとレポジトリー間のサービスクラス
 * @author igayuki
 *
 */
@Service
public class ClothService {
	
	@Autowired
	ClothRepository repository;
	
	/**
	 * レポジトリーのメソッド呼び出し
	 * @param gender
	 * @param color
	 * @return
	 */
	public  List<Cloth> 
		findByGenderAndColor(Integer gender,String color) {
		
		List<Cloth> clothList = repository.findByGenderAndColor(gender, color);
		
		return clothList;
		
	}

}
