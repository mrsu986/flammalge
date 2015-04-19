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


public class MemoryNotFood {
	int td = 0;

	MemoryNotFood(){

	}

	MemoryNotFood(String cutey,long tweetid, String userid){

   		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

		int i=0;//このiはここにないとダメ
		String Dedede[] = new String[1000];

		int judgefood = 0;
		int ng = 0;

		cutey = cutey.substring(11,cutey.length());

		if(cutey.endsWith("。")){
			cutey = cutey.substring(0,cutey.length()-1);

		}

		if(cutey.endsWith("～")){
			cutey = cutey.substring(0,cutey.length()-1);

		}


		if(cutey.endsWith("よ")){
			cutey = cutey.substring(0,cutey.length()-1);

		}

		if(cutey.endsWith("ぞ")){
			cutey = cutey.substring(0,cutey.length()-1);

		}

		if(cutey.endsWith("だ")){
			cutey = cutey.substring(0,cutey.length()-1);

		}


		if(cutey.endsWith("なあ")){
			cutey = cutey.substring(0,cutey.length()-2);

		}

		if(cutey.endsWith("だぞ")){
			cutey = cutey.substring(0,cutey.length()-2);

		}

		if(cutey.endsWith("やで")){
			cutey = cutey.substring(0,cutey.length()-2);
		}


		if(cutey.endsWith("だよ")){
			cutey = cutey.substring(0,cutey.length()-2);

		}

		if(cutey.endsWith("です")){
			cutey = cutey.substring(0,cutey.length()-2);

		}


		if(cutey.endsWith("は食べ物")){
			cutey = cutey.substring(0,cutey.length()-4)+"";
			judgefood = 1;

		}

		if(cutey.endsWith("は飯")){
			cutey = cutey.substring(0,cutey.length()-2)+"";
			judgefood = 1;

		}

		if(cutey.endsWith("は料理")){
			cutey = cutey.substring(0,cutey.length()-3)+"";
			judgefood = 1;

		}

		if(cutey.endsWith("はご飯")){
			cutey = cutey.substring(0,cutey.length()-3)+"";
			judgefood = 1;

		}


		if(judgefood==1){

			cutey = cutey.substring(0,cutey.length());

			try{
			       File file = new File("data/" + "NotMesi" + ".txt");
			       BufferedReader br = new BufferedReader(new FileReader(file));

			       String str= null;
			       i=0;
			       while((str = br.readLine()) != null){
			           Dedede[i] = str;
			           if(cutey.equals(str)){
			        	   ng = 1;
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

			if(ng==1){

			try{
				twitter.updateStatus(new StatusUpdate("@"+userid+" "+cutey + "は食べ物じゃないから").inReplyToStatusId(tweetid));
				System.out.println("！ツイートしたよ："+cutey + "は食べ物じゃない");
				td = 1;

			}catch(TwitterException e){
				System.err.println("ツイート失敗"+e.getMessage());
			}

			}

		}

	}



}
