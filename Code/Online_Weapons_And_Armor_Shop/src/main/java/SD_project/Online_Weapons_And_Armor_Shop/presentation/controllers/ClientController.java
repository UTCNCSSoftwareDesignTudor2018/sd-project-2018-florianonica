package SD_project.Online_Weapons_And_Armor_Shop.presentation.controllers;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.MaterialService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.OrderProductService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.OrderService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.ProductService;
import SD_project.Online_Weapons_And_Armor_Shop.bussiness.services.ReviewService;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Client;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Material;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Order;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.OrderProduct;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Product;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Review;

@Controller
//@RequestMapping("/client")
public class ClientController {
	
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
	
	@SuppressWarnings("unused")
	private Boolean logged = false;
	
	private Order o;
	
	private Product p;
	
	@RequestMapping(value ="/client/profile",  method = RequestMethod.POST)
    public ModelAndView studentProfile() {
		ModelAndView mv = new ModelAndView("client-profile");
		mv.addObject("client", c);
        return mv;
    }

	@RequestMapping(value ="/client/shop",  method = RequestMethod.POST)
    public ModelAndView shop() {
		ModelAndView mv = new ModelAndView("shop-mainc");
		List<Product> lp = ps.getAll();
		lp.removeIf(obj -> obj.getStock() <= 0);
		List<Material> lm = ms.getAll();
		mv.addObject("allProducts", lp);
		mv.addObject("allMaterials", lm);
        return mv;
    }
	
	@RequestMapping(value ="/client/shop/product",  method = RequestMethod.POST)
    public ModelAndView prod(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("productc");
		String name = request.getParameter("productSelect");
		Product pro = ps.getByName(name);
		this.p = pro;
		mv.addObject("product", pro);
		List<Review> r = rs.getByProductId(p.getId());
		mv.addObject("Reviews", r);
		System.out.println(r.size());
        return mv;
    }
	
	@RequestMapping(value ="/client/shop/product/add",  method = RequestMethod.POST)
    public ModelAndView addToCart() {
		OrderProduct op = new OrderProduct();
		op.setOrder(o);
		op.setProduct(p);
		op.setQuantity(1);
		ops.makeOrderProduct(op);
		ModelAndView mv = new ModelAndView("productc");
		Product pro = p;
		List<Review> r = rs.getByProductId(p.getId());
		mv.addObject("product", pro);
		mv.addObject("Reviews", r);
        return mv;
    }
	
	@RequestMapping(value ="/client/shop/mat",  method = RequestMethod.POST)
    public ModelAndView mat(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("materialc");
		String name = request.getParameter("materialSelect");
		Material m = ms.getByName(name);
		mv.addObject("material", m);
        return mv;
    }
	
	@RequestMapping(value ="/client/flag",  method = RequestMethod.POST)
    public ModelAndView flag(@RequestParam(value = "revID", required = false) int id) {
		Review r = rs.getById(id);
		r.setFlagged(true);
		rs.makeReview(r);
		ModelAndView mv = new ModelAndView("productc");
		Product pro = p;
		List<Review> rr = rs.getByProductId(p.getId());
		mv.addObject("product", pro);
		mv.addObject("Reviews", rr);
        return mv;
    }
	
	@RequestMapping(value ="/client/checkout",  method = RequestMethod.POST)
    public ModelAndView checkout(HttpServletRequest request) {
		String pay = request.getParameter("paymentMethod");
		o.setPayment(pay);
		os.makeOrder(o);
		o = new Order();
		o.setClient(c);
		o.setDate(java.sql.Date.valueOf(LocalDateTime.now().toLocalDate()));
		o.setPayment("none");
		os.makeOrder(o);
		ModelAndView mv = new ModelAndView("client-main-page");
		mv.addObject("client", c);
        return mv;
    }
	
	@RequestMapping(value ="/client/delete",  method = RequestMethod.POST)
    public ModelAndView deleteItem(@RequestParam(value = "opID", required = false) int id) {
		ops.deleteById(id);
		List<OrderProduct> op = ops.getByOrderId(o.getId());
		ModelAndView mv = new ModelAndView("cart");
		mv.addObject("Products", op);
        return mv;
    }
	
	@RequestMapping(value ="/client/cart",  method = RequestMethod.POST)
    public ModelAndView cart() {
		List<OrderProduct> op = ops.getByOrderId(o.getId());
		ModelAndView mv = new ModelAndView("cart");
		mv.addObject("Products", op);
        return mv;
    }
	
	public Client getC() {
		return c;
	}

	public void setC(Client c) {
		this.c = c;
	}
	
	public void setLogged(Boolean logged) {
		this.logged = logged;
	}

	public Order getO() {
		return o;
	}

	public void setO(Order o) {
		this.o = o;
	}
}
