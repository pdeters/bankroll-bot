package bot.bankroll

import groovy.util.logging.Log4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import twitter4j.TwitterFactory
import twitter4j.TwitterStream
import twitter4j.TwitterStreamFactory
import twitter4j.auth.AccessToken
import twitter4j.conf.ConfigurationBuilder

import javax.annotation.PostConstruct

@Log4j
@Service
class TwitterDaemon {

    @Value('${twitter4j.oauth.consumer-key}')
    private String consumerKey

    @Value('${twitter4j.oauth.consumer-secret}')
    private String consumerSecret

    @Value('${twitter4j.oauth.access-token}')
    private String accessToken

    @Value('${twitter4j.oauth.access-token-secret}')
    private String accessTokenSecret

    @Autowired
    private BotAccountStreamListener streamListener

    @PostConstruct
    private void init() {
        ConfigurationBuilder cb = new ConfigurationBuilder()
        cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret)

        TwitterStreamFactory twitterStreamFactory = new TwitterStreamFactory(cb.build())
        TwitterStream twitterStream = twitterStreamFactory.getInstance(new AccessToken(accessToken, accessTokenSecret))

        // Give the StreamListener an authenticated Twitter API client (there has to be a better way)
        streamListener.setTwitter(new TwitterFactory().getInstance(twitterStream.getAuthorization()))

        twitterStream.addListener(streamListener)
        twitterStream.user()

        log.info 'Twitter daemon initialized.'
    }
}
