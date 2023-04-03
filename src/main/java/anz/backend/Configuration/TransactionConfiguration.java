package anz.backend.Configuration;

import anz.backend.Model.Transaction;
import anz.backend.Repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class TransactionConfiguration {
	@Bean
	CommandLineRunner transactionCommandLineRunner(TransactionRepository repository) {
		return args -> {
			Transaction tr1 = new Transaction(123456L, "SGD", LocalDate.of(2020, 10, 20), "AUD", null, 1000.00, "Credit", "");
			Transaction tr2 = new Transaction(123456L, "SGD", LocalDate.of(2020, 10, 20), "AUD", null, 1000.00, "Credit", "");
			Transaction tr3 = new Transaction(123456L, "SGD", LocalDate.of(2020, 10, 20), "AUD", null, 1000.00, "Credit", "");
			Transaction tr4 = new Transaction(123457L, "SGD", LocalDate.of(2020, 10, 20), "AUD", null, 1000.00, "Credit", "");
			Transaction tr5 = new Transaction(123458L, "SGD", LocalDate.of(2020, 10, 20), "AUD", null, 1000.00, "Credit", "");
			Transaction tr6 = new Transaction(123459L, null, null, null, null, null, null, null);

			repository.saveAll(List.of(tr1, tr2, tr3, tr4, tr5, tr6));
		};
	}
}
