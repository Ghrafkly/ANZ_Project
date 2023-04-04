package anz.backend.Integration;

import anz.backend.Model.Transaction;
import anz.backend.Repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionIntegrationTests {
	private final MockMvc mockMvc;
	@MockBean
	private TransactionRepository mockTR;

	@Autowired
	public TransactionIntegrationTests(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}

	@Test
	void testGetAllTransactionFromCallingTransactionsAll() throws Exception {
		List<Transaction> transactionList = List.of(
				new Transaction(
						1L,
						"SGSavings726",
						LocalDate.now(),
						"SGD",
						0.00,
						1000.00,
						"Credit",
						"Salary")
		);

		when(mockTR.findAll()).thenReturn(transactionList);

		mockMvc.perform(get("/transactions/all"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$[0].accountNumber").value(1L))
				.andExpect(jsonPath("$[0].transactionCreditAmount").value(1000.00))
				.andDo(print());
	}

	@Test
	void testGetAllTransactionFromCallingTransactionsByAccountNumber() throws Exception {
		List<Transaction> transactionList = List.of(
				new Transaction(
						1L,
						"SGSavings726",
						LocalDate.now(),
						"SGD",
						0.00,
						1000.00,
						"Credit",
						"Salary")
		);

		when(mockTR.getTransactionsByAccountNumber(1L)).thenReturn(transactionList);

		mockMvc.perform(get("/transactions?accountNumber=1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$[0].accountNumber").value(1L))
				.andExpect(jsonPath("$[0].transactionCreditAmount").value(1000.00))
				.andDo(print());
	}

}
