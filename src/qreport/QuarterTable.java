/**
 * 
 */
package qreport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import qreport.elements.QuarterRow;
import qreport.elements.Row;
import qreport.elements.Table;
import qreport.elements.Timescale;

/**
 * This class imlements initial loading of the CSV data to a table 
 * @author Martin Cochner  
 */
public class QuarterTable implements Table {
    private int totalSoldUnits = 0;
    private ArrayList<QuarterRow> listOfEntries = new ArrayList<QuarterRow>();

    private final String country;
    private final Timescale timescale;

    public String getCountry() {
	return country;
    }

    public Timescale getTimescale() {
	return timescale;
    }

    // //////////////////////////////////////////////////////////////////////////
    //
    // public methods:

    /**
     * @param qRows
     * @param country
     *            For which country I want to make a report
     * @param timescale
     *            For which quartal I want to make a report, e.g. "2010 Q1"
     */
    public QuarterTable(ArrayList<QuarterRow> qRows, String country,
	    String timescale) {
	this.country = country;
	this.timescale = new Timescale(timescale);

	for (QuarterRow r : qRows) {
	    listOfEntries.add(r);
	}

	// finish the inicialization
	countTotalSoldUnits();
	setShareForTable();
    }

    public void sortByVendor() {
	Collections.sort(listOfEntries, new SORT_BY_VENDOR());
    }

    public void sortByShare() {
	Collections.sort(listOfEntries, new SORT_BY_SHARE());
    }

    /**
     * Method implements finding the row by the vendor name.
     * 
     * @param vendor
     * @return returns the the number of row in the Table or -1 if no such
     *         vendor exists
     */
    public int findRowOfVendor(String vendor) {
	int row = 1;
	for (QuarterRow r : listOfEntries) {
	    if (r.getVendor().equals(vendor))
		return row;
	    else
		row++;
	}
	return -1;
    }

    /**
     * @param vendor
     * @return returns a number of sold units
     */
    public int getSoldUnitsOfVendor(String vendor) {
	if (vendor.equals("Total"))
	    return totalSoldUnits;
	return getRowOfVendor(vendor).getUnits();
    }

    /**
     * @param vendor
     * @return returns the share of vendor
     */
    public double getShareOfVendor(String vendor) {
	return getRowOfVendor(vendor).getShare();
    }

    @Override
    public Iterator<Row> iterator() {
	return new QuarterTableIterator();
    }

    @Override
    public void printTable() {
	System.out.format("%18s %8s   %s %n", "Vendor", "Units", "Share");
	double hundredPercent = 0;
	for (QuarterRow r : listOfEntries) {
	    r.printRow();
	    hundredPercent += r.getShare();
	}

	System.out.format("%18s %8d   %3.1f %n", "Total", getTotalSoldUnits(),
		hundredPercent);
	System.out.println();
    }

    @Override
    public ArrayList<String> getColumnNames() {
	return QuarterRow.getColumnNames();
    }

    @Override
    public ArrayList<String> getLastRow() {
	ArrayList<String> output = new ArrayList<String>(); 

	output.add("Total");
	output.add(Integer.toString(getTotalSoldUnits()));
	output.add("100.0");	
	return output;
    }
    
    
    @Override
    public String toString() {
	StringBuilder stringOfTable = new StringBuilder();

	stringOfTable.append(String.format("%10s %8s   %s %n", "Vendor",
		"Units", "Share"));

	double hundredPercent = 0;
	for (QuarterRow r : listOfEntries) {
	    stringOfTable.append(r.toString());
	    hundredPercent += r.getShare();
	}

	stringOfTable.append(String.format("%10s %8d   %3.1f %n", "Total",
		getTotalSoldUnits(), hundredPercent));

	return stringOfTable.toString();
    }
    
    // //////////////////////////////////////////////////////////////////////////
    //
    // private methods:

    private void countTotalSoldUnits() {
	for (QuarterRow r : listOfEntries) {
	    setTotalSoldUnits(getTotalSoldUnits() + r.getUnits());
	}
    }

    private QuarterRow getRowOfVendor(String vendor) {
	for (QuarterRow r : listOfEntries) {
	    if (r.getVendor().equals(vendor))
		return r;
	}
	return null;
    }

    private void setShareForTable() {
	for (QuarterRow r : listOfEntries) {
	    double vendorShare;
	    vendorShare = 100 * r.getUnits() / (double) getTotalSoldUnits();
	    r.setShare(vendorShare);
	}
    }

    private class QuarterTableIterator implements Iterator<Row> {
	private int i = 0;

	@Override
	public boolean hasNext() {
	    if (i < listOfEntries.size())
		return true;
	    else
		return false;
	}

	@Override
	public Row next() {
	    return (Row) listOfEntries.get(i++);
	}

	@Override
	public void remove() {
	}
    }

    private class SORT_BY_VENDOR implements Comparator<QuarterRow> {
	@Override
	public int compare(QuarterRow r1, QuarterRow r2) {
	    return r1.getVendor().compareTo(r2.getVendor());
	}
    }

    private class SORT_BY_SHARE implements Comparator<QuarterRow> {
	@Override
	public int compare(QuarterRow r1, QuarterRow r2) {
	    double share1 = r1.getShare();
	    double share2 = r2.getShare();

	    if (share1 == share2)
		return 0;
	    if (share1 < share2)
		return -1;
	    return 1;
	}
    }

    private int getTotalSoldUnits() {
	return totalSoldUnits;
    }

    private void setTotalSoldUnits(int totalSoldUnits) {
	this.totalSoldUnits = totalSoldUnits;
    }
}
