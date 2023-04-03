package anz.backend.Services;

import anz.backend.DTO.TransactionDTO;
import anz.backend.Exceptions.ApiRequestException;
import anz.backend.Mapper.TransactionMapper;
import anz.backend.Repository.TransactionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TransactionServices {
	private final TransactionRepository transactionRepository;

	public List<TransactionDTO> getTransactionsByAccountNumber(Long accountNumber) {
		log.info("Getting all transactions for account number: " + accountNumber);
		List<TransactionDTO> transactionDTO = transactionRepository.getTransactionsByAccountNumber(accountNumber)
				.stream()
				.map(TransactionMapper.INSTANCE::transactionToTransactionDTO)
				.toList();

		if (transactionDTO.isEmpty()) {
			String errorMessage = "No transactions found for account number: " + accountNumber;
			log.error(errorMessage);
			throw new ApiRequestException(errorMessage);
		}

		return transactionDTO;
	}

	public List<TransactionDTO> getAllTransactions() {
		log.info("Getting all transactions");
		return transactionRepository.findAll()
				.stream()
				.map(TransactionMapper.INSTANCE::transactionToTransactionDTO)
				.toList();
	}
}
