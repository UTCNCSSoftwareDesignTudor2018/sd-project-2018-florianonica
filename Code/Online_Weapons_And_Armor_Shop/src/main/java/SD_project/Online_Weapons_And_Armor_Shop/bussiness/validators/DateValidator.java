package SD_project.Online_Weapons_And_Armor_Shop.bussiness.validators;

import java.time.LocalDate;

import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Order;

public class DateValidator implements Validator<Order>{
  public void validate(Order t) {
	if(t.getDate().after(java.sql.Date.valueOf(LocalDate.now()))) {
   	  throw new IllegalArgumentException("Order date can not be in the future");
	}
  }
}
