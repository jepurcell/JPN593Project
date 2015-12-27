


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;

public class TokenizerEx {

	public static void main(String[] args) throws IOException {
	
		Tokenizer tokenizer;
		String curLine;
		
		tokenizer = Tokenizer.builder().build();
		if(args. length >= 1){
			try{
				System.out.println("Java: Running Tokenizer on input " + args[0]);
			
				BufferedReader br = new BufferedReader(new FileReader(args[0]));
				PrintWriter writer = new PrintWriter(args[0].substring(0, args[0].length() - 4) + "Output.txt", "UTF-8");
				while ((curLine = br.readLine()) != null) { 
					List<Token> result = tokenizer.tokenize(curLine);
					for (Token token : result) {
						//System.out.println(token.getSurfaceForm() + "\t"+ token.getAllFeatures());
						writer.println(token.getSurfaceForm() + "\t" + token.getAllFeatures());
					}
				}
				br.close();
				writer.close();
			}
			catch (IOException e) {
				System.err.println("Error: " + e);
			}
		}
		else System.out.println("No arguments provided");
		
	}
}
