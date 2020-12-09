package com.ddf.sub.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ddf.sub.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author ddf
 * @email tataluoke@gmail.com
 * @date 2020-05-27 10:49:05
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {

}
