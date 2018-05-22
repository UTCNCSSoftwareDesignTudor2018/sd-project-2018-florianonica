package SD_project.Online_Weapons_And_Armor_Shop.bussiness.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Administrator;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.repositories.AdministratorRepository;

@Service
public class AdministratorService {
	@Autowired
	private AdministratorRepository ar;
	
	public Administrator makeAdministrator(Administrator a) {
		return ar.save(a);
	}
	
	public List<Administrator> getAll() {
		return ar.findAll();
	}
	
	public void delete(Administrator a) {
		ar.delete(a);
	}
	
	public void deleteById(int id) {
		ar.deleteById(id);
	}
	
	public Administrator getById(int id) {
		return ar.findById(id).get();
	}
	
	public Administrator getByName(String fname, String lname) {
		return ar.findByFirstNameAndLastName(fname, lname);
	}
	
	public Administrator getByLogin(String user, String pass) {
		return ar.findByUsernameAndPassword(user, pass);
	}
}
