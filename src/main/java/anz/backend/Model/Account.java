package anz.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table
public class Account {
	@Id
	private Long accountNumber;
	private String accountName;
	private String accountType;
	private LocalDate accountBalanceDate;
	private String accountCurrency;
	private Double accountOAB;

	public Account() {

	}

	public Account(Long accountNumber, String accountName, String accountType, LocalDate accountBalanceDate, String accountCurrency, Double accountOAB) {
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.accountType = accountType;
		this.accountBalanceDate = accountBalanceDate;
		this.accountCurrency = accountCurrency;
		this.accountOAB = accountOAB;
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public LocalDate getAccountBalanceDate() {
		return accountBalanceDate;
	}

	public void setAccountBalanceDate(LocalDate accountBalanceDate) {
		this.accountBalanceDate = accountBalanceDate;
	}

	public String getAccountCurrency() {
		return accountCurrency;
	}

	public void setAccountCurrency(String accountCurrency) {
		this.accountCurrency = accountCurrency;
	}

	public Double getAccountOAB() {
		return accountOAB;
	}

	public void setAccountOAB(Double accountOAB) {
		this.accountOAB = accountOAB;
	}

	@Override
	public String toString() {
		return "Account{" +
				"accountNumber=" + accountNumber +
				", accountName='" + accountName + '\'' +
				", accountType='" + accountType + '\'' +
				", accountBalanceDate='" + accountBalanceDate + '\'' +
				", accountCurrency='" + accountCurrency + '\'' +
				", accountOAB=" + accountOAB +
				'}';
	}
}
