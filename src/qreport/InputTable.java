/**
 * 
 */
package qreport;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import qreport.elements.*;

import au.com.bytecode.opencsv.CSVReader;

/**
 * @author Martin Cochner
 * 
 */
public class InputTable implements Table {
    private List<InputRow> listOfEntries;

    // //////////////////////////////////////////////////////////////////////////
    //
    // public methods:
    
    public InputTable(String filename) {
	listOfEntries = new ArrayList<InputRow>();
	try {
	    loadFromFile(filename);
	} catch (Exception iOException) {
	    iOException.printStackTrace();
	}

    }

    public InputTable(InputRow arrayOfEntries[]) {
	for (InputRow e : arrayOfEntries) {
	    listOfEntries.add(e);
	}
    }

    public Iterator<InputRow> createIterator() {
	return listOfEntries.iterator();
    }

    public void printTable() {
	for (Row e : listOfEntries) {
	    e.printRow();
	}
    }

    public QuarterTable transformTable(String country, String timescale) {
	ArrayList<QuarterRow> qRows = new ArrayList<QuarterRow>();

	for (InputRow e : listOfEntries) {
	    // Am I in the right row to add to the OutputTable?
	    if ((e.getCountry().equals(country))
		    && (e.getTimescale().toString().equals(timescale))) {
		qRows.add(new QuarterRow(e.getVendor(), (int) Double
			.parseDouble(e.getUnits())));
	    }
	}

	return new QuarterTable(qRows, country, timescale);
    }

    @Override
    public Iterator<Row> iterator() {
	return new InputTableIterator();
    }

    @Override
    public ArrayList<String> getColumnNames() {
	return InputRow.getColumnNames();
    }


    /* (non-Javadoc)
     * @see qreport.elements.Table#getLastRow()
     * 
     * For InputTable is this method not important as I do not use it.
     */
    @Override
    public ArrayList<String> getLastRow() {
	return null;
    }
    
    // //////////////////////////////////////////////////////////////////////////
    //
    // private methods:

    private void loadFromFile(String filename) throws IOException {
	CSVReader reader = new CSVReader(new FileReader(filename), ',', '\t', 1);
	String nextLine[];
	while ((nextLine = reader.readNext()) != null) {
	    // nextLine[] is an array of values from the line
	    InputRow entry = new InputRow(nextLine[0], nextLine[1],
		    nextLine[2], nextLine[3]);
	    listOfEntries.add(entry);
	}
	reader.close();
    }

    private class InputTableIterator implements Iterator<Row> {

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

}