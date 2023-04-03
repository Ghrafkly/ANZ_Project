package anz.backend.Controller;

import anz.backend.DTO.TransactionDTO;
import anz.backend.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	private final TransactionService transactionService;

	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	/**
	 * Get all transactions for a given account number
	 * @param accountNumber
	 * @return List of transactions for the given account number
	 */
	@GetMapping
	public List<TransactionDTO> getTransactions(@RequestParam Long accountNumber) {
		return transactionService.getTransactionsByAccountNumber(accountNumber);
	}

	/**
	 * Get all transactions
	 * @return List of transactions
	 */
	@GetMapping("/all")
	public List<TransactionDTO> getAllTransactions() {
		return transactionService.getAllTransactions();
	}
}
