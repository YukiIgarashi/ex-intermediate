package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Team;
import com.example.repository.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	TeamRepository repository;
	
	public List<Team> findAll() {
		
		return repository.findAll();
		
	}
	
	public Team findById(Integer id)  {
		
		return repository.findById(id);
		
	}

}
