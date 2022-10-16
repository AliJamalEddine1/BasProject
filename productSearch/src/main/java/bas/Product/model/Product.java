package bas.Product.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


 public class Product {
	private  int id;
	private  int clientId;
	private  String type;
	private  int quantity;
	private  double price;
	private  String location;
	private  String image;
	private  String description;
	private  String yearOf;
	public Product(int i, int client, String desc, String img, String loc, double p, int qty, String t, String year) {
		id=i;
		clientId=client;
		description=desc;
		image=img;
		location=loc;
		price=p;
		quantity=qty;
		type=t;
		yearOf=year;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientID) {
		this.clientId = clientID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getYearOf() {
		return yearOf;
	}
	public void setYearOf(String yearOf) {
		this.yearOf = yearOf;
	}

}