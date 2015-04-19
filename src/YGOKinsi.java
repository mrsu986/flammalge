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

public class YGOKinsi {

	private static final String consumerKey = "KyzIwOlAaZcceh26v3nhpNwx1";
	private static final String consumerSecret = "G9RGKUCfw3PB1DhKhXbsqlXC87dbQpUTvDCvNSlvvDTMSsy1va";
	private static final String accessToken = "2491767283-9cWwyeOqzEew2zKU71ImHnDkgUpK8LTLXL3YmPg";
	private static final String accessTokenSecret = "hbxXNcQZMZFNS5H7gEsMN6abm3ts0GEPLhwUfTPG1eOD6";
	int td = 1;

	YGOKinsi(){
	}

	YGOKinsi(String x,long id, String name){

		//System.out.println("pass1");


		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(consumerKey, consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(accessToken,accessTokenSecret));

		x=x.substring(11, x.length());
		int cnn = 0;

		if(x.split("は").length==2){
			x=x.substring(0,x.indexOf("は"));
			cnn = 1;
		}

		if(x.split("って").length==2){
			x=x.substring(0,x.indexOf("って"));
			cnn = 1;

		}

		if(cnn == 0){

			if(x.substring(x.length()-3,x.length()-1).equals("禁止") || x.substring(x.length()-3,x.length()-1).equals("制限") || x.substring(x.length()-3,x.length()-1).equals("準制")){
				x=x.substring(0,x.length()-3);

			}

		}


		String w = "";
		int level = 0;

		int Lv5 = 0;
		int Lv3 = 0;
		int Lv2 = 0;
		int Lv1 = 0;
		int Lv0 = 0;

		try {
			URL u = new URL("http://yugioh-wiki.net/index.php?%A5%EA%A5%DF%A5%C3%A5%C8%A5%EC%A5%AE%A5%E5%A5%EC%A1%BC%A5%B7%A5%E7%A5%F3");
			HttpURLConnection con = (HttpURLConnection) u.openConnection();// (1)
			InputStreamReader isr = new InputStreamReader(con.getInputStream(), "EUC-JP");// (1)
			//InputStreamReader isr = new InputStreamReader(con.getInputStream(), "UTF-8");// (1)

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

			Lv5 = sb.toString().indexOf("これまでのリミットレギュレーション");

			String unko = sb.toString().substring(Lv5,sb.toString().length());

			Lv3 = unko.indexOf("その他のリンク");
			Lv2 = unko.indexOf("wiki.net/index.php?%C0%A9%B8%C2%A5%AB%A1%BC%A5%C9");
			Lv1 = unko.indexOf("BD%E0%C0%A9%B8%C2%A5%AB%A");
			Lv0 = unko.indexOf("日本未発売カード");

			boolean c = unko.split(x).length>1;



			if(c){
				if(unko.indexOf(x)>Lv3 && (unko.indexOf(x)<Lv2)){
					level = 3;
				}

				if(unko.indexOf(x)>Lv2 && (unko.indexOf(x)<Lv1)){
					level = 2;
				}

				if(unko.indexOf(x)>Lv1 && (unko.indexOf(x)<Lv0)){
					level = 1;
				}


			}

			br.close();
			isr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		if(level == 3){
			w = x +"は禁止";
		}else if(level == 2){
			w = x +"は制限";
		}else if(level == 1){
			w = x +"は準制";
		}else{
			w = x+"は制限かかってないよ　それかカード名が違う";
		}

		try{
			System.out.println(x);
			System.out.println(w+"と呟く予定");
			twitter.updateStatus(new StatusUpdate("@"+name+" "+w).inReplyToStatusId(id));
			System.out.println("返信したよ:禁止制限 "+w);
			td = 1;
		} catch(TwitterException e){
			System.err.println("ツイート失敗"+e.getMessage());
		}

	}
}