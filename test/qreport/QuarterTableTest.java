package qreport;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import qreport.QuarterTable;
import qreport.elements.QuarterRow;

public class QuarterTableTest {

    private QuarterTable quarterTable;

    private void setup() {
	ArrayList <QuarterRow> qRows = new ArrayList<QuarterRow>();
	qRows.add(new QuarterRow("IBM", 15000));
	qRows.add(new QuarterRow("Dell", 12030));
	qRows.add(new QuarterRow("HP", 11000));
	qRows.add(new QuarterRow("Others", 75000));
	
	quarterTable = new QuarterTable(qRows, "Czech Republic", "2010 Q1");
    }

    @Test
    public void testFindRowOfVendor() {
	setup();
	int actual = quarterTable.findRowOfVendor("IBM");
	int expected = 1;

	assertEquals(expected, actual);

	actual = quarterTable.findRowOfVendor("HP");
	expected = 3;
	assertEquals(expected, actual);
    }

    @Test
    public void testVendorSoldUnits() {
	setup();
	int actual = quarterTable.getSoldUnitsOfVendor("IBM");
	int expected = 15000;
	assertEquals(expected, actual);

	actual = quarterTable.getSoldUnitsOfVendor("HP");
	expected = 11000;
	assertEquals(expected, actual);
    }

    @Test
    public void testgetShareOfVendor() {
	setup();
	double actual = quarterTable.getShareOfVendor("IBM");
	double expected = 13.3;
	assertEquals(expected, actual, 0.1);

	actual = quarterTable.getShareOfVendor("HP");
	expected = 9.7;
	assertEquals(expected, actual, 0.1);
    }

    // Sort the rows alphabetically
    @Test
    public void testSortByVendor() {
	setup();
	quarterTable.sortByVendor();
	quarterTable.printTable();
	
	int actual = quarterTable.findRowOfVendor("Dell");
	int expected = 1;			
	assertEquals(expected, actual);
	
	actual = quarterTable.findRowOfVendor("Others");
	expected = 4;			
	assertEquals(expected, actual);
    }
}
