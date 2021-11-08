package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * 演習2　サービス
 * @author igayuki
 *
 */
@Service
public class HotelService {
	
	@Autowired
	HotelRepository repository;
	
	public List<Hotel> findByPrice(Integer price)  {
		
		return repository.findByPrice(price);
		
	}
	
	public List<Hotel> findByPrice() {
		
		return repository.findByPrice();
		
	}

}
