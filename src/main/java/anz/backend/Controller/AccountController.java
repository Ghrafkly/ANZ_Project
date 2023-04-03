package anz.backend.Controller;

import anz.backend.DTO.AccountDTO;
import anz.backend.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	private final AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * Get all accounts
	 * @return List of accounts
	 */
	@GetMapping
	public List<AccountDTO> getAccounts() {
		return accountService.getAllAccounts();
	}
}
