package SD_project.Online_Weapons_And_Armor_Shop.bussiness.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Order;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository or;
	
	public Order makeOrder(Order o) {
		return or.save(o);
	}
	
	public List<Order> getAll() {
		return or.findAll();
	}
	
	public void delete(Order o) {
		or.delete(o);
	}
	
	public void deleteById(int id) {
		or.deleteById(id);
	}
	
	public Order getById(int id) {
		return or.findById(id).get();
	}
	
	public List<Order> getByClientId(int id) {
		return or.findByClientId(id);
	}
	
	public List<Order> getByDate(Date date) {
		return or.findByDate(date);
	}
}
