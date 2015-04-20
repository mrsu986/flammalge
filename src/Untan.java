import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class Untan {

	int td = 0;

	Untan(){

	}

	Untan(String cutey){

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

		int i = 0;
		String Dedede[] = new String[1000];
		int core = -1;


		if(cutey.length()==5){
			cutey = cutey.substring(0,4)+"";

		}

		String bf = cutey;

		System.out.println(cutey);

		for(int a=12353 ; a<12435; a++){//英語があるかチェック
			char d = (char)a;
			String d2 = String.valueOf(d);

			if(cutey.indexOf(d2)!=-1){
				cutey = cutey.replaceAll(d2, "");
			}

		}

		System.out.println(cutey);

		if(cutey.length()==0){


			cutey = bf;


			try{
				File file = new File("data/" + "tantan" + ".txt");
				BufferedReader br = new BufferedReader(new FileReader(file));

				String str= null;
				i=0;
				while((str = br.readLine()) != null){
					Dedede[i] = str;
					if(str.equals(cutey)){
						core = i;

					}
					i = i +1;
				}

				br.close();

			}catch(FileNotFoundException e){
				System.out.println(e);
			}catch(IOException e){
				System.out.println(e);
			}

			if(core == -1){

				try{
					twitter.updateStatus(cutey);
					System.out.println("！ツイートしたよ："+cutey);
					td = 1;
					try{
						File file = new File("data/" + "tantan" + ".txt");

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
