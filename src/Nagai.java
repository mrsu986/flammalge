import java.util.Random;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class Nagai {

	int td = 0;

	Nagai(){

	}

	Nagai(long id,String user){

   		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

		Random rnd = new Random();
		int uuu = rnd.nextInt(3);


			try{
				if(uuu==0){
					twitter.updateStatus(new StatusUpdate("@"+user+" 長い").inReplyToStatusId(id));
				}
				if(uuu==1){
					twitter.updateStatus(new StatusUpdate("@"+user+" うるさい").inReplyToStatusId(id));
				}
				if(uuu==2){
					twitter.updateStatus(new StatusUpdate("@"+user+" 静かにしましょう").inReplyToStatusId(id));
				}

				System.out.println("返信：長い");
				td = 1;
			} catch(TwitterException e){
				System.err.println("ツイート失敗"+e.getMessage());
			}

		}





}
