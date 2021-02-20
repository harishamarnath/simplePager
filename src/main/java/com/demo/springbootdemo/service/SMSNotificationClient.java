package com.demo.springbootdemo.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.demo.springbootdemo.entity.Developer;
import com.demo.springbootdemo.model.Alert;
import com.demo.springbootdemo.model.Notification;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SMSNotificationClient implements  GenericNotificationClient {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ObjectMapper mapper;

	@Override
	public String postAlert(Developer dev, Alert alert) {
		Notification notif = new Notification();
		notif.setMessage(alert.getAdditionalMessage());
		notif.setPhone(dev.getPhone());
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		String body;
		try {
			body = mapper.writeValueAsString(notif);
			HttpEntity<String> entity = new HttpEntity<String>(body, headers);

			String resp = restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
			return resp;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			return "Faied";
			
		}
	// not handling exception because of no time
		
	}

}
