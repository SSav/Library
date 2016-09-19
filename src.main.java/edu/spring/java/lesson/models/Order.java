package edu.spring.java.lesson.models;

import java.sql.Time;
import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order extends Model {

	private static final long serialVersionUID = 1L;

	@Column(name = "number")
	private Long number;

	@Column(name = "date")
	private GregorianCalendar calendar;

	@Column(name = "time")
	private Time time;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
	private User user;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id")
	private Product product;

	public Order() {
		super();
	}

	public Order(Long id) {
		super(id);
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public GregorianCalendar getCalendar() {
		return calendar;
	}

	public void setCalendar(GregorianCalendar calendar) {
		this.calendar = calendar;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
