package com.shop.footwear.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepoy;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<User> getUsers() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	public void registerUser(User user) {
		encodePassword(user);
		userRepo.save(user);
	}
	
	public void encodePassword(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	}

	public List<Role> getRoles(){
		return roleRepoy.findAll();
	}
}
