import java.util.Random;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class Zako {

	int td = 0;

	Zako(){

	}

	Zako(String cutey, int cutemoji){

   		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken, Keys.accessTokenSecret));


		if(cutey.endsWith("はザコ") == true && cutey.length() > 3){

			cutey = cutey.substring(0,cutemoji-3);

			try{
				Random rnd = new Random();
				int uuu = rnd.nextInt(3);
				if(uuu==0){
					twitter.updateStatus(cutey + "はザコ");
				}
				if(uuu==1){
					twitter.updateStatus("ザコはあなた");
				}
				if(uuu==2){
					twitter.updateStatus("うるさいザコ");
				}

				System.out.println("ツイートしたよザコ");
				td = 1;
			} catch(TwitterException e){
				System.err.println("ツイート失敗"+e.getMessage());
			}

		}





}


}
