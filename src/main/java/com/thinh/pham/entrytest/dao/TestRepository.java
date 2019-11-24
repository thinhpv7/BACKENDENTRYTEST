package com.thinh.pham.entrytest.dao;

import com.thinh.pham.entrytest.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Integer> {

    List<Test> findByDeleted(boolean isDeleted);
}
