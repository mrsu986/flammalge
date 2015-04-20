import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class Montana {

	int td = 1;

	Montana(){

	}

	Montana(String y,long id,String u){

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));


		String y2[] = new String[10000];
		int jk;
		String y3;

		try{
			File file = new File("data/"+ "base" +".txt");
			BufferedReader cr = new BufferedReader(new FileReader(file));

			String str= null;
			int i=0;
			while((str = cr.readLine()) != null){
				y2[i] = str;
				i = i +1;
			}
			cr.close();

		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}//ok

		try{//ok
			File file = new File("C:/Users/Yune/exry/tesbot/data/recent.txt");
			BufferedReader dr = new BufferedReader(new FileReader(file));

			String zabo= null;
			jk=0;
			zabo = dr.readLine();
			jk = Integer.parseInt(zabo);
			y3 = y2[jk];

			dr.close();

			try{//ok
				twitter.updateStatus(new StatusUpdate("@"+u+" "+y3).inReplyToStatusId(id));
				System.out.println("元ネタツイートしたよ");
				td = 1;
			} catch(TwitterException e){
				System.err.println("ツイート失敗"+e.getMessage());
			}//ok

		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}


	}



}
