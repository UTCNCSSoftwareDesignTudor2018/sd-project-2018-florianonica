package SD_project.Online_Weapons_And_Armor_Shop.persistence.repositories;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Order;

@Repository
public interface OrderRepository {
	public List<Order> findAll();
	public Optional<Order> findById(int id);
	public List<Order> findByClientId(int id);
	public List<Order> findByDate(Date date);
}
