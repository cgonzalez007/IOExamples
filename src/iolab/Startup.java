package iolab;


import java.io.IOException;


/**
 * Startup class with cleaned up  for completing the IO lab activities
 * @author Chris Gonzalez
 */
public class Startup {
    public static void main(String[] args) throws IOException {
        /*PART #1: 
            File Reader*/
	ContactFileManager mgr = new ContactFileManager();
        mgr.readFile("contactList.txt");
        /*PART #2: 
            File Writer*/
        //mgr.appendToFile("John Doe\n" +
            //"301 Imagination Ln\n" +
            //"Los Angeles, CA 22222", "contactList.txt");
          
          
        /*After completing #2, find the contact that is second on your list and output their
            state. Do this using Java File I/O and programming only. Your output should look
            like similar to this:*/
          /*State: MI*/
         mgr.retrieveStateFromRecord(7, "contactList.txt");
         
         /*Did not file file so a new one was created*/
         //mgr.rewriteToFile("Testing...","otherFileTest.txt"); 
          
    }
}
