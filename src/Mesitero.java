import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;

//import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class Mesitero {

	int td = 0;

	Mesitero(){
	}

	Mesitero(String base, String name, long id){

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));


		int i = 0;;
		String Dedede[] = new String[1500];

		//検索ワードを指定

		String mesi = "牛丼";

		try{
		       File file = new File("data/" + "food" + ".txt");
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

		Random lun = new Random();
		int solar = lun.nextInt(i);

		mesi = Dedede[solar];


		String mesien = "a";
		String mol = "";

		Random rnd = new Random();
		int uuu = rnd.nextInt(20);


		try{
			mesien = URLEncoder.encode(mesi, "UTF-8");
		}catch(UnsupportedEncodingException e){
			System.err.println(e.getMessage());

		}


		try {
			//URL u = new URL("https://www.google.co.jp/search?q="+mesien+"&safe=off&source=lnms&tbm=isch");
			//HttpURLConnection con = (HttpURLConnection) u.openConnection();// (1)
			//InputStreamReader isr = new InputStreamReader(con.getInputStream(), "UTF-8");// (1)

							 //https://www.google.co.jp/search?q=%E7%89%9B%E4%B8%BC&safe=off&source=lnms&tbm=isch
			URL u = new URL("https://www.google.co.jp/search?q="+mesien+"&safe=off&source=lnms&tbm=isch");// (2)
			HttpsURLConnection con = (HttpsURLConnection) u.openConnection();// (2)
			InputStreamReader isr = new InputStreamReader(con.getInputStream(), "SJIS");// (2)

			//URL u = new URL("https://www.monex.co.jp/Login/00000000/login/ipa �c (3)
			//HttpsURLConnection con = (HttpsURLConnection) u.openConnection();// (3)
			//InputStreamReader isr = new InputStreamReader(con.getInputStream(), "SJIS");// (3)

			BufferedReader br = new BufferedReader(isr);

			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line).append(System.getProperty("line.separator"));
			}

			String molbase = sb.toString();
			int bbb = 0;

			for(int hj=0 ; hj <= uuu ; hj++){

				bbb = sb.toString().indexOf("imgurl=");
				molbase = molbase.substring(bbb+7,molbase.length());

			}

			int vvv = molbase.indexOf("&");
			mol = molbase.substring(0,vvv);


			br.close();
			isr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}


		try{
			twitter.updateStatus(new StatusUpdate("@"+name+" "+mol).inReplyToStatusId(id));
			System.out.println("返信したよ:メシテロ " + mesi);
			td = 1;
		} catch(TwitterException e){
			System.err.println("ツイート失敗"+e.getMessage());
		}

	}
}
