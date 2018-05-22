package SD_project.Online_Weapons_And_Armor_Shop.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.OrderProduct;

@Repository
public interface OrderProductRepository {
	public List<OrderProduct> findAll();
	public Optional<OrderProduct> findById(int id);
	public OrderProduct findByOrderOrderid(int id);
	public OrderProduct findByProductProductid(int id);
}
