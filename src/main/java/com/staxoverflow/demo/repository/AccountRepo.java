package com.staxoverflow.demo.repository;

import com.staxoverflow.demo.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends CrudRepository<Account, Long> {
}
