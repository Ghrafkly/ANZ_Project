package anz.backend.Services;

import anz.backend.Repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AccountServicesTests {
	private AccountServices accountServices;
	@Mock
	private AccountRepository accountRepository;

	@BeforeEach
	void setUp() {
		accountServices = new AccountServices(accountRepository);
	}

	@Test
	void getAllAccounts() {
		accountServices.getAllAccounts();
		verify(accountRepository).findAll();
	}
}
