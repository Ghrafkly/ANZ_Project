package anz.backend.Integration;

import anz.backend.Model.Account;
import anz.backend.Repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerIntegrationTests {
	private final MockMvc mockMvc;
	@MockBean
	private AccountRepository mockAR;

	@Autowired
	public AccountControllerIntegrationTests(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}

	@Test
	void testGetAllAccountFromCallingAccounts() throws Exception {
		List<Account> accountList = List.of(
				new Account(
						1L,
						"Test Account 1",
						"SGSavings726",
						LocalDate.now(),
						"SGD",
						1000.00)
		);

		when(mockAR.findAll()).thenReturn(accountList);

		mockMvc.perform(get("/accounts"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$[0].accountName").value("Test Account 1"))
				.andDo(print());
	}
}
