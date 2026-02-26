package com.mis.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class MisApplicationTest {

	@Autowired
	private ApplicationContext context;

	@Test
	void contextLoads() {
		assertNotNull(context);
	}

	@Test
	void main_IniciaAplicacion() {
		assertDoesNotThrow(() -> MisApplication.main(new String[] {}));
	}
}
