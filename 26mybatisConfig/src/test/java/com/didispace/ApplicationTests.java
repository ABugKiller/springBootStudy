package com.didispace;

import com.didispace.domain.User;
import com.didispace.domain.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional
public class ApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	@Rollback
	public void findByName() throws Exception {
//		userMapper.insert("AAA", 20);
//		User u = userMapper.findByName("AAA");
//		Assert.assertEquals(20, u.getAge().intValue());

		//使用map传参
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "CCC");
		map.put("age", 40);
		userMapper.insertByMap(map);
		User u2 = userMapper.findByName("CCC");
		System.out.println("a");

		//使用实体传参
		User user = new User();
		user.setAge(10);
		user.setName("ddd");
		userMapper.insertByUser(user);
		User u3 = userMapper.findByName("ddd");
		System.out.println(u3);

		List<User> userList = userMapper.findAll();
		System.out.println(userList.size());
	}

}