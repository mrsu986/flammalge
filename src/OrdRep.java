import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class OrdRep {

	int td = 0;


	OrdRep(){

	}

	OrdRep(String y31,String userid, long tweetid){

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

		int i=0;//このiはここにないとダメ
		String Dedede[] = new String[1000];

		Random lun = new Random();
		int mode = lun.nextInt(100);

		if(mode<87){

			try{
				File file = new File("data/" + "rewords" + ".txt");
				BufferedReader br = new BufferedReader(new FileReader(file));

				String str= null;
				i=0;
				while((str = br.readLine()) != null){
					Dedede[i] = str;
					i = i +1;
				}

				br.close();

			}catch(FileNotFoundException e){
				System.out.println(e);
			}catch(IOException e){
				System.out.println(e);
			}

		}else{

			try{
				File file = new File("data/" + "yatagarasu" + ".txt");
				BufferedReader br = new BufferedReader(new FileReader(file));

				String str= null;
				i=0;
				while((str = br.readLine()) != null){
					Dedede[i] = str;
					i = i +1;
				}

				br.close();

			}catch(FileNotFoundException e){
				System.out.println(e);
			}catch(IOException e){
				System.out.println(e);
			}


		}

		int solar = lun.nextInt(i);

		try{
			twitter.updateStatus(new StatusUpdate("@"+userid+" "+Dedede[solar]).inReplyToStatusId(tweetid));
			System.out.println("返信したよ");
			td = 1;
		} catch(TwitterException e){
			System.err.println("ツイート失敗"+e.getMessage());
		}




	}


}
