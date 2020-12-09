package com.ddf.sub.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddf.sub.dao.OrderDao;
import com.ddf.sub.entity.OrderEntity;
import org.springframework.stereotype.Service;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

}