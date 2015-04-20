import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class ModeKara {
	int td = 0;

	ModeKara(){

	}

	ModeKara(String cutey, int cutemoji){


		String Mae2 ="";
		String Usiro2 ="";

		Random rnd = new Random();
		int nnn = rnd.nextInt(5);

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

		System.out.println("ららららら5");

		NotKara notka = new NotKara(cutey);
		int uhuhu = notka.uhuhu;


		if(cutey.indexOf("から") != -1 && cutey.length() > 6 && cutey.startsWith("から") == false && cutey.endsWith("から") == false && uhuhu == 1 ){

			System.out.println("文章が「から」条件通過");

			try{
				File file = new File("data/" + "Mercury" + ".txt");
				BufferedReader br = new BufferedReader(new FileReader(file));

				Mae2 = br.readLine();
				Usiro2 = br.readLine();

				br.close();

			}catch(FileNotFoundException e){
				System.out.println(e);
			}catch(IOException e){
				System.out.println(e);
			}

			System.out.println(Mae2 + " : " +Usiro2);


			if(nnn>1){
				while(true){
					cutey = cutey.substring(0,cutey.length()-1);
					if(cutey.endsWith("から") == true){
						cutey = cutey.substring(0,cutey.length()-2);
						Mae2 = cutey;
						break;
					}
				}
			}

			if(nnn<2){
				while(true){
					cutey = cutey.substring(1,cutey.length());
					if(cutey.startsWith("から") == true){
						cutey = cutey.substring(2,cutey.length());
						Usiro2 = cutey;
						break;
					}
				}
			}

			System.out.println(Mae2 + " : " +Usiro2);

			try{
				File file = new File("data/" + "Mercury" + ".txt");

				if (checkBeforeWritefile(file)){
					PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));


					pw.println(Mae2);
					pw.println(Usiro2);

					pw.close();
				}else{
					System.out.println("ファイルに書き込めません");
				}
			}catch(IOException e){
				System.out.println(e);
			}

			if(!(Mae2.equals("未入力")||Usiro2.equals("未入力"))){

				try{

					String fy2 = Mae2 + "から" + Usiro2;

					twitter.updateStatus(fy2);

					System.out.println("ツイートしたよ："+fy2);
					td = 1;

					try{
						File file = new File("data/" + "Mercury" + ".txt");

						if (checkBeforeWritefile(file)){
							PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));


							pw.println("未入力");
							pw.println("未入力");

							pw.close();
						}else{
							System.out.println("ファイルに書き込めません");
						}
					}catch(IOException e){
						System.out.println(e);
					}



				} catch(TwitterException e){
					System.err.println("ツイート失敗"+e.getMessage());
				}


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
