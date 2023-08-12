package com.crisado.desktop;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.crisado.desktop.controller.Controller;
import com.crisado.desktop.controller.FxmlController;
import com.crisado.desktop.controller.WebViewController;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxApplication extends Application {

	private ConfigurableApplicationContext applicationContext;

	@Override
	public void init() throws Exception {
		applicationContext = new SpringApplicationBuilder(DesktopApplication.class).run();
	}

	@Override
	public void start(Stage stage) throws Exception {
		//Controller pane = applicationContext.getBean(WebViewController.class);
		Controller pane = applicationContext.getBean(FxmlController.class);
		stage.setScene(new Scene(pane.getParent(), 960, 600));
		stage.show();
	}

	@Override
	public void stop() throws Exception {
		applicationContext.close();
		Platform.exit();
	}

}
