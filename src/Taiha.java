import java.util.Random;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class Taiha {
	int td = 0;


	Taiha(){

	}

	Taiha(String userid,long tweetid){

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));


		Random lun = new Random();
		int solar = lun.nextInt(9);
		String conn = "";

		switch(solar){

		case 0:conn = "轟沈？轟沈？";
		break;
		case 1:conn = "エロ提督だ";
		break;
		case 2:conn = "轟沈する前に解体";
		break;
		case 3:conn =  "2 4 11";
		break;
		case 4:conn = "たいはっはっはｗｗｗｗｗｗ";
		break;
		case 5:conn = "バケツもったいないし解体しよう";
		break;
		case 6:conn = "ドッグ占拠";
		break;
		case 7:conn = "轟沈";
		break;
		case 8:conn = "ふらま大破知ってる！ 轟沈よね";
		break;


		}




		try{
			twitter.updateStatus(new StatusUpdate("@"+userid+" " + conn).inReplyToStatusId(tweetid));
			System.out.println("返信したよ:おはよう");
			td = 1;
		} catch(TwitterException e){
			System.err.println("ツイート失敗"+e.getMessage());
		}









	}


}
