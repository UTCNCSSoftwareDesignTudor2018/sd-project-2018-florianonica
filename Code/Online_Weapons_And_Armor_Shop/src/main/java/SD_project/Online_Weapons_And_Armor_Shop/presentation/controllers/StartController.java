package SD_project.Online_Weapons_And_Armor_Shop.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.AdministratorService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.ClientService;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Administrator;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Client;

@Controller
@RequestMapping("/start")
public class StartController {

	@Autowired
	private AdministratorService as;

	@Autowired
	private ClientService cs;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView startApp() {
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
			ModelAndView mvl = new ModelAndView("client-main-page");
			return mvl;
		} else if (a == null) {
			ModelAndView mvl = new ModelAndView("admin-main-page");
			return mvl;
		}
		ModelAndView mvl = new ModelAndView("login-page");
		return mvl;
	}
}