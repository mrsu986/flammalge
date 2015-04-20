import java.util.Random;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class LoliCon {
	int td = 0;

	LoliCon(){

	}

	LoliCon(String user, long id){

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));




		try{
			Random rnd = new Random();
			int uuu = rnd.nextInt(5);
			if(uuu==0){
				twitter.updateStatus(new StatusUpdate("@"+user+" "+"あなたは幼い少女しか好きになれないのですか？").inReplyToStatusId(id));
			}
			if(uuu==1){
				twitter.updateStatus("汚物は消毒だー！");
			}
			if(uuu==2){
				twitter.updateStatus("おまわりさんこっちです");
			}
			if(uuu==3){
				twitter.updateStatus("小さい子、好きになっちゃ、いけないんだよ？");
			}
			if(uuu==4){
				twitter.updateStatus("ロリコンだ・・・");
			}



			System.out.println("ツイートしたようじょ");
			td = 1;
		} catch(TwitterException e){
			System.err.println("ツイート失敗"+e.getMessage());
		}





	}


}
