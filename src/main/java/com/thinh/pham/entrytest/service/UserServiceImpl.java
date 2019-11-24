package com.thinh.pham.entrytest.service;

import com.thinh.pham.entrytest.dao.UserRepository;
import com.thinh.pham.entrytest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String userName) {
        Optional<User> result = userRepository.findById(userName);

        User user = null;

        if (result.isPresent()) {
            user = result.get();
        } else {
            throw new RuntimeException("Did not find user have user name = " + userName);
        }

        return user;
    }

    @Override
    public void save(User user) {
        user.setPassword("{bcrypt}"+passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteById(String userName) {
        userRepository.deleteById(userName);
    }

    @Override
    public boolean existsById(String userName) {
        return userRepository.existsById(userName);
    }
}
