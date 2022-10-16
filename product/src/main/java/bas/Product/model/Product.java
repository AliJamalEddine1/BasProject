package bas.Product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;




@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Product")
 public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idP")
	private  Integer id;
	private  int clientId;
	private  String type;
	private  int quantity;
	private  double price;
	private  String location;
	private  String image;
	private  String description;
	private  String yearOf;
	private String forSearch;
	public String getForSearch() {
		return forSearch;
	}
	public void setForSearch(String forSearch) {
		this.forSearch = forSearch;
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