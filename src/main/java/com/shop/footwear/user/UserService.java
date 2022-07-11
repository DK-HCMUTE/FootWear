package com.shop.footwear.user;

import java.util.List;

public interface UserService {

	List<User> getUsers();

	void registerUser(User user);

	 List<Role> getRoles();
}
