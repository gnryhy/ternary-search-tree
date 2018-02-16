import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;


public class FileIndexer {
	
	private static ArrayList<File> files = new ArrayList<>();
	private static int numOfFiles = 0;
	
	
	/*
	 * 		this method searches for
	 * 		.txt files at given path recursively
	 */
	
	private static void listFiles(File directory) throws IOException{
		File[] foundFile = directory.listFiles();
		for (File file : foundFile) {
			if (file.isDirectory()) {
				listFiles(file);
			} else {
				if(file.getName().endsWith(".txt")){
					files.add(file);
					numOfFiles++;
				}
			}
		}

		if(numOfFiles == 0)
			throw new NullPointerException();
	}
	
	/*
	 * 		This method puts all the words
	 * 		found at text files into
	 * 		the ternary search tree
	 */
		
	public static TST indexFiles(File directory) throws FileNotFoundException, IOException{
		
		listFiles(directory);
		TST result = new TST();
		Locale.setDefault(new Locale("tr"));
		
		for(int i = 0; i < files.size(); i++){
			
			File f = files.get(i);
			int position = 0;
			String fileName = f.getName();
			
			FileInputStream fis = new FileInputStream(f);
			
			try(BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF8"))) {
			    for(String line; (line = br.readLine()) != null; ) {
			        String[] parsed = line.split("[\\s,]+");
			        
			        for(int j = 0; j < parsed.length; j++){
			        	if(parsed[j].endsWith(",")){
			        		parsed[j] = parsed[j].substring(0, parsed[j].length() - 1);
			        	}
			        	position++;
			        	result.insert(parsed[j], new WordLocation(position, fileName));
			        } 		        
			    }
			    br.close();
			    System.out.println(f.getName() + " is indexed.");
			}
			
		}
		
		return result;
	}

	public static ArrayList<File> getFiles() {
		return files;
	}

	public static int getNumOfFiles() {
		return numOfFiles;
	}
	
}
