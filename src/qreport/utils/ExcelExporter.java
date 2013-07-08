/**
 * 
 */
package qreport.utils;

import qreport.elements.Table;

/**
 * This class is a stud for exporting an Table to Excel. I would implement it simmiliary to HTMLExporter.
 * Newer Excel uses natively XML format, therefore some could be used.  
 * 
 * @author martin
 *
 */
public class ExcelExporter{

    Table exportedTable;
    String name;
    
    public ExcelExporter(Table exportedTable, String name) {
	this.exportedTable = exportedTable;
	this.name = name;	
    }
    
    /**
     * This class would generate the file 
     */
    public void generateString(){
	
    }

}
