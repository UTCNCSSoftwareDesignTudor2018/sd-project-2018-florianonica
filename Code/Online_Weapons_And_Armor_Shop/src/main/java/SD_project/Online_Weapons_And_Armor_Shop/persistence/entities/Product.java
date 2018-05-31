package SD_project.Online_Weapons_And_Armor_Shop.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import SD_project.Online_Weapons_And_Armor_Shop.persistence.entities.builder.ProductBuilder;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "stock")
	private int stock;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "name")
	private String name;
	
	@Lob
	@Column(name = "description")
	private String description;

	public Product() {}
	
	public Product(ProductBuilder builder) {
		this.name = builder.name;
		this.description = builder.description;
		this.type = builder.type;
		if(builder.type.equals("armor")) {
			this.price = 10000;
		}
		else {
			this.price = 2500;
		}
		this.stock = 1;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
