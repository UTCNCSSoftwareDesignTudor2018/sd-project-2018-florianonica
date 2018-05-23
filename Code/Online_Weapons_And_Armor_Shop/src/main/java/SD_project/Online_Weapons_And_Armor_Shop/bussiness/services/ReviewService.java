package SD_project.Online_Weapons_And_Armor_Shop.bussiness.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Review;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.repositories.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository rr;
	
	public Review makeReview(Review r) {
		return rr.save(r);
	}
	
	public List<Review> getAll() {
		return rr.findAll();
	}
	
	public void delete(Review r) {
		rr.delete(r);
	}
	
	public void deleteById(int id) {
		rr.deleteById(id);
	}
	
	public Review getById(int id) {
		return rr.findById(id).get();
	}
	
	public List<Review> getByProductId(int id) {
		return rr.findByProductId(id);
	}
	
	public List<Review> getByFlagged(Boolean flag) {
		return rr.findByFlagged(flag);
	}
}
