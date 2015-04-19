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


public class ModeHaCo {
	int td = 0;

	ModeHaCo(){

	}

	ModeHaCo(String cutey, int cutemoji){


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

		NotHa notha = new NotHa(cutey);
		int uhuhu = notha.uhuhu;


		if(cutey.indexOf("は") != -1 && cutey.length() > 5 && cutey.startsWith("は") == false && cutey.endsWith("は") == false && uhuhu == 1 ){

			System.out.println("文章が「は」条件通過");

			try{
			       File file = new File("data/" + "Mars" + ".txt");
			       BufferedReader br = new BufferedReader(new FileReader(file));

			       Mae = br.readLine();
			       Usiro = br.readLine();

			       br.close();

			  }catch(FileNotFoundException e){
			        System.out.println(e);
			  }catch(IOException e){
			        System.out.println(e);
			  }

			System.out.println(Mae + " : " +Usiro);


			if(nnn==0){

				while(true){
					cutey = cutey.substring(0,cutey.length()-1);
					if(cutey.endsWith("は") == true){
						cutey = cutey.substring(0,cutey.length()-1);
						Mae = cutey;
						break;
					}
				}

				try{
				      File file = new File("data/" + "Haco1" + ".txt");

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

			if(nnn==1){
				while(true){
					cutey = cutey.substring(1,cutey.length());
					if(cutey.startsWith("は") == true){
						cutey = cutey.substring(1,cutey.length());
						Usiro = cutey;
						break;
					}
				}

				try{
				      File file = new File("data/" + "Haco2" + ".txt");

				      if (checkBeforeWritefile(file)){
				        FileWriter filewriter = new FileWriter(file, true);

				        filewriter.write(Usiro);
				        filewriter.write("\r\n");
				        filewriter.close();
				      }else{
				        System.out.println("ファイルに書き込めません");
				      }
				    }catch(IOException e){
				      System.out.println(e);
				    }


			}

			System.out.println(Mae + " : " +Usiro);


			try{
			      File file = new File("data/" + "Mars" + ".txt");

			      if (checkBeforeWritefile(file)){
			        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));


					pw.println(Mae);
					pw.println(Usiro);

	        pw.close();
			      }else{
			        System.out.println("ファイルに書き込めません");
			      }
			    }catch(IOException e){
			      System.out.println(e);
			    }

			if(Mae.equals("未入力")&&!(Usiro.equals("未入力")) && jissai < 35){

				try{

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


				String fy = Dedede[solar] + "は" + Usiro;

				twitter.updateStatus(fy);


			}catch(TwitterException e){
				System.err.println("ツイート失敗"+e.getMessage());
			}

				try{
				      File file = new File("data/" + "Mercury" + ".txt");

				      if (checkBeforeWritefile(file)){
				        PrintWriter pwx = new PrintWriter(new BufferedWriter(new FileWriter(file)));


						pwx.println("未入力");
						pwx.println("未入力");

		        pwx.close();
				      }else{
				        System.out.println("ファイルに書き込めません");
				      }
				    }catch(IOException e){
				      System.out.println(e);
				    }

				Mae = "未入力";
				Usiro = "未入力";

			}

			if(!(Mae.equals("未入力")||Usiro.equals("未入力"))){

				try{

					String fy = Mae + "は" + Usiro;

					try{
				       File file = new File("data/" + "Mercury" + ".txt");
				       BufferedReader kr = new BufferedReader(new FileReader(file));

				       mmf = kr.readLine();

				       kr.close();

					}catch(FileNotFoundException e){
						System.out.println(e);
					}catch(IOException e){
						System.out.println(e);
					}

					if(!(mmf.equals("未入力")) && jissai<128){
						fy = mmf+"から"+fy;

					}

					if(jissai==2){
						fy = "とにかく"+fy;
					}


					try{
					       File file = new File("data/" + "Venus" + ".txt");
					       BufferedReader kdr = new BufferedReader(new FileReader(file));

					       mmf = kdr.readLine();

					       kdr.close();

						}catch(FileNotFoundException e){
							System.out.println(e);
						}catch(IOException e){
							System.out.println(e);
						}

						if(!(mmf.equals("未入力")) && jissai<64){
							fy = mmf+"けど"+fy;

						}





					if(jissai==0){
						fy = "実際"+fy;
					}

					if(jissai==1){
						fy = "実は"+fy;
					}


						twitter.updateStatus(fy);

					System.out.println("ツイートしたよ："+fy);

					if(fy.endsWith("い") && (jissai < 5 || jissai > 121)){
						twitter.updateStatus("のか？");

					}

					td = 1;

					try{
					      File file = new File("data/" + "Mars" + ".txt");

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


					try{
					      File file = new File("data/" + "Mercury" + ".txt");

					      if (checkBeforeWritefile(file)){
					        PrintWriter pwx = new PrintWriter(new BufferedWriter(new FileWriter(file)));


							pwx.println("未入力");
							pwx.println("未入力");

			        pwx.close();
					      }else{
					        System.out.println("ファイルに書き込めません");
					      }
					    }catch(IOException e){
					      System.out.println(e);
					    }

					try{
					      File file = new File("data/" + "Venus" + ".txt");

					      if (checkBeforeWritefile(file)){
					        PrintWriter pwx = new PrintWriter(new BufferedWriter(new FileWriter(file)));


							pwx.println("未入力");
							pwx.println("未入力");

			        pwx.close();
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
