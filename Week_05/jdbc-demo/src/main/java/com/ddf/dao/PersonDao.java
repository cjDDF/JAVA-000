package com.ddf.dao;

import com.ddf.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    //增加
    public void add(Connection conn, Person person) throws SQLException {
        //获取连接

        //sql
        String sql = "INSERT INTO person(name, age) values(?,?)";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql);

        //传参
        ptmt.setString(1, person.getName());
        ptmt.setInt(2, person.getAge());

        //执行
        ptmt.execute();
    }

    public void update(Connection conn, Person person) throws SQLException {
        //获取连接

        //sql
        String sql = "UPDATE person set name=?, age=? where id=?";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql);

        //传参
        ptmt.setString(1, person.getName());
        ptmt.setInt(2, person.getAge());
        ptmt.setInt(3, person.getId());

        //执行
        ptmt.execute();
    }

    public void deleteById(Connection conn, int id) throws SQLException {
        //获取连接

        //sql
        String sql = "delete from person where id=?";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt = conn.prepareStatement(sql);

        //传参
        ptmt.setInt(1, id);

        //执行
        ptmt.execute();
    }

    public List<Person> list(Connection conn) throws SQLException {

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name, age FROM person");

        List list = new ArrayList<Person>();
        Person person = null;
        while (rs.next()) {
            person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setAge(rs.getInt("age"));

            list.add(person);
        }
        return list;
    }

    public Person getById(Connection conn, int id) throws SQLException {
        Person person = null;
        //获取连接

        //sql
        String sql = "select * from  person where id=?";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //传参
        ptmt.setInt(1, id);
        //执行
        ResultSet rs = ptmt.executeQuery();
        if (rs.next()) {
            person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setAge(rs.getInt("age"));
        }
        return person;
    }
}