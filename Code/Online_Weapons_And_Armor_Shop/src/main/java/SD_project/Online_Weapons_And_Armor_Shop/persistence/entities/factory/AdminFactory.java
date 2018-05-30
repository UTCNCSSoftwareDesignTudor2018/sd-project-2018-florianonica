package SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.factory;

import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Administrator;

public class AdminFactory {
	public Administrator getAdmin(int i) {
		Administrator a = new Administrator();
		a.setId(i);
		a.setEmail("admin" + i + "@email.com");
		a.setAddress("address admin" + i);
		a.setFirstName("admin_" + i + "_firstName");
		a.setLastName(("admin_" + i + "_lastName"));
		a.setUsername("admin" + i);
		a.setPassword("pass" + i);
		return a;
	}
}
