package SD_project.Online_Weapons_And_Armor_Shop.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer>{
	public List<Administrator> findAll();
	public Optional<Administrator> findById(int id);
	public Administrator findByUsernameAndPassword(String username, String password);
	public Administrator findByFirstNameAndLastName(String firstName, String lastName);
}
