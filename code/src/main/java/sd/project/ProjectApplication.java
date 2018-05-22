package sd.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sd.project.data.repository.CategoryJpaRepository;
import sd.project.data.repository.ClientJpaRepository;
import sd.project.data.repository.OrderDetailsJpaRepository;
import sd.project.data.repository.OrderJpaRepository;
import sd.project.data.repository.ProductJpaRepository;
import sd.project.data.repository.SellerJpaRepository;
import sd.project.presentation.controller.MainController;
import sd.project.presentation.view.MainView;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner{
	@Autowired
	ClientJpaRepository clientRepo;
	@Autowired
	OrderJpaRepository orderRepo;
	@Autowired
	OrderDetailsJpaRepository orderDetailsRepo;
	@Autowired
	ProductJpaRepository productRepo;
	@Autowired
	CategoryJpaRepository categoryRepo;
	@Autowired
	SellerJpaRepository sellerRepo;
	@Autowired
	MainView mainView;
	@Autowired
	MainController controller;
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		mainView.getFrame().setVisible(true);
		controller.setMainView(mainView);
		System.out.println(clientRepo.findAll().toString());
		System.out.println(orderRepo.findAll().toString());
		System.out.println(orderDetailsRepo.findAll().toString());
		System.out.println(productRepo.findAll().toString());
		System.out.println(categoryRepo.findAll().toString());
	}
}
