package edu.spring.java.lesson.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "parent_product_category")
public class ParentProductCategory extends Model {

	private static final long serialVersionUID = 1L;

	@Column(name = "title")
	private String title;

	@OneToMany(mappedBy = "parentProductCategory")
	Set<ProductCategory> productCategries = new HashSet<ProductCategory>();

	public ParentProductCategory() {
		super();
	}

	public ParentProductCategory(Long id) {
		super(id);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<ProductCategory> getProductCategries() {
		return productCategries;
	}

	public void setProductCategries(Set<ProductCategory> productCategries) {
		this.productCategries = productCategries;
	}

}
