package com.shop.footwear.admin;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.shop.footwear.user.Role;
import com.shop.footwear.user.User;
import com.shop.footwear.user.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class PasswordEncoderTest {


	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void testPasswordEncode() {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User user5 = new User("Dang@html.net", "Đăng", " Lê Hải", true);
		Role role5 = new Role(5);
		user5.addRole(role5);
		String rawPassword = "abc123";
		user5.setPassword(passwordEncoder.encode(rawPassword));

		userRepo.save(user5);

		assertThat(passwordEncoder.matches(rawPassword, user5.getPassword()));
	}

}
