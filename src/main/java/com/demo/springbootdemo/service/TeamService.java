package com.demo.springbootdemo.service;

import com.demo.springbootdemo.entity.Team;

public interface TeamService {

	Team createTeam(Team team);

	Team FindTeamById(Long teamId);

}