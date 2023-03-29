package anz.backend.Configuration;

import anz.backend.Model.Account;
import anz.backend.Repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class AccountConfiguration {
	@Bean
	CommandLineRunner accountCommandLineRunner(AccountRepository repository) {
		return args -> {
			Account ac1 = new Account(123456L, "Savings", "SGD", LocalDate.of(2020, 10, 20), "SGD", 1000.12);
			Account ac2 = new Account(123457L, "Savings", "SGD", LocalDate.of(2020, 10, 20), "SGD", 12345.67);
			Account ac3 = new Account(123458L, "Savings", "SGD", LocalDate.of(2020, 10, 20), "SGD", 987654.81);

			repository.saveAll(List.of(ac1, ac2, ac3));
		};
	}
}
