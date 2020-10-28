package com.jamie.im.admin;

import com.jamie.im.admin.mapper.AdministratorMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImAdminApplication.class)
public class AdminRepositoryTest {

	@Autowired
	private AdministratorMapper userMapper;

	@Test
	public void testConnection(){
		userMapper.selectCount(null);
	}

}
