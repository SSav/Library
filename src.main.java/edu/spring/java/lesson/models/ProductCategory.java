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

@Entity
@Table(name = "product_category")
public class ProductCategory extends Model {

	private static final long serialVersionUID = 1L;

	@Column(name = "title")
	private String title;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_product_categoty_id", referencedColumnName = "id")
	private ParentProductCategory parentProductCategory;

	@OneToMany(mappedBy = "productCategory")
	private Set<Product> products = new HashSet<Product>();

	public ProductCategory() {
		super();
	}

	public ProductCategory(Long id) {
		super(id);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ParentProductCategory getParentProductCategory() {
		return parentProductCategory;
	}

	public void setParentProductCategory(ParentProductCategory parentProductCategory) {
		this.parentProductCategory = parentProductCategory;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
