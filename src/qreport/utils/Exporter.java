package qreport.utils;

import qreport.QuarterTable;
import qreport.elements.Table;

/**
 * Exporter class can create  
 * @author martin
 *
 */
public class Exporter {
    private Table exportedTable;

    public String getName() {
	return name;
    }

    public String getType() {
	return type;
    }

    private String name = "out.html";
    private String type;

    public void setType(String type) {
	this.type = type;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Exporter(QuarterTable quarterTable) {
	exportedTable = quarterTable;
    }

    public void generate() {
	checkName();
	
	//  java 1.7 allows cases with strings
	switch (type) {
	case "HTML":
	    new HTMLExporter(exportedTable, name);
	    break;
	case "CSV":
	    new CSVExporter(exportedTable, name);
	    break;
	case "Excel":
	    new ExcelExporter(exportedTable, name);
	    break;
	default:
	    throw new UnsupportedOperationException();
	}
    }
    
    /**
     * Here I can have some name checking.
     * 
     */
    private void checkName() {

    }

}