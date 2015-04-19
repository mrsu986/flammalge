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


public class TotsuHaco {

	int td = 0;


	TotsuHaco(){

	}

	TotsuHaco(long tweetid){

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

		int i=0;//このiはここにないとダメ
		String Dedede[] = new String[1000];
		String Dedede2[] = new String[1000];

		Random lun = new Random();

			try{
			       File file = new File("data/" + "Haco1" + ".txt");
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

			try{
			       File file = new File("data/" + "Haco2" + ".txt");
			       BufferedReader br = new BufferedReader(new FileReader(file));

			       String str= null;
			       i=0;
			       while((str = br.readLine()) != null){
			           Dedede2[i] = str;
			           i = i +1;
			       }

			       br.close();

			  }catch(FileNotFoundException e){
			        System.out.println(e);
			  }catch(IOException e){
			        System.out.println(e);
			  }


		int solar = lun.nextInt(i);

		try{
			twitter.updateStatus(Dedede[eclip]+"は"+Dedede2[solar]);
			System.out.println("気まぐれ生成");
			td = 1;
		} catch(TwitterException e){
			System.err.println("ツイート失敗"+e.getMessage());
		}









	}


}
