package edu.spring.java.lesson.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.spring.java.lesson.resources.LogConfig;
import edu.spring.java.lesson.resources.R;

@Entity
@Table(name = "user")
public class User extends Model implements UserDetails {

	private static final long serialVersionUID = 1L;

	private static String LOG_PROPRTIES_FILE = R.Log.LOG_PROPERTIES_FILE;
	private static Logger logger = Logger.getLogger(User.class);

	@Size(min = 4, message = "{username.size.error}")
	@Column(name = "username")
	private String username;

	@Size(min = 4, max = 10, message = "{password.size.error}")
	@Column(name = "password")
	private String password;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<UserRole> userRoles = new HashSet<>();

	public User() {
		super();
	}

	public User(long id) {
		super(id);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<SimpleGrantedAuthority> result = new ArrayList<>();
		for (UserRole usedRole : userRoles) {
			result.add(new SimpleGrantedAuthority(usedRole.getListRole().name()));
		}
		new LogConfig(LOG_PROPRTIES_FILE);
		logger.warn(".............USER is " + result + "..................");

		return result;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
