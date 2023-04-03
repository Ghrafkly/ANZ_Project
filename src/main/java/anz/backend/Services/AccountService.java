package anz.backend.Services;

import anz.backend.DTO.AccountDTO;
import anz.backend.DTO.Mapper.AccountDTOMapper;
import anz.backend.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
	private final AccountRepository accountRepository;
	private final AccountDTOMapper accountDTOMapper;

	@Autowired
	public AccountService(AccountRepository accountRepository, AccountDTOMapper accountDTOMapper) {
		this.accountRepository = accountRepository;
		this.accountDTOMapper = accountDTOMapper;
	}

	public List<AccountDTO> getAllAccounts() {
		return accountRepository.findAll()
				.stream()
				.map(accountDTOMapper)
				.collect(Collectors.toList());
	}
}
