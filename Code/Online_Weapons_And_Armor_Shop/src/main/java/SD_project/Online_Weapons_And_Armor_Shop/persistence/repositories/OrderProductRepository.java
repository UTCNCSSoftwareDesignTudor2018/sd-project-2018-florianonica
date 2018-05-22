package SD_project.Online_Weapons_And_Armor_Shop.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.OrderProduct;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer>{
	public List<OrderProduct> findAll();
	public Optional<OrderProduct> findById(int id);
	public List<OrderProduct> findByOrderId(int id);
	public List<OrderProduct> findByProductId(int id);
	public OrderProduct deleteByOrderId(int id);
	public OrderProduct deleteByProductId(int id);
}
