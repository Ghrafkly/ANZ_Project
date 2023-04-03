package anz.backend.Services;

import anz.backend.DTO.AccountDTO;
import anz.backend.Mapper.AccountMapper;
import anz.backend.Model.Account;
import anz.backend.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServices {
	private final AccountRepository accountRepository;

	@Autowired
	public AccountServices(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public List<AccountDTO> getAccounts() {
		return accountRepository.findAll()
				.stream()
				.map(AccountMapper.INSTANCE::accountToAccountDTO)
				.toList();
	}
}
