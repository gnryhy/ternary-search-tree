import java.io.IOException;

/*
 * 			<<<<<<<<<<<<< IMPORTANT NOTE >>>>>>>>>>>>>>
 * 			TEXT FILES MUST BE ENCODED WITH UTF-8 WITHOUT BOM
 * 			OTHERWISE WORDS WITH NON-ENGLISH CHARACTERS
 * 			CANNOT BE SEARCHED PROPERLY !!!!!!!
 * 			<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>
 */


public class Main {

	public static void main(String[] args) throws IOException {
		
		try{
		Menu.commandReader((args[0].toString())); // execute menu
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("You should pass the directory path for the text files as an argument!\nTerminating...");
		}catch(NullPointerException e){
			System.out.println("No Files Found!\nTerminating...");
		}
	}
}