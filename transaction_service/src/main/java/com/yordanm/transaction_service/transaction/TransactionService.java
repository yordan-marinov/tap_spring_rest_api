package com.yordanm.transaction_service.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions(String userId) {
        List<Transaction> transactions = new ArrayList<>();
        transactionRepository.findAllByUserId(userId).forEach(transactions::add);
        return transactions;
    }

    public void createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void update(Transaction transaction, Long id) {
        if (transactionRepository.existsById(id)){
            transactionRepository.save(transaction);
        }
    }

    public void delete(Long id) {
        transactionRepository.deleteById(id);
    }
}
