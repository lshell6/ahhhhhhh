package com.rewards.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rewards.backend.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	@Query("select t from Transaction t")
	List<Transaction> findAll();
	@Query("select t from Transaction t where t.id=?1")
	Optional<Transaction> findById(Long id);

	Transaction save(Transaction existingTransaction);

}
