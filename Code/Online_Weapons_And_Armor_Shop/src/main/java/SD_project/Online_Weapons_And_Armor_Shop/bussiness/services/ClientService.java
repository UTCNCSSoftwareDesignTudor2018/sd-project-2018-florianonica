package SD_project.Online_Weapons_And_Armor_Shop.bussiness.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SD_project.Online_Weapons_And_Armor_Shop.bussiness.validators.EmailValidator;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Client;
import SD_project.Online_Weapons_And_Armor_Shop.persistence.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository cr;
	
	public Client makeClient(Client c) {
		EmailValidator ev = new EmailValidator();
		ev.validate(c);
		return cr.save(c);
	}
	
	public List<Client> getAll() {
		return cr.findAll();
	}
	
	public void delete(Client s) {
		cr.delete(s);
	}
	
	public void deleteById(int id) {
		cr.deleteById(id);
	}
	
	public Client getById(int id) {
		return cr.findById(id).get();
	}
	
	public Client getByName(String fname, String lname) {
		return cr.findByFirstNameAndLastName(fname, lname);
	}
	
	public Client getByLogin(String user, String pass) {
		return cr.findByUsernameAndPassword(user, pass);
	}
}
