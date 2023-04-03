package anz.backend.Mapper;

import anz.backend.DTO.TransactionDTO;
import anz.backend.Model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {
	TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

	TransactionDTO transactionToTransactionDTO(Transaction transaction);
}
