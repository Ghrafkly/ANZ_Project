package anz.backend.Services;

import anz.backend.Model.Transaction;
import anz.backend.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServices {
	private final TransactionRepository transactionRepository;

	@Autowired
	public TransactionServices(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	public List<Transaction> getTransactionsByAccountNumber(Long accountNumber) {
		return transactionRepository.getTransactionsByAccountNumber(accountNumber);
	}

	public List<Transaction> getTransactions() {
		return transactionRepository.findAll();
	}
}
