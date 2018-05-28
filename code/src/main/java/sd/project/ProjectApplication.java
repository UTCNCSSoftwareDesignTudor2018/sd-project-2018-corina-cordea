package sd.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sd.project.presentation.controller.MainController;
import sd.project.presentation.view.MainView;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {
	@Autowired
	MainView mainView;
	@Autowired
	MainController controller;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mainView.getFrame().setVisible(true);
		controller.setMainView(mainView);
	}
}
