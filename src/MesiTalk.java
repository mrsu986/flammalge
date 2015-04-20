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


public class MesiTalk {

	int td = 0;


	MesiTalk(){

	}

	MesiTalk(String y31,String userid, long tweetid){

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

		int i=0;//このiはここにないとダメ
		String Dedede[] = new String[1000];
		String conn = "";

		Random lun = new Random();
		Random lun2 = new Random();
		int inmesi = 0;


		try{
			File file = new File("data/" + "food" + ".txt");
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


			int solar2 = lun2.nextInt(i);//要見直し　多分i-1とかi+1とか
			String mesi = Dedede[i];
			String mesi2 = Dedede[solar2];
			int dore = lun.nextInt(16);

			switch(dore){

			case 0:conn = "ふらまも" + mesi + "好きー";
			break;
			case 1:conn = mesi + "好きなの？";
			break;
			case 2:conn = mesi + "はあんまりふらまの好みじゃない";
			break;
			case 3:conn = mesi + "を食べるとか人間としてどうかと思う";
			break;
			case 4:conn = "ふらま" + mesi + "食べたことない";
			break;
			case 5:conn = mesi + "っておいしい？ ふらまも食べたい";
			break;
			case 6:conn = "わぁい" + mesi + " ふらま" + mesi + "好き";
			break;
			case 7:conn = "時代は" + mesi2 + "だから";
			break;
			case 8:conn = "ふらま" + mesi + "知ってる！ おいしいよね";
			break;
			case 9:conn = mesi + "は" + mesi2 + "に合うよね";
			break;
			case 10:conn = mesi + "・・・（ドン引き）";
			break;
			case 11:conn = mesi2 + "派です";
			break;
			case 12:conn = mesi + "と" + mesi2 + "どっちが好き？";
			break;
			case 13:conn = mesi + "かー ふらまもそうしよう";
			break;
			case 14:conn = mesi + "ってもしかして食べ物じゃない！？";
			break;
			case 15:conn = "ふらまを食べないでね";
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
