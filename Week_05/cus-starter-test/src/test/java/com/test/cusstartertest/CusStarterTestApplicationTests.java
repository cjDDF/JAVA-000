package com.test.cusstartertest;

import com.ddf.config.School;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CusStarterTestApplicationTests {

	@Autowired
	School school;

	@Test
	void contextLoads() {
		System.out.println(school);
	}

}
