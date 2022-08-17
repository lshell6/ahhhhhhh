package com.rewards.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.backend.model.Transaction;
import com.rewards.backend.repository.TransactionRepository;

@RestController
public class TransactionController {

@Autowired
private TransactionRepository transactionRepository;


@PostMapping("/transaction")
public void postTransaction(@RequestBody Transaction transaction) {
transactionRepository.save(transaction);

}


@GetMapping("/transaction")
public List<Transaction> getAllTransactions() {
List<Transaction> list = transactionRepository.findAll();
return list;

}


@GetMapping("/transaction/single/{id}")
public Transaction getSingleTransactionById(@PathVariable("id") Long id) {
Optional<Transaction> optional = transactionRepository.findById(id);
if(optional.isPresent()) {
return optional.get();
} else {
throw new RuntimeException("ID is invalid");
}

}
}