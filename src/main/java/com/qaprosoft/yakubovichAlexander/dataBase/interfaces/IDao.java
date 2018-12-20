package com.qaprosoft.yakubovichAlexander.dataBase.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface IDao<T> {

	public void insert(T entity) throws SQLException, IOException, InterruptedException;

	public T getById(long id) throws SQLException, ParseException, IOException, InterruptedException;

	public void update(T entity) throws SQLException, IOException, InterruptedException;

	public void delete(T entity) throws SQLException, IOException, InterruptedException;

	public List<T> getAll() throws SQLException, ParseException, IOException, InterruptedException;

}
