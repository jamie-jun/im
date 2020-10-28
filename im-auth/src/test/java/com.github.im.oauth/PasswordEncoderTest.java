package com.github.im.oauth;

import com.jamie.im.auth.AuthApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthApplication.class)
public class PasswordEncoderTest {

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void testPasswordEncoder(){
        System.out.println(passwordEncoder.encode("secret"));
    }

}
