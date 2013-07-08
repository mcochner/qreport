package qreport.utils;

import java.util.ArrayList;
import qreport.elements.Row;
import qreport.elements.Table;

public class HTMLExporter implements IExporter {
    
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
    @Override
    public void writeFile(){
	new StringToFile(output, filename);
    }
    
    
    /**
     * This class generate a string that will later be saved to a file.
     */
    @Override
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
