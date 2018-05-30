package SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.builder;

import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.Product;

public class ProductBuilder {
	public String type;
	public String name;
	public String description;
	
	public ProductBuilder setType(String type) {
		this.type = type;
		return this;
	}
	public ProductBuilder setName(String name) {
		this.name = name;
		return this;
	}
	public ProductBuilder setDescription(String description) {
		this.description = description;
		return this;
	}
	
	public Product build() {
		return new Product(this);
	}
}
