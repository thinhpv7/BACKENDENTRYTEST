package com.phamphuthinh.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.phamphuthinh.entity.UserAccount;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, String>{

}
