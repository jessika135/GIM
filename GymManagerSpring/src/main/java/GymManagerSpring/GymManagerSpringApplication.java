package GymManagerSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "GymManagerSpring")
public class GymManagerSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymManagerSpringApplication.class, args);
	}

}