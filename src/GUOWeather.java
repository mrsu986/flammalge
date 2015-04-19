import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
//import javax.net.ssl.HttpsURLConnection;
import java.net.URL;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class GUOWeather {
	int td = 0;

	GUOWeather(){
	}

	GUOWeather(String base, long id, String name){

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));

		String w = "";
		String day = "今日";
		int unk = 0;
		String deb="";

		try {
			URL u = new URL("http://www.tenki.jp/forecast/3/16/4410.html");
			HttpURLConnection con = (HttpURLConnection) u.openConnection();// (1)
			InputStreamReader isr = new InputStreamReader(con.getInputStream(), "UTF-8");// (1)

			//URL u = new URL("https://www.sbisec.co.jp/ETGate");// (2)
			//HttpsURLConnection con = (HttpsURLConnection) u.openConnection();// (2)
			//InputStreamReader isr = new InputStreamReader(con.getInputStream(), "SJIS");// (2)

			//URL u = new URL("https://www.monex.co.jp/Login/00000000/login/ipa �c (3)
			//HttpsURLConnection con = (HttpsURLConnection) u.openConnection();// (3)
			//InputStreamReader isr = new InputStreamReader(con.getInputStream(), "SJIS");// (3)

			BufferedReader br = new BufferedReader(isr);

			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line).append(System.getProperty("line.separator"));
			}

			//System.out.println(sb.toString());
			int bbb = sb.toString().indexOf("<p class=\"wethreDrtalIiconText\">");

			if(base.indexOf("明日")!=-1||base.indexOf("あした")!=-1){
				w = sb.toString().substring(bbb+32,sb.length());
				int ccc = w.indexOf("<p class=\"wethreDrtalIiconText\">");
				w = w.toString().substring(ccc+32,ccc+36);
				day = "明日";
			}else{
				w = sb.toString().substring(bbb+32,bbb+36);

			}

			deb = w;

			if(w.indexOf("のち")==-1){

				w = w.substring(0,1);
			}




			br.close();
			isr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		if(w.equals("晴")){
			w = day + "は多分晴れてる";
		}else if(w.equals("曇")){
			w = day + "は多分曇ってる";
		}else if(w.equals("雨")){
			w = day + "は雨ふるよ";
		}else if(w.split("のち").length==2){
			w = day +"は" +w+ "らしい";
		}else{
			w = day + "の天気はよくわからない";
			unk = 1;
		}

		try{
			twitter.updateStatus(new StatusUpdate("@"+name+" "+w).inReplyToStatusId(id));
			if(unk == 1){
				twitter.updateStatus(new StatusUpdate("@"+"mrsu986"+" a "+deb).inReplyToStatusId(id));

			}
			System.out.println("返信したよ:天気 "+w);
			td = 1;
		} catch(TwitterException e){
			System.err.println("ツイート失敗"+e.getMessage());
		}

	}
}
