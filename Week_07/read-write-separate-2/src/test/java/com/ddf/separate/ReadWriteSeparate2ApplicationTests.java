package com.ddf.separate;

import com.ddf.separate.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReadWriteSeparate2ApplicationTests {

	@Autowired
	OrderService service;

	@Test
	void contextLoads() {
		service.updateById(40L);
	}

}
