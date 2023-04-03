package anz.backend.DTO;

import java.time.LocalDate;

public record TransactionDTO(
		Long transactionId,
		Long accountNumber,
		String accountName,
		LocalDate transactionValueDate,
		String accountCurrency,
		Double transactionDebitAmount,
		Double transactionCreditAmount,
		String transactionDebitCredit,
		String transactionNarrative
) {
}
