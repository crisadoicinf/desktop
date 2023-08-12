package com.crisado.desktop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javafx.fxml.FXMLLoader;

@Configuration
public class FxmlConfiguration {

	@Bean
	FXMLLoader fxmlLoader() {
		return new FXMLLoader();
	}
}
