package com.ddf.sub.service;

import com.ddf.sub.dao.OrderDao;
import com.ddf.sub.entity.OrderEntity;
import io.shardingsphere.transaction.annotation.ShardingTransactionType;
import io.shardingsphere.transaction.api.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao dao;

    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    @Override
    public void insertWithTxXA() {
        for (int i = 0; i < 100; i++) {
            dao.insert(new OrderEntity());
            if (i == 60) {
                int a = 1 / 0;
            }
        }
    }
}