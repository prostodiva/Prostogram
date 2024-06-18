package javagram.javagram.web;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class JavagramApplication {


	public static void main(String[] args) {
		SpringApplication.run(JavagramApplication.class, args);

	}
	
}

