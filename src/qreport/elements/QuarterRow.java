/**
 * 
 */
package qreport.elements;

import java.util.ArrayList;

/**
 * @author Martin Cochner  
 * 
 */
public class QuarterRow implements Row {
    private String vendor;
    private int units;
    private double share;

    public QuarterRow(String vendor, int units) {
	this.vendor = vendor;
	this.units = units;
    }

    public String toString() {
	return String.format("%18s %8d   %3.1f %n", vendor, units, share);
    }

    public void printRow() {
	System.out.print(this.toString());
    }

    public String getVendor() {
	return vendor;
    }

    public int getUnits() {
	return units;
    }

    public double getShare() {
	return share;
    }

    public void setShare(double share) {
	this.share = share;
    }

    @Override
    public ArrayList<String> getRowAsStrings() {

	ArrayList<String> rowAsStrings = new ArrayList<String>(3);
	rowAsStrings.add(this.getVendor());
	rowAsStrings.add((Integer.toString(this.getUnits())));
	rowAsStrings.add((Double.toString(this.getShare())));
	return rowAsStrings;
    }
    
    // dobre by bolo dat ho do Row a annotovat @Override, ale java nepodporuje 
    // static+abstract(interface) 
    public static ArrayList<String> getColumnNames() {
	ArrayList<String> columnNames = new ArrayList<String>();
	columnNames.add("Vendor");
	columnNames.add("Units");
	columnNames.add("Share");

	return columnNames;
    }
}
