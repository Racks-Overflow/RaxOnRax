package com.staxoverflow.demo.repository;

import com.staxoverflow.demo.domain.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccRepo extends CrudRepository <BankAccount, Long> {
}
