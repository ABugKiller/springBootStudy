package com.ad;


import com.ad.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationTests {


	@Test
	public void test() throws Exception {
		String a = String.format("%s_%s_%s", "1", "a", null);
		String[] split = a.split("_");
		System.out.println("a");
	}

}
