import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		// 1. ask user for a file name
		// 2. check if file exists
		// 3. determine if file is empty
		// 4. rename .txt as .html
		// 5. read each line and insert necessary <tags>
		
		Scanner sc = new Scanner(System.in);
		Scanner fileIn; // input file connection
		
		PrintWriter fileOut; // HTML file connection
		String fileNameIn; // original file's name
		String fileNameOut; // new HTML file's name
		int dotIndex; // position of dots within fileName
		String line = null;
		
		// 1. ask user for a file name or file path
		
		System.out.println("Enter file name");
		fileNameIn = sc.nextLine();
		
		// 2. check if file exist
		
		try {
			// 3. rename .txt as .html
			fileIn = new Scanner(new FileReader(fileNameIn));
			dotIndex = fileNameIn.lastIndexOf(".");
				
			if (dotIndex == -1) 
			{
				fileNameOut = fileNameIn + ".html";
			}
			else
			{
				fileNameOut = fileNameIn.substring(0,dotIndex) + ".html";	// questionable
			}
			fileOut = new PrintWriter(fileNameOut);
			
			// 4. filename out
			
			try {
				line = fileIn.nextLine();
			}
			catch(NoSuchElementException e) {
				System.out.println("Error: "+e.getMessage());
			}
			
			if(line==null) {
				System.out.println("This file is empty, nothing to be converted");
			}
			else {
				// 5. read each line and insert necessary <tags>
				fileOut.println("<html>");	
				fileOut.println("<head>");
				fileOut.println("</head>");
				fileOut.println("<body>");	
				fileOut.println(line);	
				
				// while loop to repeat the file until its finished
				while(fileIn.hasNextLine()) {
					
					fileOut.println("<br>");
					line = fileIn.nextLine();
					
					if (line.isEmpty()) {
						fileOut.println("<br>");
					}	
					else {
						fileOut.println(line);
					}
				}
				
				fileOut.println("</body>");
				fileOut.println("</html>");
				
				System.out.println("File is converted to HTML");
			}
			fileIn.close();
			fileOut.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		
	}

}
