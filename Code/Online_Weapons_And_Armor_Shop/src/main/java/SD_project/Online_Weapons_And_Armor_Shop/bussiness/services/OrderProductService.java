package SD_project.Online_Weapons_And_Armor_Shop.bussiness.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SD_project.Online_Weapons_And_Armor_Shop.bussiness.validators.QuantityValidator;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.OrderProduct;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.repositories.OrderProductRepository;

@Service
public class OrderProductService {
	@Autowired
	private OrderProductRepository opr;
	
	public OrderProduct makeOrderProduct(OrderProduct op) {
		QuantityValidator qv = new QuantityValidator();
		qv.validate(op);
		return opr.save(op);
	}
	
	public List<OrderProduct> getAll() {
		return opr.findAll();
	}
	
	public void delete(OrderProduct op) {
		opr.delete(op);
	}
	
	public void deleteById(int id) {
		opr.deleteById(id);
	}
	
	public OrderProduct getById(int id) {
		return opr.findById(id).get();
	}
	
	public List<OrderProduct> getByProductId(int id) {
		return opr.findByProductId(id);
	}
	
	public List<OrderProduct> getByOrderId(int id) {
		return opr.findByOrderId(id);
	}
	
	public void deleteByProductId(int id) {
		opr.deleteByProductId(id);
	}
	
	public void deleteByOrderId(int id) {
		opr.deleteByOrderId(id);
	}
}
