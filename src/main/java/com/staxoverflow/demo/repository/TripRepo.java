package com.staxoverflow.demo.repository;

import com.staxoverflow.demo.domain.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepo extends CrudRepository <Trip, Long> {
}
