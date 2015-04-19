import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ignore {

	int i;//このiはここにないとダメ
	int j;
	int judge = 0;
	int ef = 0;
	Ignore(){
	}

	Ignore(String y){



		String Dedede[] = new String[1000];

		try{
		       File file = new File("data/" + "ignore" + ".txt");
		       BufferedReader br = new BufferedReader(new FileReader(file));

		       i = 0;

		       if (y.startsWith("@flammalge ")){
		    	 ef = 1;
		       }

		       String str= null;
		       while((str = br.readLine()) != null){
		           Dedede[i] = str;

		           if(ef==1){
		        	   if(i == 0){
		        		   ef = 1;
		        		   continue;
		        	   }
		           }

		           if(y.indexOf(Dedede[i])!=-1){
		        	   judge = 1;
		        	   //System.out.println("NG:"+Dedede[i]);
		        	   break;
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


