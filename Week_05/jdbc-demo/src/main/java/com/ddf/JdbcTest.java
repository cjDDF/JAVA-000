package com.ddf;

import com.ddf.model.Person;
import com.ddf.service.PersonService;

import java.sql.SQLException;
import java.util.List;

public class JdbcTest {
    private static PersonService service = new PersonService();

    public static void main(String[] args) throws SQLException {
        System.out.println("查看id为6的数据:");
        testGetById(6);
        testAdd();
        System.out.println("查看新增后的所有数据:");
        testList();
        testUpdate();
    }

    private static void testUpdate() throws SQLException {
        Person person = service.getById(6);
        person.setName(person.getName() + 1);
        person.setAge(person.getAge()+1);
        service.update(person);
        System.out.println("查看修改后的数据：");
        testGetById(person.getId());
    }

    private static void testList() throws SQLException {
        List<Person> list = service.list();
        System.out.println(list);
    }

    private static void testAdd() {
        Person person = new Person("张三", 12);
        service.add(person);
    }

    private static void testGetById(int id) throws SQLException {
        Person byId = service.getById(id);
        System.out.println(byId);
    }
}
