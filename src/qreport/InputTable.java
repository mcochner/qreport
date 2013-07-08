/**
 * 
 */
package qreport;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public InputTable(String filename) {
	listOfEntries = new ArrayList<InputRow>();
	try {
	    loadFromFile(filename);
	} catch (Exception iOException) {
	    // TODO Handle exception
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

    private class SORT_BY_COUNTRY implements Comparator<InputRow> {
	@Override
	public int compare(InputRow e1, InputRow e2) {
	    return e1.getCountry().compareTo(e2.getCountry());
	}
    }

    public void printTable() {
	for (Row e : listOfEntries) {
	    e.printRow();
	}
    }

    private class SORT_BY_DATE implements Comparator<InputRow> {
	@Override
	public int compare(InputRow e1, InputRow e2) {
	    return e1.getTimescale().compareTo(e2.getTimescale());
	}
    }

    private void sortByCountry() {
	Collections.sort(listOfEntries, new SORT_BY_COUNTRY());
    }

    private void sortByDate() {
	Collections.sort(listOfEntries, new SORT_BY_DATE());
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

    public static void main(String[] args) {
	// test
	InputTable t = new InputTable("data.csv");
	t.sortByCountry();
	t.sortByDate();
	t.printTable();
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
	    i++;
	    return (Row) listOfEntries.get(i);
	}

	@Override
	public void remove() {
	}

    }

    @Override
    public Iterator<Row> iterator() {
	return new InputTableIterator();
    }

    @Override
    public ArrayList<String> getColumnNames() {
	// TODO Auto-generated method stub
	return null;
    }
}