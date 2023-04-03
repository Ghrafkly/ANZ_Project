package anz.backend.Controller;

import anz.backend.DTO.AccountDTO;
import anz.backend.Services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	private final AccountServices accountServices;

	@Autowired
	public AccountController(AccountServices accountServices) {
		this.accountServices = accountServices;
	}

	/**
	 * Get all accounts
	 * @return List of accounts
	 */
	@GetMapping
	public List<AccountDTO> getAccounts() {
		return accountServices.getAccounts();
	}
}
