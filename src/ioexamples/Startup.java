package ioexamples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Startup class with cleaned up  for completing the IO lab activities
 * @author Chris Gonzalez
 */
public class Startup {
    /**
         * Step #1:
        Use Sample project: “IOExamples”, and reference ONLY “TextReaderApp.java”
        and “TextWriterApp.java”
            Create a text file named “contactList.txt” using Notepad++ or your
            favorite text editor. Copy the file and paste it into the “default package” of 
            your Netbeans project. If you do not see this package, simple paste in the
            file by selecting the folder named “Source Packages”. Now you should see
            the default package and your file. Your file can be referenced in your code
            at “src/contactList.txt”
            Enter data representing a small contact list. Format exactly as follows
            (each group of 3 lines is one record, create at least 3 records by typing
            directly into your text editor):
                FirstName LastName
                Street Address
                City, State Zipcode
            … now read each record from the file and output to the console. Once
            you’ve successfully shown that you can read data from a file, append one
            or two new records using file I/O write techniques. Maintain the same
            format
     * @param args
     * @throws java.io.IOException
         */
    public static void main(String[] args) throws IOException {
        /*PART #1: 
            File Reader*/
	File data = new File("src" + File.separatorChar 
                        + "contactList.txt");
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
        /*PART #2: 
            File Writer*/
        boolean append = true;   
	  File data2 = new File("src" + File.separatorChar 
                        + "contactList.txt");
          /*Format of contact list:
                FirstName LastName
                Street Address
                City, State Zipcode
          */
	  PrintWriter out = new PrintWriter(
						new BufferedWriter(
						new FileWriter(data2, append)));
	  /*
            out.println("Chris Gonzalez");
            out.println("301 CandyLand Ave");
            out.println("Waukesha, WI 53186");
            out.println("Bob Johnson");
            out.println("222 Wherever St");
            out.println("Hartland, WI 53029");*/
	  out.close();  
	
	  System.out.println("Wrote file to: " + data.getAbsolutePath());
          
          
          /*After completing #2, find the contact that is second on your list and output their
            state. Do this using Java File I/O and programming only. Your output should look
            like similar to this:*/
          /*Sean Connery state: Detroit*/
         File data3 = new File("src" + File.separatorChar 
                        + "contactList.txt");
         in = null;
        try {
	   in = new BufferedReader(new FileReader(data));
	   String line = in.readLine();
           int recordCounter = 1;
           final int RECORD_TO_FIND = 2;
           
                for(; recordCounter < RECORD_TO_FIND ; recordCounter++){
                    line = in.readLine();
                    line = in.readLine();
                    line = in.readLine();
                }
                if(recordCounter == RECORD_TO_FIND){
                    line = in.readLine();
                    line = in.readLine();
                    String[] lineArray = line.split(", ");
                    String[] lineArray2 = lineArray[1].split(" ");
                    String state = lineArray2[0];
                    System.out.println("Sean Connery state: " + state);
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
