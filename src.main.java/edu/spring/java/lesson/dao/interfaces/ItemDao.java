package edu.spring.java.lesson.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import edu.spring.java.lesson.models.Model;

public interface ItemDao<T extends Model> {

	public T getById(Long id) throws SQLException;

	public List<T> getAll() throws SQLException;

	public void add(T model) throws SQLException;

	public void update(T model) throws SQLException;

	public void removeById(Long id) throws SQLException;

	public void remove(T model) throws SQLException;
}
