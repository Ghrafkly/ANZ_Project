package anz.backend.Unit.Controller;

import anz.backend.Controller.AccountController;
import anz.backend.Services.AccountServices;
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
public class AccountControllerTests {
	AccountController accountController;
	@Mock
	AccountServices accountServices;

	@BeforeEach
	void setUp() {
		accountController = new AccountController(accountServices);
	}

	@Test
	void returnAllAccounts() {
		assertEquals(List.of(), accountController.getAccounts());
		verify(accountServices).getAllAccounts();
	}
}
