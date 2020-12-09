package com.ddf.sub;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ddf.sub.dao.OrderDao;
import com.ddf.sub.entity.OrderEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HorizontalSubApplicationTests {
    @Autowired
    OrderDao dao;

    @Test
    void contextLoads() {

    }

    @Test
    void testInsert() {
        for (int i = 0; i < 100; i++) {
            dao.insert(new OrderEntity());
        }
    }

    @Test
    OrderEntity testSelect() {
        List<OrderEntity> list = dao.selectList(new QueryWrapper<OrderEntity>().ge("id", 1).last(" limit 1 "));
        System.out.println("---->" + list.size());
        OrderEntity orderEntity = list.get(0);
        System.out.println("---->" + orderEntity);
        return orderEntity;
    }

    @Test
    void testUpdate() {
        OrderEntity orderEntity = testSelect();
        orderEntity.setMemberId(orderEntity.getMemberId() == null ? 1 : orderEntity.getMemberId() + 1);
        dao.updateById(orderEntity);
        OrderEntity orderEntity1 = dao.selectById(orderEntity.getId());
        System.out.println("---->" + orderEntity1);
    }

    @Test
    void delete() {
        long id = testSelect().getId();
        dao.deleteById(id);
        OrderEntity orderEntity = dao.selectById(id);
        System.out.println("---->" + orderEntity);
    }

}
