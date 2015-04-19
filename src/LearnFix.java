import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class LearnFix {
	int td = 0;

	LearnFix(){


		//ふらまに定型文を覚えさせるクラスになる予定

	}

	LearnFix(String cutey,long tweetid, String userid){

   		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

		int judgefood = 0;

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

		if(cutey.endsWith("わ")){
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

		if(cutey.endsWith("は飲み物")){
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

		if(cutey.endsWith("はごはん")){
			cutey = cutey.substring(0,cutey.length()-4)+"";
			judgefood = 1;

		}



		if(judgefood==1){

			cutey = cutey.substring(0,cutey.length());

			try{
				twitter.updateStatus(new StatusUpdate("@"+userid+" "+cutey + "は食べ物・・・").inReplyToStatusId(tweetid));
				System.out.println("！ツイートしたよ："+cutey + "は食べ物");
				td = 1;
				try{
				      File file = new File("data/" + "food" + ".txt");

				      if (checkBeforeWritefile(file)){
				        FileWriter filewriter = new FileWriter(file, true);

				        filewriter.write(cutey);
				        filewriter.write("\r\n");
				        filewriter.close();
				      }else{
				        System.out.println("ファイルに書き込めません");
				      }
				    }catch(IOException e){
				      System.out.println(e);
				    }

			}catch(TwitterException e){
				System.err.println("ツイート失敗"+e.getMessage());
			}

		}

	}



	  private static boolean checkBeforeWritefile(File file){
		    if (file.exists()){
		      if (file.isFile() && file.canWrite()){
		        return true;
		      }
		    }

		    return false;
		  }




}
