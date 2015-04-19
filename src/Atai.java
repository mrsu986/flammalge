import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.java.sen.SenFactory;
import net.java.sen.StringTagger;
import net.java.sen.dictionary.Token;

public class Atai {


		String x = "ふらまもリーガル・ハイ見たん？";

		StringTagger tagger = SenFactory.getStringTagger(null);
		List<Token> tokens = new ArrayList<Token>();{

		try{
			tagger.analyze(x, tokens);
		}catch(IOException e){
	        System.out.println(e);
	  }


		for (Token token : tokens) {
		    System.out.println("=====");
		    System.out.println("surface : " + token.getSurface());
		    System.out.println("partOfSpeech : " + token.getMorpheme().getPartOfSpeech());
		    if(token.getMorpheme().getPartOfSpeech().startsWith("名詞") || token.getMorpheme().getPartOfSpeech().startsWith("未知語")){



		    }
		    //System.out.println("pronunciations : " + token.getMorpheme().getPronunciations());
		    //System.out.println("readings : " + token.getMorpheme().getReadings());
		}



		}



	}





