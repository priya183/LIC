package com.app.lic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.lic.dto.TransactionDto;
import com.app.lic.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

public Transaction findByTransactionId(int transactionId);
public Iterable<Transaction> findAll();

@Query(
		  value = "SELECT * FROM Transaction t WHERE t.app_user_id_app_user_id = ?1 and  t.pan_id_plan_id=?2", 
		  nativeQuery = true)
public List<Transaction> findByAppUserIdAndPanId(Long appUserId,Long planId);

/*@Query(value = "SELECT count(amountPaid) FROM Transaction t where t.app_user_id_app_user_id = ?1 and  t.pan_id_plan_id=?2", nativeQuery = true)
public Long count(Long appUserId,Long planId);*/

}
