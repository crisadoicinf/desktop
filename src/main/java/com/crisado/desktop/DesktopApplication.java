package com.crisado.desktop;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;

@SpringBootApplication
public class DesktopApplication {

	public static void main(String[] args) {
		Application.launch(FxApplication.class, args);
	}

}
