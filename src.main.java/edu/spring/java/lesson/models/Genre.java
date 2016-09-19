package edu.spring.java.lesson.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre extends Model {

	private static final long serialVersionUID = 977386347298901881L;

	@Column(name = "title", unique = true, nullable = false)
	private String title;

	@OneToMany(mappedBy = "genre")
	private Set<Book> books = new HashSet<Book>();

	public Genre() {
		super();
	}

	public Genre(long id) {
		super(id);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return super.getId() + " ...... " + this.getTitle() + ".............";
	}

}
