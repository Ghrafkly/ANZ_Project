package anz.backend.DTO.Mapper;

import anz.backend.DTO.TransactionDTO;
import anz.backend.Model.Transaction;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TransactionDTOMapper implements Function<Transaction, TransactionDTO> {
	@Override
	public TransactionDTO apply(Transaction transaction) {
		return new TransactionDTO(
				transaction.getTransactionId(),
				transaction.getAccountNumber(),
				transaction.getAccountName(),
				transaction.getTransactionValueDate(),
				transaction.getAccountCurrency(),
				transaction.getTransactionDebitAmount(),
				transaction.getTransactionCreditAmount(),
				transaction.getTransactionDebitCredit(),
				transaction.getTransactionNarrative()
		);
	}
}
