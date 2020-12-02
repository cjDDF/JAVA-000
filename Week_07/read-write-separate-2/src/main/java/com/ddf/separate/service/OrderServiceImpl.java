package com.ddf.separate.service;

import com.ddf.separate.dao.OrderDao;
import com.ddf.separate.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao dao;

    @Override
    public OrderEntity getById(Long id) {
        return dao.selectById(40);
    }

    @Transactional
    @Override
    public int updateById(Long id) {
        OrderEntity orderEntity = dao.selectById(40);
        System.out.println("修改前：" + orderEntity);

        //修改
        OrderEntity orderNew = new OrderEntity();
        orderNew.setId(id);
        orderNew.setMemberId(orderEntity.getMemberId() + 1);
        int i = dao.updateById(orderNew);

        orderEntity = dao.selectById(40);
        System.out.println("修改后：" + orderEntity);

        return i;
    }

}