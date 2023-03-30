package anz.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Data
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
}
