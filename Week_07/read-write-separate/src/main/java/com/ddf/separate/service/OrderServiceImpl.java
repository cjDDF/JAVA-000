package com.ddf.separate.service;

import com.ddf.separate.anno.CurDataSource;
import com.ddf.separate.dao.OrderDao;
import com.ddf.separate.datasource.DataSourceNames;
import com.ddf.separate.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("orderService")
public class OrderServiceImpl  implements OrderService {

    @Autowired
    OrderDao dao;

    @CurDataSource(name = DataSourceNames.SLAVE)
    @Override
    public OrderEntity getById(Long id) {
        return dao.selectById(40);
    }

    @CurDataSource(name = DataSourceNames.MASTER)
    @Override
    public int updateById(Long id) {
        OrderEntity orderEntity = dao.selectById(40);

        OrderEntity orderNew = new OrderEntity();
        orderNew.setId(id);
        orderNew.setMemberId(orderEntity.getMemberId() + 1);
        return dao.updateById(orderNew);
    }

}