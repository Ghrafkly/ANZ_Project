package anz.backend.Repository;

import anz.backend.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	@Query("select t from Transaction t where t.accountNumber = :accountNumber")
	List<Transaction> getTransactionsByAccountNumber(@Param(value="accountNumber") Long accountNumber);
}
