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
import com.shop.footwear.user.RoleRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class RoleRepositoryTest {

	@Autowired
	RoleRepository roleRepo;
	
	@Test
	public void testSaveRoles() {
		Role roleAdmin = new Role("Admin", "Manage Shop");
		Role roleCustomer = new Role("Customer","Buy stuffs");
		Role roleShipper = new Role("Shipper","Deliver foods");
		Role roleAssistant = new Role("Assistant","Help Admin");
		Role roleSaleperson = new Role("Saleperson","Sales stuffs");
		Role roleEditor = new Role("Editor","Edit page");
		List<Role> roles = roleRepo.saveAll(List.of(roleAdmin, roleCustomer,roleEditor,roleAssistant,
				roleSaleperson,roleShipper));
		assertThat(roles).isNotNull();
	}

}
