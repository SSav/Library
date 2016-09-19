package edu.spring.java.lesson.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "publisher")
public class Publisher extends Model {

	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "publisher")
	private Set<Book> books = new HashSet<Book>();

	public Publisher() {
		super();
	}

	public Publisher(long id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
