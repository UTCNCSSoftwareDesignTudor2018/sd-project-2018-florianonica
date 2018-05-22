package SD_project.Online_Weapons_And_Armor_Shop.bussiness.validators;

import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.OrderProduct;

public class QuantityValidator implements Validator<OrderProduct>{
  public void validate(OrderProduct t) {
	if(t.getQuantity() < 0) {
 	  throw new IllegalArgumentException("The product quantity can't be negative!");
	}
  }
}
