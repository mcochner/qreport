package qreport;

import static org.junit.Assert.*;

import java.util.Iterator;
import org.junit.Test;

import qreport.elements.Row;

public class InputTableTest
{
    private InputTable inputTable;

    public void setup()
    {
	InputTable inputTable = new InputTable("data.csv");
	//inputTable.printTable();
    }


    @Test
    public void testInputTable()
    {
	setup();
	Iterator<Row> itr = inputTable.iterator();
	while (itr.hasNext())
	{
	    
	    Row row = itr.next();
	    row.printRow();
	}
        fail("Not yet implemented");
    }

    @Test
    public void testPrintTable()
    {
        fail("Not yet implemented");
    }

}
