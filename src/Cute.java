import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class Cute {

	int td = 0;

	Cute(){

	}

	Cute(String cutey, int cutemoji){

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

		if(cutey.endsWith("と")){
			cutey = cutey.substring(0,cutey.length()-1);

		}


		if(cutey.endsWith("な")){
			cutey = cutey.substring(0,cutey.length()-1);

		}


		if(cutey.endsWith("なぁ")){
			cutey = cutey.substring(0,cutey.length()-2);

		}

		if(cutey.endsWith("なあ")){
			cutey = cutey.substring(0,cutey.length()-2);

		}


		if(cutey.endsWith("可愛い")){
			cutey = cutey.substring(0,cutey.length()-3)+"かわいい";

		}


		if(cutey.endsWith("ぐうかわ")){
			cutey = cutey.substring(0,cutey.length()-4)+"かわいい";

		}

		if(cutey.endsWith("ぐうかわいい")){
			cutey = cutey.substring(0,cutey.length()-6)+"かわいい";

		}

		if(cutey.endsWith("ぐぅかわ")){
			cutey = cutey.substring(0,cutey.length()-4)+"かわいい";

		}

		if(cutey.endsWith("ぐぅかわいい")){
			cutey = cutey.substring(0,cutey.length()-6)+"かわいい";

		}


		if(cutey.endsWith("かわいい") == true && cutey.length() > 4){

			cutey = cutey.substring(0,cutey.length()-4);

			try{
				twitter.updateStatus(cutey + "かわいい");
				System.out.println("！ツイートしたよ："+cutey + "かわいい");
				td = 1;
				try{
					File file = new File("data/" + "cutes" + ".txt");

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
