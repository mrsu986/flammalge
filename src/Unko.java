import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;


public class Unko{


	static long ivil;
	static long kuso;
	static int fgou=0;

    public static void main(String[] args) {

    	while(true){

    		fgou=0;

    		try{
        	File file = new File("data/" + "idmemo" + ".txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String kucha = br.readLine();
            ivil = Long.valueOf(kucha).longValue();

            br.close();

    		}catch(FileNotFoundException e){
	        System.out.println(e);
    		}catch(IOException e){
	        System.out.println(e);
    		}

    		Twitter twitter = new TwitterFactory().getInstance();
    		twitter.setOAuthConsumer(Keys.consumerKey, Keys.consumerSecret);
    		twitter.setOAuthAccessToken(new AccessToken(Keys.accessToken,Keys.accessTokenSecret));


    		try {
    			User user = twitter.verifyCredentials();
    			List<Status> statuses = twitter.getHomeTimeline(new Paging(1,30)); //注1
    			System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");

    			for (Status status : statuses){
    				fgou++;
    				int td = 0;

    				String member[] = new String[1000];
    				int love[] = new int[1000];
    				int wcf = 0;

    				try{
    				       File file = new File("data/" + "lovelist" + ".txt");
    				       BufferedReader ll = new BufferedReader(new FileReader(file));

    				       String str= null;
    				       int li=0;
    				       while((str = ll.readLine()) != null){
    				           member[li] = str;
    				           if(status.getUser().getScreenName().equals(str)){
    				        	   wcf = 1;
    				        	   break;
    				           }
    				           li = li +1;
    				       }

    				       ll.close();

    				  }catch(FileNotFoundException e){
    				        System.out.println(e);
    				  }catch(IOException e){
    				        System.out.println(e);
    				  }




    				Ignore ig = new Ignore(status.getText());
    				int igudge = ig.judge;


    				if(igudge==1){
    					fgou--;
    					continue;
    				}

    				if(fgou == 1){
    					kuso = status.getId();
    				}

    				if(ivil >= status.getId()){
    					break;
    				}
    				if(status.getUser().getScreenName().equals("flammalge") && !(status.getText().startsWith("@flammalge "))){
    	            	 System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
    	            	 //System.out.println(status.getId());
    					continue;
    				}


    				int moji= 0;
    				String y = status.getText();
    				moji = y.length();

    		    	Random lun = new Random();
    				int solar = lun.nextInt(9);
    				int flare = lun.nextInt(111);
    				int flam = 0;

       				if(y.startsWith("ふらま ") && status.getUser().getScreenName().equals("mrsu986")){
                   		y = "@flammalge " + y.substring(4,y.length());
    				}


    				if(y.startsWith("@flammalge")){

        				Mimic mimi = new Mimic();
        				String result = mimi.mic(y);
        				td = mimi.td;
        				if(td==2){
        					try{
        			    		twitter.updateStatus(new StatusUpdate("@"+status.getUser().getScreenName()+" "+result).inReplyToStatusId(status.getId()));
        						System.out.println("ツイートしたよ：階乗計算");
        						td = 1;
        						continue;
        					} catch(TwitterException e){
        						System.err.println("ツイート失敗"+e.getMessage());
        					}

        				}

        				if(y.split("^").length==1 || y.split("＾").length==1){

            				Ruijo rjo = new Ruijo();
            				String result2 = rjo.Rock(y);
            				td = rjo.td;
            				if(td==2){
            					try{
            			    		twitter.updateStatus(new StatusUpdate("@"+status.getUser().getScreenName()+" "+result2).inReplyToStatusId(status.getId()));
            						System.out.println("ツイートしたよ：累乗計算");
            						td = 1;
            						continue;
            					} catch(TwitterException e){
            						System.err.println("ツイート失敗"+e.getMessage());
            					}

            				}
        				}

        				if(td == 0){
            				PointRep pr = new PointRep(y,status.getId(),status.getUser().getScreenName());
            				td = pr.td;
            				System.out.println("pr" + td);
        				}
        				System.out.println("pr出た" + td);

        				if(y.startsWith("@flammalge ") && td == 0){
        					MemoryNotFood mnf = new MemoryNotFood(y,status.getId(),status.getUser().getScreenName());
        					td = mnf.td;
        				}

        				if(y.startsWith("@flammalge delete_food ") && status.getUser().getScreenName().equals("mrsu986")){
        					DeleteFood dfm = new DeleteFood(y.substring(23,y.length()),status.getId(),status.getUser().getScreenName());
        					td = dfm.td;
        				}

        				if(y.startsWith("@flammalge ") && status.getUser().getScreenName().equals("mrsu986") && y.endsWith("は食べ物じゃない")){
        					DeleteFood dfm2 = new DeleteFood(y.substring(11,y.length()-8),status.getId(),status.getUser().getScreenName());
        					td = dfm2.td;
        				}

        				if(y.startsWith("@flammalge ") && !(status.getUser().getScreenName().equals("mrsu986")) && y.endsWith("は食べ物じゃない")){
        					twitter.updateStatus(new StatusUpdate("@"+status.getUser().getScreenName()+" ？ふらまわかんない").inReplyToStatusId(status.getId()));
    						System.out.println("ツイートしたよ" + "わかんない");
        					td = 1;
        				}

        				if(y.startsWith("@flammalge ") && td == 0 && y.length()>17){
        					MemoryFood mf = new MemoryFood(y,status.getId(),status.getUser().getScreenName());
        					td = mf.td;
        				}

        				if(y.equals("@flammalge おみくじ")){
            				Omikuji om = new Omikuji(y,status.getId(),status.getUser().getScreenName());
        					td = om.td;
        				}

           				if(y.equals("@flammalge ささせがわささみ") || y.equals("@flammalge 笹瀬川佐々美")){
            				Zazami zazako = new Zazami(status.getUser().getScreenName(),status.getId());
            				td = zazako.td;
        				}


        				if(y.endsWith("？") && (y.indexOf("禁止")!=-1||y.indexOf("制限")!=-1 || y.indexOf("準制")!=-1) && y.length()>4){
        					YGOKinsi ygok = new YGOKinsi(y,status.getId(),status.getUser().getScreenName());
        					td = ygok.td;
        				}

        				if(y.startsWith("@flammalge 元ネタ")){

        					Montana moto = new Montana(y,status.getId(),status.getUser().getScreenName());
        					td = moto.td;

        				}

        				if(y.indexOf("天気")!=-1){
            				GUOWeather guo = new GUOWeather(y,status.getId(),status.getUser().getScreenName());
        					td = guo.td;
        				}

           				if(!(status.getUser().getScreenName().equals("flammalge"))&& y.startsWith("@flammalge")&&td==0&& solar >2){
            				Inchan in = new Inchan(y,status.getUser().getScreenName(),status.getId());
            				td = in.td;
        				}

        				if(solar > 0 && !(status.getUser().getScreenName().equals("flammalge"))&& y.startsWith("@flammalge")&&td==0){
        					System.out.println(td);
            				OrdRep op = new OrdRep(y,status.getUser().getScreenName(),status.getId());
            				td = op.td;
        				}



    				}else{


        				Cute cute = new Cute(y,moji);
        				td = cute.td;

        				if((y.length()==4 || y.length() == 5) && y.substring(0,2).equals(y.substring(2,4))){
        					Untan untan = new Untan(y);
        					td = untan.td;

        				}

        				Zako zako = new Zako(y,moji);
        				td = zako.td;

        				if(solar != 2 && (y.indexOf("おはよ")!=-1 || y.indexOf("むくり")!=-1 || y.indexOf("起床")!=-1) && !(status.getUser().getScreenName().equals("flammalge"))){
            				GoodM gm = new GoodM(status.getUser().getScreenName(),status.getId());
            				td = gm.td;
        				}

        				if(solar < 3 && (y.indexOf("大破")!=-1) && !(status.getUser().getScreenName().equals("flammalge"))){
            				new Taiha(status.getUser().getScreenName(),status.getId());
            				td = 1;
        				}

        				//if(solar != 2 && (y.indexOf("お腹すいた")!=-1 || y.indexOf("腹減った")!=-1 || y.indexOf("なにか食")!=-1 || y.indexOf("はらへった")!=-1  || y.indexOf("おなかすいた")!=-1) && !(status.getUser().getScreenName().equals("flammalge")) && td ==0 ){
            			//	Mesitero mt1 = new Mesitero(y,status.getUser().getScreenName(),status.getId());
            			//	td = mt1.td;
        				//}


        				if(y.indexOf("ふらま")!=-1 && !(status.getUser().getScreenName().equals("flammalge")) && !(y.startsWith("@flammalge")) && !(status.getUser().getScreenName().equals("mrsu986"))){
            				Yonda ynd = new Yonda(y,status.getUser().getScreenName(),status.getId());
            				flam = 1;
            				td = ynd.td;
        				}

        				if(y.equals("おい") && status.getUser().getScreenName().equals("mrsu986")){
                       		try{
                    			twitter.updateStatus(new StatusUpdate("@"+status.getUser().getScreenName()+" なに").inReplyToStatusId(status.getId()));
        						System.out.println("ツイートしたよ 呼ばれた" );
            					td = 1;
            				} catch(TwitterException e){
            					System.err.println("ツイート失敗"+e.getMessage());
            				}
        				}

        				if(flam == 0 && y.indexOf("ふ")!=-1 && y.indexOf("ら")!=-1 && y.indexOf("ま")!=-1 && y.indexOf("ら")<y.indexOf("ま") && y.indexOf("ふ")<y.indexOf("ら") && y.indexOf("ふ")<y.indexOf("ま") && !(status.getUser().getScreenName().equals("flammalge")) && !(y.startsWith("@flammalge")) && td == 0  && !(status.getUser().getScreenName().equals("mrsu986"))){
        					DeadLock dl = new DeadLock(y,status.getUser().getScreenName(),status.getId());
            				td = dl.td;
        				}

        				if(solar < 6 && y.split("は").length==2 && !(status.getUser().getScreenName().equals("flammalge"))){
            				ModeHaCo mdhc = new ModeHaCo(y,moji);
            				td = mdhc.td;
        				}
        				if(y.split("を").length==2 && !(status.getUser().getScreenName().equals("flammalge"))){
            				ModeHaCo2 mdhc2 = new ModeHaCo2(y,moji);
            				td = mdhc2.td;
        				}

        				if(solar > 1 && y.split("から").length==2 && !(status.getUser().getScreenName().equals("flammalge"))){
            				ModeKara mdkr = new ModeKara(y,moji);
            				td = mdkr.td;
        				}

        				if(y.equals("一時停止") && status.getUser().getScreenName().equals("mrsu986")){

        	            	try{
        	        			Thread.sleep(3600000);
        	        		}catch (InterruptedException e){
        	        		}

        				}

        				if(solar > 1 && y.split("けど").length==2 && !(status.getUser().getScreenName().equals("flammalge"))){
            				ModeKedo mdkd = new ModeKedo(y,moji);
            				td = mdkd.td;
        				}

        				if(y.length() > 134 && solar>1){

        					Nagai nag = new Nagai(status.getId(),status.getUser().getScreenName());
        					td = nag.td;

        				}


        				if((y.indexOf("ロリ")!=-1 || y.indexOf("幼女")!=-1) && y.indexOf("コン")==-1 && y.indexOf("ババ")==-1 && y.indexOf("カロ")==-1 && !(status.getUser().getScreenName().equals("flammalge")) && !(y.startsWith("@flammalge")) && td==0 && flare < 62){
            				LoliCon loli = new LoliCon(status.getUser().getScreenName(),status.getId());
            				td = loli.td;
        				}

        				if(solar > 5 && td == 0 && !(status.getUser().getScreenName().equals("flammalge"))){
            				MesiTalk meta = new MesiTalk(y,status.getUser().getScreenName(),status.getId());
            				td = meta.td;
        				}



            			if( y.length() > 6 && solar > 2 && td == 0){

            				if(y.endsWith("夢を見た") == true || y.endsWith("夢見た") == true || y.indexOf("夢を見まし") != -1 || y.indexOf("夢見まし") != -1){

                        		String ky = "あっそう";


                        		try{
                        			twitter.updateStatus(new StatusUpdate("@"+status.getUser().getScreenName()+" "+ky).inReplyToStatusId(status.getId()));
            						System.out.println("ツイートしたよ" + ky);
                					td = 1;
                				} catch(TwitterException e){
                					System.err.println("ツイート失敗"+e.getMessage());
                				}

                        	}



            			}


        				int xcv = lun.nextInt(225);

        				/*

            			if(td == 0 && ( xcv == 6 || xcv ==4  || xcv ==5)){

            				TotsuHaco th = new TotsuHaco(status.getId());
            				td = th.td;

            			}

            			*/ //エラーでるから停止


            			if(td == 0 && ( xcv == 7 || xcv == 8)){

            				TotsuMesi tome = new TotsuMesi(status.getId());
            				td = tome.td;

            			}




                    	if(td == 0 && xcv == 0){

                    		y = "それな";

                    		try{
            					twitter.updateStatus(y);
            					System.out.println("ツイートしたよ" + y);
            					td = 1;
            				} catch(TwitterException e){
            					System.err.println("ツイート失敗"+e.getMessage());
            				}

                    	}

                    	if(td == 0 && xcv == 1){

                    		y = "わかる";

                    		try{
            					twitter.updateStatus(y);
            					System.out.println("ツイートしたよ" + y);
            					td = 1;
            				} catch(TwitterException e){
            					System.err.println("ツイート失敗"+e.getMessage());
            				}

                    	}

                    	if(td == 0 && xcv == 2){

                    		y = "せやな";

                    		try{
            					twitter.updateStatus(y);
            					System.out.println("ツイートしたよ" + y);
            					td = 1;
            				} catch(TwitterException e){
            					System.err.println("ツイート失敗"+e.getMessage());
            				}

                    	}

                    	if(td == 0 && ( xcv == 3 )){

                    		y = "ウケる";

                    		try{
            					twitter.updateStatus(y);
            					System.out.println("ツイートしたよ" + y);
            					td = 1;
            				} catch(TwitterException e){
            					System.err.println("ツイート失敗"+e.getMessage());
            				}

                    	}






    				}






            	 System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
            	 //System.out.println(status.getId());

             	try{
        			Thread.sleep(50);
        		}catch (InterruptedException e){
        		}

		}


        }catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }



        try{//02
		      File file = new File("data/" + "idmemo" + ".txt");

		      if (checkBeforeWritefile(file)){
		        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

					 pw.println(kuso);
					 pw.close();
		      }else{
		        System.out.println("ファイルに書き込めません");
		      }
		    }catch(IOException e){
		      System.out.println(e);
		    }//02ok

    	try{
			Thread.sleep(67000);
		}catch (InterruptedException e){
		}



    }//while



    }
	 private static boolean checkBeforeWritefile(File file){
		 if (file.exists()){
		      if (file.isFile() && file.canWrite()){
		        return true;
		      }
		    }

		    return false;
	 }




}//class





//注1 List<Status> statuses = twitter.getUserTimeline(new Paging(1,100)); 自分のだけ取得したいときはこっち
