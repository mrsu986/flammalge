import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class GoodM {
	int td = 0;


	GoodM(){

	}

	GoodM(String userid,long tweetid){

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

		try{
			twitter.updateStatus(new StatusUpdate("@"+userid+" おはよう！").inReplyToStatusId(tweetid));
			System.out.println("返信したよ:おはよう");
			td = 1;
		} catch(TwitterException e){
			System.err.println("ツイート失敗"+e.getMessage());
		}









	}


}
