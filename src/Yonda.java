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

public class Yonda {

	int td = 0;


	Yonda(){

	}

	Yonda(String moto, String userid,long tweetid){

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

    	Random lune = new Random();
		int kind = lune.nextInt(8);
		int sun = lune.nextInt(500);
		int i=0;//このiはここにないとダメ
		String Dedede[] = new String[1000];

		String mes = "";

		try{
		       File file = new File("C:/Users/Yune/exry/Kawaii/data/tantan.txt");
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
		int solar = lune.nextInt(i);


		switch(kind){

		case 0:mes = "呼んだ？";
			break;
		case 1:mes = "おいすー";
			break;
		case 2:mes = "ﾊｧｰｲ";
			break;
		case 3:mes = "ハロー";
		break;
		case 4:mes = "ふらまです";
		break;
		case 5:mes = "わっ";
		break;
		case 6:
		case 7:mes = Dedede[solar];
		break;

		}

		if(moto.indexOf("さん")==-1 && sun < 5 ){
			mes = "さんをつけろよデコスケ野郎";

		}

		try{
			twitter.updateStatus(new StatusUpdate("@"+userid+" " +mes).inReplyToStatusId(tweetid));
			System.out.println("返信したよ:呼んだ？");
			td = 1;
		} catch(TwitterException e){
			System.err.println("ツイート失敗"+e.getMessage());
		}







	}


}
