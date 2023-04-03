package anz.backend.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table
public class Transaction {
	@Id
	@SequenceGenerator(
			name = "transaction_id_seq",
			sequenceName = "transaction_id_seq",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "transaction_id_seq"
	)
	private Long transactionId;
	private Long accountNumber;
	private String accountName;
	private LocalDate transactionValueDate;
	private String transactionAccountCurrency;
	private Double transactionDebitAmount;
	private Double transactionCreditAmount;
	private String transactionDebitCredit;
	private String transactionNarrative;

	public Transaction(Long accountNumber, String accountName, LocalDate transactionValueDate, String transactionAccountCurrency, Double transactionDebitAmount, Double transactionCreditAmount, String transactionDebitCredit, String transactionNarrative) {
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.transactionValueDate = transactionValueDate;
		this.transactionAccountCurrency = transactionAccountCurrency;
		this.transactionDebitAmount = transactionDebitAmount;
		this.transactionCreditAmount = transactionCreditAmount;
		this.transactionDebitCredit = transactionDebitCredit;
		this.transactionNarrative = transactionNarrative;
	}
}
