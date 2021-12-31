package com.yordanm.transaction_service.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/api/resources/users/{userId}/transactions")
    public List<Transaction> getAll(@PathVariable String userId){
        return transactionService.getAllTransactions(userId);
    }

    @PostMapping("/api/resources/transactions")
    public void makeTransaction(@RequestBody Transaction transaction){
        transactionService.createTransaction(transaction);
    }

    @PutMapping("/api/resources/users/{userId}/transactions/{id}")
    public void updateTransaction(@RequestBody Transaction transaction, @PathVariable Long id){
        transactionService.update(transaction, id);
    }

    @DeleteMapping("/api/resources/users/{userId}/transactions/{id}")
    public void deleteTransaction(@PathVariable Long id){
        transactionService.delete(id);
    }

}
