import java.util.Random;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class DeadLock {
	int td = 0;


	DeadLock(){

	}

	DeadLock(String moto, String userid,long tweetid){

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

		Random lune = new Random();
		int kind = lune.nextInt(7);
		String mes = "";

		switch(kind){

		case 0:mes = "呼んだ？( ◠‿◠ )";
		break;
		case 1:mes = "バレないとでも思った？";
		break;
		case 2:mes = "ﾊｧｰｲ♡";
		break;
		case 3:mes = "チャオ";
		break;
		case 4:mes = "遊ぼ♪";
		break;
		case 5:mes = "ん？";
		break;
		case 6:mes = "ふらまです";
		break;
		case 7:mes = "どうも";
		break;


		}



		try{
			twitter.updateStatus(new StatusUpdate("@"+userid+" " +mes).inReplyToStatusId(tweetid));
			System.out.println("返信したよ:呼んだ？（エゴサブレイク）");
			td = 1;
		} catch(TwitterException e){
			System.err.println("ツイート失敗"+e.getMessage());
		}









	}


}
