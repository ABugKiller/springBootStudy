package com.ad.springBoot;

import com.ad.springBoot.properties.BlogProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private BlogProperties blogProperties;

	@Test
	public void contextLoads() {
		System.out.println(blogProperties.getName());
		System.out.println(blogProperties.getTitle());
		System.out.println(blogProperties.getDesc());
	}

}
