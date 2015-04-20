import java.util.Random;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class Omikuji {
	int td = 0;


	Omikuji(){

	}

	Omikuji(String y31,long tweetid,String userid){

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

		String kekka = "";

		Random lun = new Random();
		int solar = lun.nextInt(7);

		switch(solar){

		case(0):kekka = "はずれ";
		break;
		case(1):
		case(2):kekka = "凶";
		break;
		case(3):
		case(4):kekka = "吉";
		break;
		case(5):kekka = "中吉";
		break;
		case(6):kekka = "大吉";
		break;

		}


		try{
			twitter.updateStatus(new StatusUpdate("@"+userid+" "+kekka).inReplyToStatusId(tweetid));
			System.out.println("返信したよ:おみくじ" + solar);
			td = 1;
		} catch(TwitterException e){
			System.err.println("ツイート失敗"+e.getMessage());
		}






	}


}
