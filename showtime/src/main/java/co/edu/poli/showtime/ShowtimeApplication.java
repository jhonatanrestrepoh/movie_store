package co.edu.poli.showtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "co.edu.poli")
public class ShowtimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowtimeApplication.class, args);
	}

}
