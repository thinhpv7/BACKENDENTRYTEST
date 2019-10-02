package com.phamphuthinh.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.phamphuthinh.entity.Question;

public interface QuestionRepository extends PagingAndSortingRepository<Question, String>{

}

