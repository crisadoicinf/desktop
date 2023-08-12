package com.crisado.desktop.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.crisado.desktop.service.GreetingService;

import jakarta.annotation.PostConstruct;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class FxmlController implements Controller {

	@Value("classpath:/main.fxml")
	private Resource template;
	@Getter
	private Parent parent;
	@FXML
	private Button button;
	@FXML
	private Text text;
	private final FXMLLoader fxmlLoader;
	private final GreetingService greetingService;

	@PostConstruct
	void initialize() throws IOException {
		fxmlLoader.setLocation(template.getURL());
		fxmlLoader.setController(this);
		parent = fxmlLoader.load();
		button.setOnAction(event -> text.setText(greetingService.getGreetings("crisado")));
	}
}
