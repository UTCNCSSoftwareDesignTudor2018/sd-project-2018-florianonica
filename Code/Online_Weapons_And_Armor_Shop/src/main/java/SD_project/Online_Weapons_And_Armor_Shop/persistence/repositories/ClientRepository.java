package SD_project.Online_Weapons_And_Armor_Shop.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Client;

@Repository
public interface ClientRepository {
	public List<Client> findAll();
	public Optional<Client> findById(int id);
	public Client findByUsernameAndPassword(String username, String password);
	public Client findByFirstNameAndLastName(String firstName, String lastName);
}
