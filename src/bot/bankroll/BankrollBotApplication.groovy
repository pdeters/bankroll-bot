package bot.bankroll

import groovy.util.logging.Log4j
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@Log4j
@SpringBootApplication
class BankrollBotApplication implements CommandLineRunner {

    @Override
    public void run(String... args) {
        log.info 'Starting BankrollBootApplication ...'
        log.info 'Exiting BankrollBootApplication!'
    }

    public static void main(String... args) throws Exception {
        SpringApplication.run(BankrollBotApplication.class, args);
    }
}
