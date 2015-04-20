import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.Random;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class DeleteFood {
	int td = 0;

	DeleteFood(){

	}

	DeleteFood(String cutey, long id, String name){

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

		int i=0;//このiはここにないとダメ
		String Dedede[] = new String[1000];
		int morph = -1;



		try{
			File file = new File("data/" + "food" + ".txt");
			BufferedReader br = new BufferedReader(new FileReader(file));

			String str= null;
			i=0;
			while((str = br.readLine()) != null){
				Dedede[i] = str;
				if(cutey.startsWith(Dedede[i])){
					morph = i;
				}
				i = i +1;

			}


			br.close();

		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
		if(morph == -1){
			try{
				twitter.updateStatus(new StatusUpdate("@"+name+" うるさい").inReplyToStatusId(id));
				System.out.println("返信したよ：なにそれ");
				td = 1;
			}catch(TwitterException e){
				System.err.println("ツイート失敗"+e.getMessage());
			}
		}

		if(morph != -1){
			try{
				twitter.updateStatus(new StatusUpdate("@"+name+" " + Dedede[morph] + "は食べ物じゃないのか・・・").inReplyToStatusId(id));
				System.out.println("返信したよ：食べ物じゃない");
				td = 1;
			}catch(TwitterException e){
				System.err.println("ツイート失敗"+e.getMessage());
			}

			try{
				File file = new File("data/" + "food" + ".txt");

				if (checkBeforeWritefile(file)){
					PrintWriter pwx = new PrintWriter(new BufferedWriter(new FileWriter(file)));

					for(int yh=0; yh<=i-1; yh++){
						if(yh != morph){
							pwx.println(Dedede[yh]);
						}

					}

					pwx.close();
				}else{
					System.out.println("ファイルに書き込めません");
				}
			}catch(IOException e){
				System.out.println(e);
			}


			try{
				File file = new File("data/" + "NotMesi" + ".txt");

				if (checkBeforeWritefile(file)){
					FileWriter filewriter = new FileWriter(file, true);

					filewriter.write(Dedede[morph]);
					filewriter.write("\r\n");
					filewriter.close();
				}else{
					System.out.println("ファイルに書き込めません");
				}
			}catch(IOException e){
				System.out.println(e);
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
