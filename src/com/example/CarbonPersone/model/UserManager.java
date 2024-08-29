package com.example.CarbonPersone.model;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private final Map<String, User> users;

    public UserManager() {
        this.users = new HashMap<>();
    }

    public void createUser(String id, String name, int age) {
        User user = new User(id, name, age);
        users.put(id, user);
    }

    public User getUser(String id) {
        return users.get(id);
    }

    public void updateUser(String id, String name, int age) {
        User user = users.get(id);
        if (user != null) {
            user.setName(name);
            user.setAge(age);
        }
    }

    public void deleteUser(String id) {
        users.remove(id);
    }
}
