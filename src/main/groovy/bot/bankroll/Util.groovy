package bot.bankroll

import groovy.json.JsonBuilder
import twitter4j.DirectMessage

class Util {
    static String toJson(DirectMessage directMessage) {
        return new JsonBuilder(directMessage).toPrettyString()
    }
}
