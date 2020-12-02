package com.ddf.test;

import com.ddf.test.entity.OrderEntity;
import com.ddf.test.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class TestBatchAddApplicationTests {
	private final int n=100*10000;

	@Autowired
	OrderService service;

	@Test
	void contextLoads() {
		//造数据
		OrderEntity orderEntity = OrderEntity.builder().createTime(new Date())
				.confirmStatus(1)
				.growth(2)
				.orderSn("O21321412")
				.promotionAmount(new BigDecimal(300))
				.build();
		List<OrderEntity> list = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			list.add(orderEntity);
		}

		//批量保存
		service.saveBatch(list);
	}

}
