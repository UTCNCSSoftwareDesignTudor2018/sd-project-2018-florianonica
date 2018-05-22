package SD_project.Online_Weapons_And_Armor_Shop.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{
	public List<Review> findAll();
	public Optional<Review> findById(int id);
	public List<Review> findByProductId(int id);
	public List<Review> findByFlagged(Boolean flag);
}
