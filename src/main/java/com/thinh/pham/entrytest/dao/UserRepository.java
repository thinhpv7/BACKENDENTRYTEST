package com.thinh.pham.entrytest.dao;

import com.thinh.pham.entrytest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
