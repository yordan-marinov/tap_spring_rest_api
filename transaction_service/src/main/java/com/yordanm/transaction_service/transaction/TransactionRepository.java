package com.yordanm.transaction_service.transaction;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;


public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    List<Transaction> findAllByUserId(String userId);
}
