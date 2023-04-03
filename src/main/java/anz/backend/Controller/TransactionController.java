package anz.backend.Controller;

import anz.backend.DTO.TransactionDTO;
import anz.backend.Services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	private final TransactionServices transactionServices;

	@Autowired
	public TransactionController(TransactionServices transactionServices) {
		this.transactionServices = transactionServices;
	}

	/**
	 * Get all transactions for a given account number
	 * @param accountNumber
	 * @return List of transactions for the given account number
	 */
	@GetMapping
	public List<TransactionDTO> getTransactionsByAccountNumber(@RequestParam Long accountNumber) {
		return transactionServices.getTransactionsByAccountNumber(accountNumber);
	}

	/**
	 * Get all transactions
	 * @return List of transactions
	 */
	@GetMapping("/all")
	public List<TransactionDTO> getAllTransactions() {
		return transactionServices.getTransactions();
	}
}
