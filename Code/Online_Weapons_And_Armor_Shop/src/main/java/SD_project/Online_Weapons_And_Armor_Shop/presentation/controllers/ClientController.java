package SD_project.Online_Weapons_And_Armor_Shop.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.ClientService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.MaterialService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.OrderProductService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.OrderService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.ProductService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.ReviewService;

@Controller
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private ClientService cs;
	
	@Autowired
	private ProductService ps;
	
	@Autowired
	private OrderService os;
	
	@Autowired
	private OrderProductService ops;
	
	@Autowired
	private MaterialService ms;
	
	@Autowired
	private ReviewService rs;
}
