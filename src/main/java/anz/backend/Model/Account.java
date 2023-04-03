package anz.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
