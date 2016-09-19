package edu.spring.java.lesson.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class UserRole extends Model {

	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@Column(name = "title", insertable = false, updatable = false)
	private ListRole listRole;

	@ManyToMany(mappedBy = "userRoles")
	private Set<User> user = new HashSet<>();

	public UserRole() {
		super();
	}

	public UserRole(long id) {
		super(id);
	}

	public ListRole getListRole() {
		return listRole;
	}

	public void setListRole(ListRole listRole) {
		this.listRole = listRole;
	}

	public Set<User> getUsers() {
		return user;
	}

	public void setUsers(Set<User> user) {
		this.user = user;
	}

}
