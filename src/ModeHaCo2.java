import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class ModeHaCo2 {
	int td = 0;

	ModeHaCo2(){

	}

	ModeHaCo2(String cutey, int cutemoji){


		String Mae ="";
		String Usiro ="";

		String mmf = "";

		Random rnd = new Random();
		int nnn = rnd.nextInt(2);

		int i=0;//このiはここにないとダメ
		String Dedede[] = new String[1000];


		int jissai = rnd.nextInt(192);

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

		System.out.println("ららららら2");

		Mae = cutey.split("を")[0];

		System.out.println("文章が「を」条件通過");
		if(Mae.split("、").length>1){
			Mae = Mae.split("、")[Mae.split("、").length-1];
		}


		try{
			File file = new File("data/" + "wo" + ".txt");

			if (checkBeforeWritefile(file)){
				FileWriter filewriter = new FileWriter(file, true);

				filewriter.write(Mae);
				filewriter.write("\r\n");
				filewriter.close();
			}else{
				System.out.println("ファイルに書き込めません");
			}
		}catch(IOException e){
			System.out.println(e);
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
