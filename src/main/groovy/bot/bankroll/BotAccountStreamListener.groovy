package bot.bankroll

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import twitter4j.DirectMessage
import twitter4j.StallWarning
import twitter4j.Status
import twitter4j.StatusDeletionNotice
import twitter4j.Twitter
import twitter4j.User
import twitter4j.UserList
import twitter4j.UserStreamListener

@Slf4j
@Component
class BotAccountStreamListener implements UserStreamListener {

    @Value('${twitter4j.appId}')
    private Long appId

    private Twitter twitter

    void setTwitter(Twitter twitter) {
        this.twitter = twitter
    }

    /**
     * Called when @BankrollBot is notified of a direct message interaction.
     *
     * @param directMessage {@link DirectMessage}
     */
    @Override
    void onDirectMessage(DirectMessage directMessage) {
        if (directMessage.senderId != appId) {
            log.info "Direct message received\n${Util.toJson(directMessage)}"
        }
    }

    /**
     * Called when an account follows @BankrollBot
     *
     * @param source User account that followed us
     * @param followedUser Us
     */
    @Override
    void onFollow(User source, User followedUser) {
        if (source.id != appId) {
            log.info "Follow notification received from @${source.screenName}, returning the favor."
            twitter.createFriendship(source.id)
            twitter.sendDirectMessage(source.id, 'Thanks for following @BankrollBot !\nMore to come.')
        }
    }

    // No-ops

    @Override
    void onUnfollow(User source, User unfollowedUser) { }

    @Override
    void onDeletionNotice(long directMessageId, long userId) {
        log.info 'onDeletionNotice'
    }

    @Override
    void onFriendList(long[] friendIds) {
        log.info 'onFriendList'
    }

    @Override
    void onFavorite(User source, User target, Status favoritedStatus) {
        log.info 'onFavorite'
    }

    @Override
    void onUnfavorite(User source, User target, Status unfavoritedStatus) {
        log.info 'onUnfavorite'
    }

    @Override
    void onUserListMemberAddition(User addedMember, User listOwner, UserList list) {
        log.info 'onUserListMemberAddition'
    }

    @Override
    void onUserListMemberDeletion(User deletedMember, User listOwner, UserList list) {
        log.info 'onUserListMemberDeletion'
    }

    @Override
    void onUserListSubscription(User subscriber, User listOwner, UserList list) {
        log.info 'onUserListSubscription'
    }

    @Override
    void onUserListUnsubscription(User subscriber, User listOwner, UserList list) {
        log.info 'onUserListUnsubscription'
    }

    @Override
    void onUserListCreation(User listOwner, UserList list) {
        log.info 'onUserListCreation'
    }

    @Override
    void onUserListUpdate(User listOwner, UserList list) {
        log.info 'onDeletionNotice'
    }

    @Override
    void onUserListDeletion(User listOwner, UserList list) {
        log.info 'onUserListDeletion'
    }

    @Override
    void onUserProfileUpdate(User updatedUser) {
        log.info 'onUserProfileUpdate'
    }

    @Override
    void onUserSuspension(long suspendedUser) {
        log.info 'onUserSuspension'
    }

    @Override
    void onUserDeletion(long deletedUser) {
        log.info 'onUserDeletion'
    }

    @Override
    void onBlock(User source, User blockedUser) {
        log.info 'onBlock'
    }

    @Override
    void onUnblock(User source, User unblockedUser) {
        log.info 'onUnblock'
    }

    @Override
    void onRetweetedRetweet(User source, User target, Status retweetedStatus) {
        log.info 'onRetweetedRetweet'
    }

    @Override
    void onFavoritedRetweet(User source, User target, Status favoritedRetweeet) {
        log.info 'onFavoritedRetweet'
    }

    @Override
    void onQuotedTweet(User source, User target, Status quotingTweet) {
        log.info 'onQuotedTweet'
    }

    @Override
    void onStatus(Status status) {
        log.info 'onStatus'
    }

    @Override
    void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
        log.info 'onDeletionNotice'
    }

    @Override
    void onTrackLimitationNotice(int numberOfLimitedStatuses) {
        log.info 'onTrackLimitationNotice'
    }

    @Override
    void onScrubGeo(long userId, long upToStatusId) {
        log.info 'onScrubGeo'
    }

    @Override
    void onStallWarning(StallWarning warning) {
        log.info 'onStallWarning'
    }

    @Override
    void onException(Exception ex) {
        log.error 'onException caught exception', ex
    }
}
