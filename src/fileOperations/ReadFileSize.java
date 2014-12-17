//$Id$
package fileOperations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ReadFileSize {

	static BufferedWriter bw = null;
	
	public static void listFilesForFolder(final File folder) throws Exception{
		
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	Thread.sleep(200);
	        	System.out.println( "Thread Slept for 200 ms for Folder ::: " + fileEntry.getPath() + "/" +  fileEntry.getName() );
	            listFilesForFolder(fileEntry);
	        } else {
	            //System.out.println( fileEntry.getPath() + "/" +  fileEntry.getName() + " ::: " + fileEntry.length());
	            long len = fileEntry.length();
	            len = len/(1024l*1024l); //converting bytes to MB 
	            bw.write("<p>" + fileEntry.getPath() + "/" +  fileEntry.getName() + " ::: <span style='color:red'>" + len + " MB </span></p>");
				bw.newLine();
	        }
	    }
	}

	public static void main(String [] arg) throws Exception
	{
		System.out.println("STARTED");
		bw = new BufferedWriter(new FileWriter("/Users/sathish-1343/fileSizes.html"));
		final File folder = new File("/Users/sathish-1343/");
		listFilesForFolder(folder);
		System.out.println("DONE");
	}	
}
