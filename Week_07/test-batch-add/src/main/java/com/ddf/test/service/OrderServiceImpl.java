package com.ddf.test.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddf.test.dao.OrderDao;
import com.ddf.test.entity.OrderEntity;
import org.springframework.stereotype.Service;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

}