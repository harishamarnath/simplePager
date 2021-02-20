package com.demo.springbootdemo.controller;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootdemo.entity.Team;
import com.demo.springbootdemo.model.Alert;
import com.demo.springbootdemo.service.AlertService;
import com.demo.springbootdemo.service.TeamService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/team")
public class PagerDutyNotifyController {

	@Autowired
	TeamService teamService;
	
	@Autowired
	AlertService alertService;

	@PostMapping()
	@ResponseBody
	public ResponseEntity<Team> createteam(@RequestBody Team team) throws JsonProcessingException {

		Team savedTeam = teamService.createTeam(team);
		return new ResponseEntity<Team>(savedTeam, HttpStatus.CREATED);

	}
	
	@PostMapping("/alert")
	public ResponseEntity<String> postAlertteam(@RequestBody Alert alert) throws JsonProcessingException {

		String result = alertService.sendAlert(alert.getTeamId(),alert);
		return new ResponseEntity<String>(result, HttpStatus.CREATED);
		//always 200 error code , need to change

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Team> getDepartment(@PathVariable Long id) throws JsonProcessingException {

		Team team = teamService.FindTeamById(id);
		
		
		return new ResponseEntity(team, HttpStatus.ACCEPTED);
	}
}
