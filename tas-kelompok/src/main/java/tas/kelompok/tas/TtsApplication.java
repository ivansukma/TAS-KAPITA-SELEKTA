package tas.kelompok.tas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TtsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TtsApplication.class, args);
                System.out.println("Program is running");
	}
        
        @Bean //Inversion of Control
        public RestTemplate getRestTemplate(){
            return new RestTemplate();
        }

}
