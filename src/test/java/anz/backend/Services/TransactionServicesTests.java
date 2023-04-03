package anz.backend.Services;

import anz.backend.DTO.TransactionDTO;
import anz.backend.Repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TransactionServicesTests {
	private TransactionServices transactionServices;
	@Mock
	private TransactionServices transactionServicesMock;
	@Mock
	private TransactionRepository transactionRepository;
	@Mock
	private List<TransactionDTO> transactions;

	@BeforeEach
	void setUp() {
		transactionServices = new TransactionServices(transactionRepository);
	}

	@Test
	void getAllTransactions() {
		transactionServices.getAllTransactions();
		verify(transactionRepository).findAll();
	}

	@Test
	void getTransactionsByAccountNumber() {
		when(transactionServicesMock
				.getTransactionsByAccountNumber(10000L))
				.thenReturn(transactions);
		assertEquals(transactions, transactionServicesMock.getTransactionsByAccountNumber(10000L));
		verify(transactionServicesMock).getTransactionsByAccountNumber(10000L);
	}
}
