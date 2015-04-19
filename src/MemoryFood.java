import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class MemoryFood {

	int td = 0;

	MemoryFood(){

	}

	MemoryFood(String cutey,long tweetid, String userid){

   		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

		int judgefood = 0;

		cutey = cutey.substring(14,cutey.length());


			try{
				twitter.updateStatus(new StatusUpdate(cutey).inReplyToStatusId(tweetid));
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



	  private static boolean checkBeforeWritefile(File file){
		    if (file.exists()){
		      if (file.isFile() && file.canWrite()){
		        return true;
		      }
		    }

		    return false;
		  }




}
