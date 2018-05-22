package SD_project.Online_Weapons_And_Armor_Shop.bussiness.validators;

import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Product;

public class PriceValidator implements Validator<Product> {
  public void validate(Product t) {
	if(t.getPrice() < 0) {
      throw new IllegalArgumentException("The product stock can't be negative!");
	}
  }
}
