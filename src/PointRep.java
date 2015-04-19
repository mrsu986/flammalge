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


public class PointRep {

	int td = 0;


	PointRep(){

	}

	PointRep(String y35,long tweetid, String userid){

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

		int i;//このiはここにないとダメ
		int j;
		int judge = -1;
		String Dedede[] = new String[1000];
		String message="";

		StringBuilder y51 = new StringBuilder(y35);//これがないとunnu.deleteができない
		String x = String.valueOf(y51.delete(0,11));
		y35 = x;


		try{
		       File file = new File("data/" + "prgive" + ".txt");
		       BufferedReader br = new BufferedReader(new FileReader(file));

		       String str= null;
		       i=0;
		       while((str = br.readLine()) != null){
		           Dedede[i] = str;
		           if(y35.equals(Dedede[i])){
		        	   judge=i;
		        	   break;
		           }
		           i = i +1;
		       }

		       br.close();

		  }catch(FileNotFoundException e){
		        System.out.println(e);
		  }catch(IOException e){
		        System.out.println(e);
		  }
		if (judge == -1){
			return;
		}

		try{
		       File file = new File("data/" + "prtake" + ".txt");
		       BufferedReader fr = new BufferedReader(new FileReader(file));

		       String str= null;
		       j=0;
		       while((str = fr.readLine()) != null){
		           Dedede[j] = str;
		           if(j==judge){
		        	   message = Dedede[j];
		        	   break;
		           }
		           j = j +1;
		       }

		       fr.close();

		  }catch(FileNotFoundException e){
		        System.out.println(e);
		  }catch(IOException e){
		        System.out.println(e);
		  }


		try{
			twitter.updateStatus(new StatusUpdate("@"+userid+" "+message).inReplyToStatusId(tweetid));
			System.out.println("返信したよ:PointReply");
			td = 1;
		} catch(TwitterException e){
			System.err.println("ツイート失敗"+e.getMessage());
		}


	}


}
