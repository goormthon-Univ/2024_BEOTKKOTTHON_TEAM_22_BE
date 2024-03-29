package fairy.spring.fairy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
@EnableJpaAuditing
public class HoseworkFairyApplication {


   public static void main(String[] args) {

        SpringApplication.run(HoseworkFairyApplication.class, args);
    }

}
