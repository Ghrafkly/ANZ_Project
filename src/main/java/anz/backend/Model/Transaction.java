package anz.backend.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

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
	private String accountCurrency;
	private Double transactionDebitAmount;
	private Double transactionCreditAmount;
	private String transactionDebitCredit;
	private String transactionNarrative;

	public Transaction() {
	}

	public Transaction(Long accountNumber, String accountName, LocalDate transactionValueDate, String accountCurrency, Double transactionDebitAmount, Double transactionCreditAmount, String transactionDebitCredit, String transactionNarrative) {
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.transactionValueDate = transactionValueDate;
		this.accountCurrency = accountCurrency;
		this.transactionDebitAmount = transactionDebitAmount;
		this.transactionCreditAmount = transactionCreditAmount;
		this.transactionDebitCredit = transactionDebitCredit;
		this.transactionNarrative = transactionNarrative;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public LocalDate getTransactionValueDate() {
		return transactionValueDate;
	}

	public void setTransactionValueDate(LocalDate transactionValueDate) {
		this.transactionValueDate = transactionValueDate;
	}

	public String getAccountCurrency() {
		return accountCurrency;
	}

	public void setAccountCurrency(String accountCurrency) {
		this.accountCurrency = accountCurrency;
	}

	public Double getTransactionDebitAmount() {
		return transactionDebitAmount;
	}

	public void setTransactionDebitAmount(Double transactionDebitAmount) {
		this.transactionDebitAmount = transactionDebitAmount;
	}

	public Double getTransactionCreditAmount() {
		return transactionCreditAmount;
	}

	public void setTransactionCreditAmount(Double transactionCreditAmount) {
		this.transactionCreditAmount = transactionCreditAmount;
	}

	public String getTransactionDebitCredit() {
		return transactionDebitCredit;
	}

	public void setTransactionDebitCredit(String transactionDebitCredit) {
		this.transactionDebitCredit = transactionDebitCredit;
	}

	public String getTransactionNarrative() {
		return transactionNarrative;
	}

	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}
}
