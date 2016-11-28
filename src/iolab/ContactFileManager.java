package iolab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *  Simple Class that does some file manipulation (Reading, appending, and rewriting).
 * @author Chris Gonzalez 2016
 */
public class ContactFileManager {
    /**
     * Simply reads the file
     * @param fileName file name to read (Ex: contactList.txt)
     * @throws IOException if file is unable to be read
     */
    public final void readFile(String fileName) throws IOException{
         File data = new File("src" + File.separatorChar 
                        + fileName);
        BufferedReader in = null;
        try {
	   in = new BufferedReader(new FileReader(data));
	   String line = in.readLine();
	   while(line != null){
		  System.out.println(line);
		  line = in.readLine();  // strips out any carriage return chars
	   }
	 
        } catch(IOException ioe) {
            System.out.println("Houston, we have a problem! reading this file");
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                
            }
        }
    }
    /**
     * Appends whatever is desired to the file specified. If the file not found, 
     * a new one will be created with the desired output.
     * @param output what to append to the file
     * @param fileName file name to appended to (Ex: contactList.txt)
     * @throws IOException if file is unable to be read
     */
    public final void appendToFile(String output, String fileName) throws IOException{
        boolean append = true;   
	  File data = new File("src" + File.separatorChar 
                        + fileName);
          /*Format of contact list:
                FirstName LastName
                Street Address
                City, State Zipcode
          */
	  PrintWriter out = new PrintWriter(
						new BufferedWriter(
						new FileWriter(data, append)));
	  out.print(output);
	  out.close();  
	
	  System.out.println("\nWrote file to: " + data.getAbsolutePath());
    }
    /**
     * Rewrites entire file of desired output. If the file not found, 
     * a new one will be created with the desired output.
     * @param output what is to be rewritten in the file
     * @param filePath file name to rewritten (Ex: contactList.txt)
     * @throws IOException if file is unable to be read
     */
    public final void rewriteToFile(String output, String filePath) throws IOException{
        boolean append = false;   
	  File data = new File("src" + File.separatorChar 
                        + filePath);
          /*Format of contact list:
                FirstName LastName
                Street Address
                City, State Zipcode
          */
	  PrintWriter out = new PrintWriter(
						new BufferedWriter(
						new FileWriter(data, append)));
	  out.print(output);
	  out.close();  
	
	  System.out.println("\nWrote file to: " + data.getAbsolutePath());
    }
    /**
     * retrieves state of a record based on record #.
     * @param record record # of contact in file. 
     * @param filePath file name to be read (Ex: contactList.txt)
     * @throws IOException if file is unable to be read
     */
    public final void retrieveStateFromRecord(int record, String filePath) 
            throws IOException{
        File data = new File("src" + File.separatorChar 
                        + filePath);
         BufferedReader in = null;
        try {
	   in = new BufferedReader(new FileReader(data));
	   String line = in.readLine();
           int recordCounter = 1;
           final int RECORD_TO_FIND = record;
           
                for(; recordCounter < RECORD_TO_FIND; recordCounter++){
                    line = in.readLine();
                    if(line == null){
                        break;
                    }
                    line = in.readLine();
                    if(line == null){
                        break;
                    }
                    line = in.readLine(); 
                    if(line == null){
                        break;
                    }
                }
                if(recordCounter == RECORD_TO_FIND){
                    line = in.readLine();
                    line = in.readLine();
                    String[] lineArray = line.split(", ");
                    String[] lineArray2 = lineArray[1].split(" ");
                    String state = lineArray2[0];
                    System.out.println("\nState: " + state);
                }else{
                    System.out.println("\nRecord not found");
                }
                
	 
        } catch(IOException ioe) {
            System.out.println("Houston, we have a problem! reading this file");
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    
}
