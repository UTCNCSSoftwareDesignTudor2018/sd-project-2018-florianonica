package SD_project.Online_Weapons_And_Armor_Shop.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.AdministratorService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.MaterialService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.OrderProductService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.OrderService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.ProductService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.ReviewService;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Administrator;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdministratorService as;
	
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
	
	private Administrator a;
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ModelAndView startApp() {
		return new ModelAndView("login-page");
	}
	
	@RequestMapping(value ="/profile",  method = RequestMethod.POST)
    public ModelAndView studentProfile() {
		ModelAndView mv = new ModelAndView("admin-profile");
		mv.addObject("administrator", a);
        return mv;
    }

	public Administrator getA() {
		return a;
	}

	public void setA(Administrator a) {
		this.a = a;
	}
}
