package SD_project.Online_Weapons_And_Armor_Shop.bussiness.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Product;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pr;

	public Product makeProduct(Product p) {
		return pr.save(p);
	}

	public List<Product> getAll() {
		return pr.findAll();
	}

	public void delete(Product p) {
		pr.delete(p);
	}

	public void deleteById(int id) {
		pr.deleteById(id);
	}

	public Product getById(int id) {
		return pr.findById(id).get();
	}

	public List<Product> getByPrice(int price) {
		return pr.findByPrice(price);
	}

	public List<Product> getByStock(int stock) {
		return pr.findByStock(stock);
	}

	public Product getByName(String name) {
		return pr.findByName(name);
	}

	public List<Product> getByType(String type) {
		return pr.findByType(type);
	}
}
