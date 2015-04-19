import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NotKedo {

	int i;//このiはここにないとダメ
	int j;
	int ran;
	int uhuhu = 1;

	NotKedo(){

	}

	NotKedo(String hy){


		String Dedede55[] = new String[1000];

		try{
		       File file = new File("data/" + "NotKedo" + ".txt");
		       BufferedReader br = new BufferedReader(new FileReader(file));

		       String str= null;
		       i=0;
		       while((str = br.readLine()) != null){
		           Dedede55[i] = str;
		           if(hy.indexOf(Dedede55[i])!=-1){
		        	   uhuhu = 0;
		           }
		           i = i +1;

		       }

		       br.close();

		  }catch(FileNotFoundException e){
		        System.out.println(e);
		  }catch(IOException e){
		        System.out.println(e);
		  }






		  }


	  }

