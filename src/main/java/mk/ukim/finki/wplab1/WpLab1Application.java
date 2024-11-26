package mk.ukim.finki.wplab1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class WpLab1Application {

	public static void main(String[] args) {
		SpringApplication.run(WpLab1Application.class, args);
	}

}
