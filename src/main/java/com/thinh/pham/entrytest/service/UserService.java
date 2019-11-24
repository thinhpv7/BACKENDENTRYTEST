package com.thinh.pham.entrytest.service;

import com.thinh.pham.entrytest.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findById(String userName);

    public void save(User user);

    public void deleteById(String userName);

    public boolean existsById(String userName);
}
