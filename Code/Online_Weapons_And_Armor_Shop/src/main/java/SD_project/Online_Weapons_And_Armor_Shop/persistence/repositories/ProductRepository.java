package SD_project.Online_Weapons_And_Armor_Shop.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Product;

@Repository
public interface ProductRepository {
	public List<Product> findAll();
	public Optional<Product> findById(int id);
	public List<Product> findByPrice(int price);
	public List<Product> findByStock(int stock);
	public Product findByName(String name);
	public List<Product> findByType(String type);
}
