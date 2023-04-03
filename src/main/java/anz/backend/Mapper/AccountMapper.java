package anz.backend.Mapper;

import anz.backend.DTO.AccountDTO;
import anz.backend.Model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {
	AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

	AccountDTO accountToAccountDTO(Account account);
}
