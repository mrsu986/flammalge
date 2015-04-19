import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class TotsuMesi {
	int td = 0;


	TotsuMesi(){

	}

	TotsuMesi(long tweetid){

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

		int i=0;//このiはここにないとダメ
		String Dedede[] = new String[1000];

		Random lun = new Random();
		Random lun2 = new Random();
		Random lun3 = new Random();


			try{
			       File file = new File("data/" + "food" + ".txt");
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

			int eclip = lun.nextInt(i);
			int eclip2 = lun2.nextInt(i);
			int eclip3 = lun3.nextInt(i);


		try{
			twitter.updateStatus(Dedede[eclip]+"と"+Dedede[eclip2]+"を混ぜると"+Dedede[eclip3]+"が出来ます");
			System.out.println("気まぐれ料理");
			td = 1;
		} catch(TwitterException e){
			System.err.println("ツイート失敗"+e.getMessage());
		}









	}


}
