package com.crisado.desktop.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

	public String getGreetings(String name) {
		return "Hello " + name + "!";
	}
}
