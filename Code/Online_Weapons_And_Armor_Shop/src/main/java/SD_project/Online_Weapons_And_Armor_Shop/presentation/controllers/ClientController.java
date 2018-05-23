package SD_project.Online_Weapons_And_Armor_Shop.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.ClientService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.MaterialService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.OrderProductService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.OrderService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.ProductService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.ReviewService;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Client;

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
	
	private Client c;
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ModelAndView startApp() {
		return new ModelAndView("login-page");
	}
	
	@RequestMapping(value ="/profile",  method = RequestMethod.POST)
    public ModelAndView studentProfile() {
		ModelAndView mv = new ModelAndView("client-profile");
		mv.addObject("client", c);
        return mv;
    }

	public Client getC() {
		return c;
	}

	public void setC(Client c) {
		this.c = c;
	}
}
