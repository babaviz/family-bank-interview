package simple.rest.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SimpleRestServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleRestServerApplication.class, args);
    }

}
