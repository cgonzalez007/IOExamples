package ioexamples;

import java.io.*;
import java.util.*;

/**
 * TextWriterApp.java	1.00 Nov 25, 2003
 *
 * A class that writes data to a text file, with buffering.
 */
public class TextWriterApp{
	
   public static void main(String[] args) throws IOException{
   	  boolean append = true;   // you can change this

	  // This references the file in the working directory
	  File data = new File("src" + File.separatorChar 
                        + "contactList.txt");
          /*Format of contact list:
                FirstName LastName
                Street Address
                City, State Zipcode
          */
	  		
      // This is where we setup our streams (append = false means overwrite)
      // new FileWriter() creates the file if doesn't exit
	  PrintWriter out = new PrintWriter(
						new BufferedWriter(
						new FileWriter(data, append)));
	  
	  // print statements do actual work of writing data
	  // note that print statements work similar to Sytem.out.println,
	  // where data is converted to strings
           /* out.println("Chris Gonzalez");
            out.println("301 CandyLand Ave");
            out.println("Waukesha, WI 53186");
            out.println("Bob Johnson");
            out.println("222 Wherever St");
            out.println("Hartland, WI 53029");*/
	  out.close();  // be sure you close your streams when done!!
	
	  System.out.println("Wrote file to: " + data.getAbsolutePath());
   }
}
