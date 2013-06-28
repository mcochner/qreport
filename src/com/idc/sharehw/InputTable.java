/**
 * 
 */
package com.idc.sharehw;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

/**
 * @author Martin Cochner
 * 
 */
public class InputTable implements Table
{
    private List<Entry> listOfEntries;
    private class Entry
    {
        private final String country;
        private final Timescale timescale;
        private final String vendor;
        private final String units;

        private Entry(String country, String timescale, String vendor,
                String units)
        {
            this.country = country;
            this.timescale = new Timescale(timescale);
            this.vendor = vendor;
            this.units = units;
        }

        public void printRow()
        {
            System.out.println(country + " " + timescale + " " + vendor + " "
                    + units);
        }
    }

    public InputTable(String filename)
    {
        listOfEntries = new ArrayList<Entry>();
        try
        {
            loadFromFile(filename);
        } catch (Exception iOException)
        {
            // TODO Handle exception
        }

    }
     
    public Iterator<Entry> createIterator(){
        return listOfEntries.iterator();  
    }
    
    private void loadFromFile(String filename) throws IOException
    {
        CSVReader reader = new CSVReader(new FileReader(filename), ',', '\t', 1);
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null)
        {
            // nextLine[] is an array of values from the line
            Entry entry = new Entry(nextLine[0], nextLine[1], nextLine[2],
                    nextLine[3]);
            listOfEntries.add(entry);
        }
        reader.close();
    }

    @Override
    public void printTable()
    {

        for (Entry e : listOfEntries)
        {
            e.printRow();
        }

    }

    private class SORT_BY_COUNTRY implements Comparator<Entry>
    {
        @Override
        public int compare(Entry e1, Entry e2)
        {
            return e1.country.compareTo(e2.country);
        }
    }

    private class SORT_BY_DATE implements Comparator<Entry>
    {
        @Override
        public int compare(Entry e1, Entry e2)
        {
            return e1.timescale.compareTo(e2.timescale);
        }
    }

    private void sortByCountry()
    {
        Collections.sort(listOfEntries, new SORT_BY_COUNTRY());
    }

    private void sortByDate()
    {
        Collections.sort(listOfEntries, new SORT_BY_DATE());
    }

//    public OutputTable transformTable(String country, String timescale){
//         
//        for (Entry e : listOfEntries)
//        {
//            //Am I in the right row to add to the OutputTable?
//            if ((e.country.equals(country)) && 
//                    (e.timescale.toString().equals(timescale))){
//                e.vendor                
//            }
//        }
//        
//        OutputTable out = new out; 
//        
//        return out;    
//    }
    
    public static void main(String[] args)
    {
        // test
        InputTable t = new InputTable("data.csv");

        t.sortByCountry();
        t.sortByDate();
        t.printTable();
    }
}