package anz.backend.Unit.Controller;

import anz.backend.Controller.TransactionController;
import anz.backend.Services.TransactionServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {
	TransactionController transactionController;
	@Mock
	TransactionServices transactionServices;

	@BeforeEach
	void setUp() {
		transactionController = new TransactionController(transactionServices);
	}

	@Test
	void returnAllTransactions() {
		assertEquals(List.of(), transactionController.getAllTransactions());
		verify(transactionServices).getAllTransactions();
	}

	@Test
	void returnTransactionsByAccountNumber() {
		assertEquals(List.of(), transactionController.getTransactionsByAccountNumber(123456L));
		verify(transactionServices).getTransactionsByAccountNumber(123456L);
	}
}
