package anz.backend.Services;

import anz.backend.DTO.AccountDTO;
import anz.backend.Mapper.AccountMapper;
import anz.backend.Repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AccountServices {
	private final AccountRepository accountRepository;

	public List<AccountDTO> getAllAccounts() {
		log.info("Getting all accounts");
		return accountRepository.findAll()
				.stream()
				.map(AccountMapper.INSTANCE::accountToAccountDTO)
				.toList();
	}
}
