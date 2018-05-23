package SD_project.Online_Weapons_And_Armor_Shop.presentation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView startApp()
    {
        return new ModelAndView("login-page");
    }
}