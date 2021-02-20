package com.demo.springbootdemo.service;

import com.demo.springbootdemo.entity.Developer;
import com.demo.springbootdemo.model.Alert;

public interface GenericNotificationClient {

	String url = "https://run.mocky.io/v3/fd99c100-f88a-4d70-aaf7-393dbbd5d99f";

	String postAlert(Developer dev, Alert alert);

}