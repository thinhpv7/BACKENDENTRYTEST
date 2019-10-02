package com.phamphuthinh.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.phamphuthinh.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, String>{

}
