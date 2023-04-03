package anz.backend.Services;

import anz.backend.DTO.Mapper.TransactionDTOMapper;
import anz.backend.DTO.TransactionDTO;
import anz.backend.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
	private final TransactionRepository transactionRepository;
	private final TransactionDTOMapper transactionDTOMapper;

	@Autowired
	public TransactionService(TransactionRepository transactionRepository, TransactionDTOMapper transactionDTOMapper) {
		this.transactionRepository = transactionRepository;
		this.transactionDTOMapper = transactionDTOMapper;
	}

	public List<TransactionDTO> getTransactionsByAccountNumber(Long accountNumber) {
		return transactionRepository.getTransactionsByAccountNumber(accountNumber)
				.stream()
				.map(transactionDTOMapper)
				.collect(Collectors.toList());
	}

	public List<TransactionDTO> getAllTransactions() {
		return transactionRepository.findAll()
				.stream()
				.map(transactionDTOMapper)
				.collect(Collectors.toList());
	}
}
