package com.demo.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.springbootdemo.entity.Developer;
import com.demo.springbootdemo.entity.Team;
import com.demo.springbootdemo.enums.AlertType;
import com.demo.springbootdemo.model.Alert;
import com.demo.springbootdemo.repository.TeamRepository;

@Service
public class AlertService {

	@Autowired
	TeamRepository teamRepository;

	@Autowired
	TeamServiceImpl teamServiceImpl;

	@Autowired
	@Qualifier("SMSNotificationClient")
	GenericNotificationClient smsnotificationClient;

	public AlertService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String sendAlert(Long teamId, Alert alert) {
		Team team = teamServiceImpl.FindTeamById(teamId);
		List<Developer> devs = team.getDeveloper();
		int index = randomNumber(0, devs.size() - 1);
		Developer developer = devs.get(index);
		return postByType(developer, alert);

	}

	private String postByType(Developer dev, Alert alert) {
		switch (alert.getAlertType()) {
		case SMS: {
			return smsnotificationClient.postAlert(dev, alert);
		}
		default:
			return smsnotificationClient.postAlert(dev, alert);
		}

	}

	private int randomNumber(int min, int max) {
		return (int) (Math.random() * (max - min) + min);
	}

}
