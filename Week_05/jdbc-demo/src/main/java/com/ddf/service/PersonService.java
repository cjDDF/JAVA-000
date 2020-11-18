package com.ddf.service;

import com.ddf.dao.PersonDao;
import com.ddf.model.Person;
import com.ddf.util.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PersonService {
    private PersonDao dao = new PersonDao();

    public Person getById(int id) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        return dao.getById(connection, id);
    }

    public void update(Person person){
        Connection connection = JdbcUtils.getConnection();
        try {
            connection.setAutoCommit(false);
            dao.update(connection, person);
            connection.commit();
        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }

    }

    public List<Person> list() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        return dao.list(connection);
    }

    public void add(Person person) {
        Connection connection = JdbcUtils.getConnection();
        try {
            connection.setAutoCommit(false);
            dao.add(connection, person);
            connection.commit();
        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }
    }
}
