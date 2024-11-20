package com.hlag.shippingmanagement.service;

import java.util.List;

import com.hlag.shippingmanagement.entity.User;

public interface UserService {
	
	void add(User user);

    User get(String userName);

    void update(String userName, User updatedUser);

    void delete(String userName);

    List<User> getAllUsers();
}
