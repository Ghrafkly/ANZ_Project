package anz.backend.Services;

import anz.backend.Model.Account;
import anz.backend.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServices {
	private final AccountRepository accountRepository;

	@Autowired
	public AccountServices(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public List<Account> getAccounts() {
		return accountRepository.findAll();
	}
}
