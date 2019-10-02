package com.phamphuthinh.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.phamphuthinh.entity.Topic;

public interface TopicRepository extends PagingAndSortingRepository<Topic, String>{

}
