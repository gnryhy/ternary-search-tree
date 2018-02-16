import java.util.ArrayList;

public class Searcher {
	
	public static void wordSearcher(TST tree, String word){
		
		String[] wordArr = word.split("\\s+");
		String wordLower = word;
		ArrayList<WordLocation> arrList = null;
		String[] strArr = wordLower.split("\\s+"); // <= parse the search key if it consists more than one word
		for(int j = 0; j < strArr.length; j++){
			try{
				arrList = tree.search(strArr[j]);
				for(int i = 0; i < arrList.size(); i++){
					System.out.println(arrList.get(i).getFileName() + ";" + wordArr[j] + ";" + arrList.get(i).getPosition());
				}
			}catch(NullPointerException e){
				System.out.println("No result found: " + wordArr[j]);
			}
		}
	}
	
	public static void phraseSearcher(TST tree, String phrase){
		
		String phraseLowerCase = phrase;
		if(phrase.contains(" ") && !phrase.endsWith(" ")){
			String upper = phraseLowerCase.substring(0, phrase.indexOf(" "));
			String lower = phraseLowerCase.substring(phraseLowerCase.indexOf(" ") + 1);
			compareTree(tree, upper, lower, true, phrase);
		}else{ // calling word searcher to avoid ArrayOutOfBoundsException in the case of one word search key with uppercase W
			wordSearcher(tree, phrase);
		}
	}
	
	private static boolean compareTree(TST tree, String upper, String lower, boolean amIFirstCall, String userKey){
		/*
		 * 
		 * 		this method recursively
		 * 		looks for the words in the search key
		 * 		given by the user
		 * 		if the first word is found in tree
		 * 		recursive call will look for the next word
		 * 		and checks their serialization.
		 * 		it goes on that way.
		 * 
		 */
		boolean retValue = false, printable = true;
		int pos = -1;
		String file = null;
		if(lower.contains(" ") && !lower.endsWith(" ")){
			ArrayList<WordLocation> wlu = new ArrayList<>();
			ArrayList<WordLocation> wll = new ArrayList<>();
			wlu = tree.search(upper);
			wll = tree.search(lower.substring(0, lower.indexOf(" ")));
			
			for(int i = 0; i < wlu.size(); i++){
				for(int j = 0; j < wll.size(); j++){
					if(wlu.get(i).getFileName().equals(wll.get(j).getFileName())
							&& wlu.get(i).getPosition() == wll.get(j).getPosition() - 1){
						
						retValue = compareTree(tree, lower.substring(0, lower.indexOf(" ")), lower.substring(lower.indexOf(" ") + 1), false, userKey);
						if(amIFirstCall == true && retValue == true){
							pos = wlu.get(i).getPosition();
							file = wlu.get(i).getFileName();
							printable = true;
						}
					}
				}
				if(amIFirstCall == true && printable == true && pos != -1){
					System.out.println(file + ";" + userKey + ";" + pos);
					printable = false;
				}
			}			
		}else{
			ArrayList<WordLocation> wlu = new ArrayList<>();
			ArrayList<WordLocation> wll = new ArrayList<>();
			wlu = tree.search(upper);
			wll = tree.search(lower);
			
			for(int i = 0; i < wlu.size(); i++){
				for(int j = 0; j < wll.size(); j++){
					if(wlu.get(i).getFileName().equals(wll.get(j).getFileName())
							&& wlu.get(i).getPosition() == wll.get(j).getPosition() - 1){
						retValue = true;
						if(amIFirstCall == true && retValue == true){
							pos = wlu.get(i).getPosition();
							file = wlu.get(i).getFileName();
							printable = true;
						}
					}
				}
				if(amIFirstCall == true && printable == true && pos != -1){
					System.out.println(file + ";" + userKey + ";" + pos);
					printable = false;
				}
			}
		}
		
		
		return retValue;	
	}
}
