package com.staxoverflow.demo.repository;

import com.staxoverflow.demo.domain.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccRepo extends CrudRepository <BankAccount, Long> {
}
