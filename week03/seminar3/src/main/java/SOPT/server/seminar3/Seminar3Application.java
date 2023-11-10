package SOPT.server.seminar3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing // 여기에 뭔가 많아지면 안좋다 >> 떼고 패키지만든다
public class Seminar3Application {

	public static void main(String[] args) {
		SpringApplication.run(Seminar3Application.class, args);
	}

}
