package com.hlag.shippingmanagement.repository;

import java.util.List;

import com.hlag.shippingmanagement.entity.User;

public interface UserRepository {

	void add(User user);

    User get(String userName);

    void update(String userName, User updatedUser);

    void delete(String userName);

    List<User> getAllUsers();
}
