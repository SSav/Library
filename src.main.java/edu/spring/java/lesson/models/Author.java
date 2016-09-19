package edu.spring.java.lesson.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author extends Model {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@OneToMany(mappedBy = "author")
	private Set<Book> books = new HashSet<Book>();

	public Author() {
		super();
	}

	public Author(long id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return super.getId() + " ...... " + this.getName() + ".............";
	}

}
