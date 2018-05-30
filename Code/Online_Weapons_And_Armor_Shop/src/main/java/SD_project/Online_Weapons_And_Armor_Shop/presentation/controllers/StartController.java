package SD_project.Online_Weapons_And_Armor_Shop.presentation.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.AdministratorService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.ClientService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.OrderService;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Administrator;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Client;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Order;

@Controller
@RequestMapping("/start")
public class StartController {

	@Autowired
	private AdministratorService as;

	@Autowired
	private ClientService cs;
	
	@Autowired
	private OrderService os;
	
	@Autowired
	private AdminController ac;
	
	@Autowired
	private ClientController cc;
	
	private int clientID;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView startApp() {
		cc.setLogged(false);
		ac.setLogged(false);
		return new ModelAndView("login-page");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password) {
		Client c = cs.getByLogin(username, password);
		Administrator a = as.getByLogin(username, password);
		if (c == null && a == null) {
			ModelAndView mvl = new ModelAndView("login-page");
			mvl.addObject("loginError", true);
			return mvl;
		} else if (c == null) {
			ModelAndView mvl = new ModelAndView("admin-main-page");
			mvl.addObject("administrator", a);
			ac.setLogged(true);
			ac.setA(a);
			return mvl;
		} else if (a == null) {
			ModelAndView mvl = new ModelAndView("client-main-page");
			Order o = new Order();
			o.setClient(c);
			o.setDate(java.sql.Date.valueOf(LocalDateTime.now().toLocalDate()));
			o.setPayment("none");
			mvl.addObject("client", c);
			cc.setLogged(true);
			cc.setC(c);
			os.makeOrder(o);
			cc.setO(o);
			return mvl;
		}
		ModelAndView mvl = new ModelAndView("login-page");
		return mvl;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signUp(){
		Client c = new Client();
		ModelAndView mv = new ModelAndView("sign-up");
		mv.addObject("client", c);
		return mv;
	}
		
	@RequestMapping(value = "/signup/sign", method = RequestMethod.POST)
	public ModelAndView sign(@RequestParam(value = "username", required=false) String username,
    		@RequestParam(value = "password", required=false) String password,
    		@RequestParam(value = "cpassword", required=false) String cpassword,
    		@RequestParam(value = "firstName", required=false) String firstName,
    		@RequestParam(value = "lastName", required=false) String lastName,
    		@RequestParam(value = "email", required=false) String email,
    		@RequestParam(value = "address", required=false) String address) {
		if (!password.equals(cpassword)) {
			ModelAndView mvl = new ModelAndView("sign-up");
			Client c = new Client();
			mvl.addObject("loginError", true);
			mvl.addObject("client", c);
			return mvl;
		}
		Client c = new Client();
		clientID = cs.getAll().size() + 1;
		c.setId(clientID);
		c.setUsername(username);
		c.setPassword(password);
		c.setAddress(address);
		c.setEmail(email);
		c.setCard("");
		c.setFirstName(firstName);
		c.setLastName(lastName);
		cs.makeClient(c);
		ModelAndView mvl = new ModelAndView("login-page");
		mvl.addObject("signUpSuccess", true);
		return mvl;
	}
}