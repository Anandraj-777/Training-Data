package com.hlag.shippingmanagement.serviceImpl;

import java.util.List;

import com.hlag.shippingmanagement.entity.User;
import com.hlag.shippingmanagement.repository.UserRepository;
import com.hlag.shippingmanagement.repositoryImpl.UserRepositoryImpl;
import com.hlag.shippingmanagement.service.UserService;

public class UserServiceImpl implements UserService{

	private UserRepository userRepository = UserRepositoryImpl.getInstance();
    private static UserServiceImpl userServiceImpl;

    public static UserServiceImpl getInstance() {
        if (userServiceImpl == null) {
            userServiceImpl = new UserServiceImpl();
        }
        return userServiceImpl;
    }

    private UserServiceImpl() {

    }

    @Override
    public void add(User user) {
        if (user != null) {
            userRepository.add(user);
            System.out.println("User added successfully.");
        } else {
            System.out.println("Cannot add null user.");
        }
    }

    @Override
    public User get(String userName) {
        User user = userRepository.get(userName);
        if (user == null) {
            System.out.println("User with Username " + userName + " not found.");
        }
        return user;
    }

    @Override
    public void update(String userName, User updatedUser) {
        User existingUser = get(userName);
        if (existingUser != null) {
            userRepository.update(userName, updatedUser);
            System.out.println("User updated successfully.");
        } else {
            System.out.println("User with Username " + userName + " not found, cannot update.");
        }
    }

    @Override
    public void delete(String userName) {
        User existingUser = get(userName);
        if (existingUser != null) {
            userRepository.delete(userName);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User with Username " + userName + " not found, cannot delete.");
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users found.");
        }
        return users;
    }
}
