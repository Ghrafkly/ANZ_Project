package anz.backend.DTO.Mapper;

import anz.backend.DTO.AccountDTO;
import anz.backend.Model.Account;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AccountDTOMapper implements Function<Account, AccountDTO> {
	@Override
	public AccountDTO apply(Account account) {
		return new AccountDTO(
				account.getAccountNumber(),
				account.getAccountName(),
				account.getAccountType(),
				account.getAccountBalanceDate(),
				account.getAccountCurrency(),
				account.getAccountOAB()
		);
	}
}
