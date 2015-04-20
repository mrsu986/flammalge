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


public class MotherTalk1 {

	int td = 0;


	MotherTalk1(){

	}

	MotherTalk1(String y31,String userid, long tweetid){

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey,Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

		int i=0;//このiはここにないとダメ
		String Dedede[] = new String[1000];
		String conn = "";

		Random lun = new Random();
		Random lun2 = new Random();
		int inmesi = 0;


		try{
			File file = new File("data/" + "wo" + ".txt");
			BufferedReader br = new BufferedReader(new FileReader(file));

			String str= null;
			i=0;
			while((str = br.readLine()) != null){
				Dedede[i] = str;
				if(y31.indexOf(str)!=-1){
					inmesi = 1;
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
		if(inmesi != 0){


			int solar2 = lun2.nextInt(i);
			String mesi = Dedede[i];
			String mesi2 = Dedede[solar2];
			int dore = lun.nextInt(8);

			switch(dore){

			case 0:conn = mesi + "食べる";
			break;
			case 1:conn = mesi + "必要なし";
			break;
			case 2:conn = mesi + " vs " + mesi2 ;
			break;
			case 3:conn = mesi + "捨てた";
			break;
			case 4:conn = mesi + "かぁ";
			break;
			case 5:conn = mesi + "も" + mesi2 + "も変わらない";
			break;
			case 6:conn = mesi + "好き";
			break;
			case 7:conn = mesi + "より" + mesi2;
			break;


			}



			try{
				twitter.updateStatus(new StatusUpdate("@"+userid+" "+conn).inReplyToStatusId(tweetid));
				System.out.println("返信したよ");
				td = 1;
			} catch(TwitterException e){
				System.err.println("ツイート失敗"+e.getMessage());
			}




		}









	}


}
