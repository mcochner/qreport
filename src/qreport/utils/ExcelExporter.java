/**
 * 
 */
package qreport.utils;

import qreport.elements.Table;

/**
 * This class is a stud for exporting a Table to Excel. I would implement it simmiliary to HTMLExporter.
 * Newer Excel uses natively XML format, therefore some library could be used.  
 * 
 * @author martin
 *
 */
public class ExcelExporter implements IExporter{

    Table exportedTable;
    String name;
    
    public ExcelExporter(Table exportedTable, String name) {
	this.exportedTable = exportedTable;
	this.name = name;	
    }
    
    @Override
    public void writeFile() {
	// TODO Auto-generated method stub	
    }

    @Override
    public void generateFile() {
	// TODO Auto-generated method stub
	
    }

}
