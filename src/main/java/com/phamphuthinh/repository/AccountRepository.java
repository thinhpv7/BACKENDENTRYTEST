package com.phamphuthinh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.phamphuthinh.entity.Account;

public interface AccountRepository extends PagingAndSortingRepository<Account, String>{

}
