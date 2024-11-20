package com.hlag.shippingmanagement.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import com.hlag.shippingmanagement.entity.User;
import com.hlag.shippingmanagement.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository{

	private static UserRepositoryImpl userRepositoryImpl;

    private List<User> userList = new ArrayList<>();

    private UserRepositoryImpl() {

    }

    public static UserRepositoryImpl getInstance() {
        if (userRepositoryImpl == null) {
            userRepositoryImpl = new UserRepositoryImpl();
        }
        return userRepositoryImpl;
    }

    @Override
    public void add(User user) {
        if (user == null || user.getUserName() == null) {
            throw new IllegalArgumentException("User or UserName cannot be null");
        }
        userList.add(user);
        System.out.println("User added successfully.");
    }

    @Override
    public User get(String userName) {
        if (userName == null) {
            throw new IllegalArgumentException("UserName cannot be null");
        }

        return userList.stream()
                .filter(user -> user.getUserName().equals(userName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public void update(String userName, User updatedUser) {
        User existingUser = get(userName);
        if (existingUser != null) {
            int index = userList.indexOf(existingUser);
            userList.set(index, updatedUser);
            System.out.println("User updated successfully.");
        } else {
            System.out.println("User with Username " + userName + " not found.");
        }
    }

    @Override
    public void delete(String userName) {
        User existingUser = get(userName);
        if (existingUser != null) {
            userList.remove(existingUser);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User with Username " + userName + " not found.");
        }
    }

    @Override
    public List<User> getAllUsers() {
        System.out.println("Getting all users");
        return userList;
    }
}

