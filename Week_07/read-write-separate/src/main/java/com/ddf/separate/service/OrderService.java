package com.ddf.separate.service;


import com.ddf.separate.entity.OrderEntity;

/**
 * 订单
 *
 * @author ddf
 * @email tataluoke@gmail.com
 * @date 2020-05-27 10:49:05
 */
public interface OrderService{

    OrderEntity getById(Long id);

    int updateById(Long id);
}

