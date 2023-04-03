package anz.backend.Repository;

import anz.backend.Model.Account;
import anz.backend.Model.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@SpringBootTest
@DataJpaTest
public class TransactionRepositoryTests {
	@Autowired
	private TransactionRepository transactionRepository;

	@AfterEach
	void tearDown() {
		transactionRepository.deleteAll();
	}

	@Test
	public void loadTransactionByAccountNumber() {
		Long accountNumber = 10000L;

		Transaction transaction = new Transaction(
				accountNumber,
				"SGD",
				LocalDate.of(2020, 10, 20),
				"AUD",
				null,
				1000.00,
				"Credit",
				""
		);

		transactionRepository.save(transaction);

		boolean expected = !transactionRepository.getTransactionsByAccountNumber(accountNumber).isEmpty();

		assertTrue(expected);
	}

	@Test
	public void loadTransactionByAccountNumberThatDoesNotExist() {
		Long accountNumber = 10000L;

		Transaction transaction = new Transaction(
				accountNumber,
				"SGD",
				LocalDate.of(2020, 10, 20),
				"AUD",
				null,
				1000.00,
				"Credit",
				""
		);

		transactionRepository.save(transaction);

		boolean expected = !transactionRepository.getTransactionsByAccountNumber(99999L).isEmpty();

		assertFalse(expected);
	}
}
