package com.demo.springbootdemo.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springbootdemo.entity.Developer;
import com.demo.springbootdemo.entity.Team;
import com.demo.springbootdemo.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService {
	
	
	
	public TeamServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	TeamRepository teamRepository;
	
	@Override
	public Team createTeam(Team team) {
		for(Developer dev :team.getDevelopers()) {
			dev.setTeam(team);
		}
		Team saved = teamRepository.save(team);
		return saved;
		
	}
	
	@Override
	public Team FindTeamById(Long teamId) {
		Optional<Team> saved = teamRepository.findById(teamId);
		if(!saved.isPresent()) {
			throw new EntityNotFoundException("Team with id {}"+ teamId + "is not found !!");
		}
		return saved.get();
		
	}

}
