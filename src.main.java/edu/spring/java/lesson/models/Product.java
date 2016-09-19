package edu.spring.java.lesson.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product extends Model {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Field Title should not be null")
	@Column(name = "title")
	private String title;

	@NotNull(message = "Field Price should not be null")
	@Column(name = "price")
	private Integer price;

	@NotNull(message = "Field Count should be null")
	@Column(name = "count")
	private double count;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_category_id", referencedColumnName = "id")
	private ProductCategory productCategory;

	@OneToMany(mappedBy = "product")
	private Set<Order> orders = new HashSet<Order>();

	public Product() {
		super();
	}

	public Product(Long id) {
		super(id);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return super.getId() + " " + this.getTitle() + " " + this.getCount() + " " + this.getPrice() + " "
				+ productCategory.getTitle();

	}

}
