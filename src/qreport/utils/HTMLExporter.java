package qreport.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

import qreport.QuarterTable;
import qreport.elements.QuarterRow;
import qreport.elements.Row;
import qreport.elements.Table;

public class HTMLExporter {
   
//    private void exportToHTML() {
//
//	// phrase.replace(' ', '_');
//
//	StringBuilder output = new StringBuilder();
//	output.append("<html><body>\n");
//	output.append("<table border=\"1\"\n");
//	for (QuarterRow qRr : listOfEntries) {
//	    r.printRow();
//	}
//	// <tr>
//	// <th>Month</th>
//	// <th>Savings</th>
//	// </tr>
//	// <tr>
//	// <td>January</td>
//	// <td>$100</td>
//	// </tr>
//	// <tr>
//	// <td>February</td>
//	// <td>$80</td>
//	// </tr>
//	output.append("</table></html></body>\n");
//	System.out.println(output);
//
//	try {
//	    FileOutputStream fos = new FileOutputStream("test.txt");
//	    Writer out = new OutputStreamWriter(fos, "UTF8");
//	    out.write(output.toString());
//	    out.close();
//
//	} catch (FileNotFoundException e) {
//	    e.printStackTrace();
//	} catch (UnsupportedEncodingException e) {
//	    e.printStackTrace();
//	} catch (IOException e) {
//	    e.printStackTrace();
//	}
//    }
    
    
    Table exportedTable;
    String filename;
    StringBuilder output;
    
    public HTMLExporter(Table exportedTable, String name) {
	this.exportedTable = exportedTable;
	this.filename = name;	
	
	generateFile();
	
	writeFile();
    }
    
    /**
     * This class save a string to a file.
     * 
     */
    public void writeFile(){
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
    
    
    /**
     * This class generate a string that will later be saved to a file.
     */
    public void generateFile(){
	output = new StringBuilder();
	
	//to generate HTML file some header needs to be appended
	output.append("<html><body>\n");
	//table - begin
	output.append("<table border=\"1\"\n");
	
	
	//first row consists of names of the columns:
	output.append("<tr> \n");	
	for(String s: exportedTable.getColumnNames()){
		output.append("<th>");
		output.append(s);
		output.append("</th> \n");
	    }
	output.append("</tr> \n");

	// For each row in the Table: 
	for(Row r: exportedTable){
	    ArrayList<String> row = r.getRowAsStrings();
	    output.append("<tr> \n");
	    // get columns 
	    for(String s: row){
		output.append("<td>");
		output.append(s);
		output.append("</td> \n");
	    }
	    output.append("</tr> \n");
	}	
	
	//the last row contains total sold units:
	output.append("<tr> \n");	
	for(String s: exportedTable.getLastRow()){
		output.append("<td>");
		output.append(s);
		output.append("</td> \n");
	    }
	output.append("</tr> \n");

	//to generate HTML file some ending needs to be appended
     	output.append("</table></html></body> \n");	
    }     
}
