package anz.backend.DTO;

import java.time.LocalDate;

public record AccountDTO(
		Long accountNumber,
		String accountName,
		String accountType,
		LocalDate accountBalanceDate,
		String accountCurrency,
		Double accountOAB
) {
}
