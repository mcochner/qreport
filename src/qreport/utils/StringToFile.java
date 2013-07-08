package qreport.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * Helper class that writes any StringBuilder to a file.
 * 
 */
public class StringToFile {

    /**
     * Constructor creates a file, writes a StringBuilder and close the file
     * 
     * @param output
     * @param filename
     */
    public StringToFile(StringBuilder output, String filename) {
	try {
	    FileOutputStream fos = new FileOutputStream(filename);
	    OutputStreamWriter out = new OutputStreamWriter(fos, "UTF8");
	    out.write(output.toString());
	    out.close();

	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
