/**
 * 
 */
package qreport;

import qreport.utils.Exporter;

/**
 * Example of using InputTable a QuarterTable classes for solving Tasks 3a)-3f)
 * @author Martin Cochner  
 */
public class Driver {

    /**
     * @param args
     */
    public static void main(String[] args) {

	// ////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////
	//
	// Task 3a) Read the data from the input file
	// and transform it into an object
	// from which you can create a table
	//

	InputTable inputTable = new InputTable("data.csv");

	QuarterTable quarterTable = inputTable.transformTable("Czech Republic",
		"2010 Q3");

	// ////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////
	//
	// Task 3b) Ascertain the units and share values for a given vendor.
	//

	String vendor = "Dell";

	int units = quarterTable.getSoldUnitsOfVendor(vendor);

	double share = quarterTable.getShareOfVendor(vendor);

	System.out.println(vendor + " sold " + units + " units, which is " + share
		+ "% of the market");

	
	// ////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////
	//
	// Task 3c) Ascertain which row contains information about a given
	// vendor.
	//

	vendor = "Dell";

	int rowNum = quarterTable.findRowOfVendor(vendor);

	System.out.println(vendor + " is shown on the " + rowNum + "row\n");

	// ////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////
	//
	// Tasks 3d and 3e) Sort the rows alphabetically (by vendor) and by unit values
	// ( Uncoment the printTable() to see the result )

	
	// quarterTable.printTable();
	
	quarterTable.sortByVendor(); 
	
	//quarterTable.printTable(); 
	
	quarterTable.sortByShare();

	//quarterTable.printTable();
	
	// ////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////
	//
	// Task 3f) Export the table to HTML
	//
	Exporter expo = new Exporter(quarterTable);
	expo.setName("output.html");
	expo.setType("HTML");
	expo.generate();
	
	// ////////////////////////////////////////////////////////////
	//
	// Task 3f) Describe the exporting the Table to CSV and Excel
	// classes Exporter, CSVExporter, ExcelExporter and HTMLExporter.
	// Full functionality would be attained by finishing the implementation 
	// in these classes.
	//
	// Example:
	//	Exporter expo2 = new Exporter(quarterTable);
	//      expo2.setName("output.csv");
	//      expo2.setType("CSV");
	//      expo2.generate();
	//
	///
	
    }

}
