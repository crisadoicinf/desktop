package com.crisado.desktop.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.crisado.desktop.service.GreetingService;

import jakarta.annotation.PostConstruct;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import netscape.javascript.JSObject;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class WebViewController implements Controller {

	@Value("classpath:/main.html")
	private Resource template;
	@Getter
	private Parent parent;
	private final GreetingService greetingService;

	@PostConstruct
	void initialize() throws IOException {
		WebView webView = new WebView();
		WebEngine engine = webView.getEngine();
		engine.loadContent(template.getContentAsString(StandardCharsets.UTF_8));
		engine.documentProperty().addListener((observable, oldValue, newDocument) -> {
			JSObject window = (JSObject) engine.executeScript("window");
			window.setMember("greetingService", greetingService);
		});
		parent = new VBox(webView);
	}

}
