package com.example.mytdd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MyTddApplicationTests {

	@Test
	void substring() {
		String str = "abcde";
		assertEquals("cd",str.substring(2,4));
	}

}
