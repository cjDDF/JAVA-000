package com.ddf.separate;

import com.ddf.separate.entity.OrderEntity;
import com.ddf.separate.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReadWriteSeparateApplicationTests {

	@Autowired
	OrderService service;

	@Test
	void contextLoads() {
		OrderEntity orderEntity = service.getById(40L);
		System.out.println(orderEntity);
		service.updateById(40L);
		orderEntity = service.getById(40L);
		System.out.println(orderEntity);
	}

}
