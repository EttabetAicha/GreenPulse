package com.example.carbonpersonne.service;
import com.example.carbonpersonne.model.UserEntry;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final Map<String, UserEntry> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public void createUser(String id, String name, int age) {
        UserEntry user = new UserEntry(id, name, age);
        users.put(id, user);
    }

    public UserEntry getUser(String id) {
        return users.get(id);
    }

    public void updateUser(String id, String name, int age) {
        UserEntry user = users.get(id);
        if (user != null) {
            user.setName(name);
            user.setAge(age);
        }
    }

    public void deleteUser(String id) {
        users.remove(id);
    }
}
