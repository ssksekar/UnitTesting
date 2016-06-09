//$Id$
package runtime;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RunTimeAnalysis {

	public static void main(String arg []) throws Exception
	{
		Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec("jar");
        InputStream stderr = proc.getErrorStream();
        InputStreamReader isr = new InputStreamReader(stderr);
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        System.out.println("<ERROR>");
        while ( (line = br.readLine()) != null)
            System.out.println(line);
        System.out.println("</ERROR>");
        int exitVal = proc.waitFor();
        System.out.println("Process exitValue: " + exitVal);
	}
	
}
