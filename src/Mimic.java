import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mimic {

	String result = "";
	int td = 0;
	String mic(String fgh){
		int xyz[] = new int[100000];

		if(fgh.indexOf("！")!=-1){
			fgh=fgh.replaceAll("！","!");

		}

		StringBuilder y = new StringBuilder(fgh);//これがないとunnu.deleteができない
		String x = String.valueOf(y.delete(0,11));
		String ox = x;
		if(ox.endsWith("!")==false || ox.length()<2 || ox.length()>5){
			return "";
		}
		if(ox.equals("0!")||ox.equals("1!")){
			td = 2;
			System.out.println("1");
			return "1";
		}
    	for(int a=48; a<58; a++){//英語があるかチェック
    		char d = (char)a;
    		String d2 = String.valueOf(d);
           	Pattern r3 = Pattern.compile(d2);
            Matcher o3 = r3.matcher(ox);

            if(o3.find()==true){
            	x = x.replaceAll(d2, "");
            }

        }


        if(x.length()!=1){
        	return "";
        }


        x=ox;

        while(x.startsWith("0")){
        		x = x.substring(1,x.length());
        }
        x = x.substring(0,x.length()-1);

		System.out.println(x+"は階乗");

		ox = x;
		int ato=0;
		int now=2;
		int base = Integer.parseInt(ox);
		xyz[1]=1;

		for(int d=1;d<=base;d++){
			for(int e=1;e<=now+1;e++){
				xyz[e]=xyz[e]*d;
				if(ato>0){
					xyz[e]=xyz[e]+ato;
					ato=0;
				}
				if(xyz[e]>9999){//
					ato = xyz[e]/10000;//
					xyz[e]=xyz[e]-ato*10000;//
					if(e==now){
						now++;
					}
				}








			}

		}




			StringBuilder r = new StringBuilder();//これがないとunnu.deleteができない

			while(true){

				StringBuilder kll = new StringBuilder(String.valueOf(xyz[now]));

				while(true){

					if(kll.length()<4){//
						kll=kll.insert(0,0);
					}else{
						break;
					}
				}

				String kll2 = String.valueOf(kll);

				r = r.append(kll2);
				now--;
				if(now==0){
					break;

				}
			}

			td=2;

			result = String.valueOf(r);


			while(true){

				if(result.startsWith("0")){
					result=r.substring(1,r.length());
					r = new StringBuilder(String.valueOf(result));
				}else{
					break;
				}


			}


			if(result.length()>100){

				int fix=result.length()-2;
				result = result.substring(0, 2);
				if(result.substring(0, 1).equals("9")||result.substring(0, 1).equals("8")||result.substring(0, 1).equals("7")){
					fix++;

				}
				result = result+"*10^"+fix+"くらい";
			}

			return result;


		}



	}


