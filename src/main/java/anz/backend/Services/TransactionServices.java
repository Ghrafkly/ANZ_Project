package anz.backend.Services;

import anz.backend.DTO.TransactionDTO;
import anz.backend.Mapper.TransactionMapper;
import anz.backend.Model.Transaction;
import anz.backend.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServices {
	private final TransactionRepository transactionRepository;

	@Autowired
	public TransactionServices(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	public List<TransactionDTO> getTransactionsByAccountNumber(Long accountNumber) {
		return transactionRepository.getTransactionsByAccountNumber(accountNumber)
				.stream()
				.map(TransactionMapper.INSTANCE::transactionToTransactionDTO)
				.toList();
	}

	public List<TransactionDTO> getTransactions() {
		return transactionRepository.findAll()
				.stream()
				.map(TransactionMapper.INSTANCE::transactionToTransactionDTO)
				.toList();
	}
}
