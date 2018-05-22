package SD_project.Online_Weapons_And_Armor_Shop.bussiness.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Material;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.repositories.MaterialRepository;

@Service
public class MaterialService {
	@Autowired
	private MaterialRepository mr;
	
	public Material makeMaterial(Material m) {
		return mr.save(m);
	}
	
	public List<Material> getAll() {
		return mr.findAll();
	}
	
	public void delete(Material m) {
		mr.delete(m);
	}
	
	public void deleteById(int id) {
		mr.deleteById(id);
	}
	
	public Material getById(int id) {
		return mr.findById(id).get();
	}
	
	public Material getByName(String name) {
		return mr.findByName(name);
	}
}
