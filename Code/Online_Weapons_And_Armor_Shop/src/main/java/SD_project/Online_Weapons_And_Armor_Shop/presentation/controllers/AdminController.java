package SD_project.Online_Weapons_And_Armor_Shop.presentation.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.AdministratorService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.MaterialService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.ProductService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.ReviewService;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Administrator;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Material;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Product;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Review;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.factory.AdminFactory;

@Controller
// @RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdministratorService as;

	@Autowired
	private ProductService ps;

	@Autowired
	private MaterialService ms;

	@Autowired
	private ReviewService rs;

	private Administrator a;
	
	private Product p;

	@SuppressWarnings("unused")
	private Boolean logged;

	@RequestMapping(value = "/admin/profile", method = RequestMethod.POST)
	public ModelAndView studentProfile() {
		ModelAndView mv = new ModelAndView("admin-profile");
		mv.addObject("administrator", a);
		return mv;
	}

	@RequestMapping(value = "/admin/products", method = RequestMethod.POST)
	public ModelAndView shop() {
		ModelAndView mv = new ModelAndView("shop-main");
		List<Product> lp = ps.getAll();
		mv.addObject("allProducts", lp);
        return mv;
	}

	@RequestMapping(value = "/admin/shop/product", method = RequestMethod.POST)
	public ModelAndView prod(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("producta");
		String name = request.getParameter("productSelect");
		Product pro = ps.getByName(name);
		this.p = pro;
		mv.addObject("product", pro);
        return mv;
	}
	
	@RequestMapping(value = "/admin/shop/product/modify", method = RequestMethod.POST)
	public ModelAndView prodSave(@RequestParam(value = "name", required = false) String name,
    		@RequestParam(value = "description", required = false) String description,
    		@RequestParam(value = "price", required = false) int price,
    		@RequestParam(value = "stock", required = false) int stock) {
		ModelAndView mv = new ModelAndView("producta");
		Product pro = p;
		pro.setName(name);
		pro.setDescription(description);
		pro.setPrice(price);
		pro.setStock(stock);
		ps.makeProduct(pro);
		mv.addObject("product", pro);
        return mv;
	}
	
	@RequestMapping(value = "/admin/deleteprod", method = RequestMethod.POST)
	public ModelAndView prodDel() {
		ps.delete(p);
		ModelAndView mv = new ModelAndView("shop-main");
		List<Product> lp = ps.getAll();
		mv.addObject("allProducts", lp);
        return mv;
	}

	@RequestMapping(value = "/admin/shop/mat", method = RequestMethod.POST)
	public ModelAndView mat(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("material");
		String name = request.getParameter("materialSelect");
		Material m = ms.getByName(name);
		mv.addObject("material", m);
		return mv;
	}

	@RequestMapping(value = "/admin/create", method = RequestMethod.POST)
	public void createAdmin() {
		int i = as.getAll().size() + 1;
		AdminFactory factory = new AdminFactory();
		Administrator admin = factory.getAdmin(i);
		as.makeAdministrator(admin);
	}

	@RequestMapping(value = "/admin/flagged", method = RequestMethod.POST)
	public ModelAndView flagged() {
		List<Review> rr = rs.getByFlagged(true);
		ModelAndView mv = new ModelAndView("flagged-reviews");
		mv.addObject("Reviews", rr);
		return mv;
	}

	@RequestMapping(value = "/admin/unflag", method = RequestMethod.POST)
	public ModelAndView unflag(@RequestParam(value = "revID", required = false) int id) {
		Review r = rs.getById(id);
		r.setFlagged(false);
		rs.makeReview(r);
		List<Review> rr = rs.getByFlagged(true);
		ModelAndView mv = new ModelAndView("flagged-reviews");
		mv.addObject("Reviews", rr);
		return mv;
	}

	@RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
	public ModelAndView deleteRev(@RequestParam(value = "revID", required = false) int id) {
		rs.deleteById(id);
		List<Review> rr = rs.getByFlagged(true);
		ModelAndView mv = new ModelAndView("flagged-reviews");
		mv.addObject("Reviews", rr);
		return mv;
	}

	public Administrator getA() {
		return a;
	}

	public void setA(Administrator a) {
		this.a = a;
	}

	public void setLogged(Boolean logged) {
		this.logged = logged;
	}
}
