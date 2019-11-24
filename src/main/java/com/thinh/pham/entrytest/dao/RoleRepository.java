package com.thinh.pham.entrytest.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thinh.pham.entrytest.entity.Role;
import com.thinh.pham.entrytest.entity.RoleName;
 

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}