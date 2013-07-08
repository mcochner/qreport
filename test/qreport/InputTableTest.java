package qreport;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InputTableTest
{
    private InputTable inputTable;

    @Before
    public void setUp() throws Exception
    {
        inputTable = new InputTable("testdata.csv");
        inputTable.printTable();
    }


    @Test
    public void testInputTable()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testPrintTable()
    {
        fail("Not yet implemented");
    }

}
