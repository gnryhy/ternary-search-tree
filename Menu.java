import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
	
	private static Scanner in = new Scanner(System.in);
	private static TST tree;
	
	public static void commandReader(String directory) throws FileNotFoundException, IOException{
		
		tree = FileIndexer.indexFiles(new File(directory));
		in.useLocale(new Locale("tr"));
		
		while(true){
			
			String usrIn = in.nextLine();
			
			String[] args = usrIn.split("\\s+");
			
			if(args[0].equalsIgnoreCase("search")){
				
				if(args[1].equals("-w")){
					String param = usrIn.substring(usrIn.indexOf(" ") + 1);
					param = param.substring(param.indexOf(" ") + 1);
					wordSearch(param);
				}
				
				if(args[1].equals("-W")){
					String param = usrIn.substring(usrIn.indexOf(" ") + 1);
					param = param.substring(param.indexOf(" ") + 1);
					phraseSearch(param);
				}
				
			}else
				System.exit(0);			
		}				
	}
	
	private static void wordSearch(String word){
		try{
			Searcher.wordSearcher(tree, word);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("<<< Search Key Cannot Be An Empty String! >>>");
		}
	}
	
	private static void phraseSearch(String phrase){
		try{
			Searcher.phraseSearcher(tree, phrase);
		}catch(NullPointerException e){
			System.out.println("No results found: " + phrase);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("<<< Search Key Cannot Be An Empty String >>>");
		}
	}
}

