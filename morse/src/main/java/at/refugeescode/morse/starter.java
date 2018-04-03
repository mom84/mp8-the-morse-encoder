package at.refugeescode.morse;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class starter {

    @Bean
    ApplicationRunner applicationRunner(){
        return args -> {


        };
    }
}
