package bot.bankroll

import groovy.util.logging.Log4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling

@Log4j
@EnableScheduling
@SpringBootApplication
class BankrollBotApplication {

    public static void main(String... args) throws Exception {
        SpringApplication.run(BankrollBotApplication.class, args);
    }
}
