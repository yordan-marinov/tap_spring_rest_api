package com.yordanm.transaction_service.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resource/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    List<Transaction> getAll(){
        return transactionService.getAllTransactions();
    }

    @PostMapping
    Transaction makeTransaction(@RequestBody Transaction transaction){
        return transactionService.createTransaction(transaction);
    }

}
