package com.shop.footwear.admin;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shop.footwear.user.Role;
import com.shop.footwear.user.User;
import com.shop.footwear.user.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepo;
	
	

	@Test
	public void testSaveUsers() {
		
		User user1 = new User("khai@codejava.net", "Khải", "Nguyễn Đức", true);
		Role role1 = new Role(1);
		user1.addRole(role1);
		User user2 = new User("khang@codePython.net", "Khang", "Vĩ Hà", true );
		Role role2 = new Role(2);
		user2.addRole(role2);
		User user3 = new User("Thinh@codeC#.net", "Thịnh", "Nguyễn Đức", true );
		Role role3 = new Role(3);
		user3.addRole(role3);
		User user4 = new User("Kiet@codeC.net", "Kiệt", " Lê Nguyễn", true );
		Role role4 = new Role(4);
		user4.addRole(role4);
		List<User> users = userRepo.saveAll(List.of(user1,user2,user3,user4));
		assertThat(users).isNotNull();
		
	}
	
	
}
