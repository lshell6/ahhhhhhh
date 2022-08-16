package com.rewards.backend.repository;

import java.util.List;
import java.util.Optional;

import com.rewards.backend.model.Transaction;

public interface TransactionRepository {

	List<Transaction> findAll();

	Optional<Transaction> findById(Long id);

	void deleteById(Long id);

	Transaction save(Transaction existingTransaction);

}
