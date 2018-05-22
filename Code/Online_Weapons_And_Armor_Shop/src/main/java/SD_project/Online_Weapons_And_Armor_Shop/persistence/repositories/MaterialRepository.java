package SD_project.Online_Weapons_And_Armor_Shop.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Material;

@Repository
public interface MaterialRepository {
	public List<Material> findAll();
	public Optional<Material> findById(int id);
	public Material findByName(String name);
}
