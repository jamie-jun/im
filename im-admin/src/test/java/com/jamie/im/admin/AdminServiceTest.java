package com.jamie.im.admin;

import com.jamie.im.admin.controller.AdministratorController;
import com.jamie.im.common.dto.UserDto;
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
public class AdminServiceTest {

	@Autowired
	private AdministratorController userService;

	@Test
	public void testConnection(){
		UserDto admin = userService.loadUserByUsername("admin");
		System.out.println(admin.toString());
	}

}
