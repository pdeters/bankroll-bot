package bot.bankroll

import groovy.util.logging.Log4j
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Log4j
@Component
class TwitterDaemon {

    @Scheduled(fixedDelay = 1000L, initialDelay = 1000L)
    static void loop() {
        log.info "Doing it, and doing it, and doing it now ..."
    }
}
