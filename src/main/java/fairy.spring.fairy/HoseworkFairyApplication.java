package fairy.spring.fairy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableJpaAuditing
@EnableScheduling
@SpringBootApplication
public class HoseworkFairyApplication {


   public static void main(String[] args) {

        SpringApplication.run(HoseworkFairyApplication.class, args);
    }

}
