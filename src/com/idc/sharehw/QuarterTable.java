/**
 * 
 */
package com.idc.sharehw;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


/**
 * @author martin
 * 
 */
public class QuarterTable implements Table
{
    private int totalSoldUnits = 0;
    private HashMap<String, Integer> hm = new HashMap<String, Integer>();
    private List<QuarterRow> listOfEntries = new ArrayList<QuarterRow>();

    int findVendorRow(){
        int row = 1;
        if listOfEntries[row].returnVendor
        return row;
    }
        
    private class QuarterRow
    {
        private String vendor;
        private int units;
        private double share;

        public void printRow()
        {
            System.out.println();
        }

        public String getVendor()
        {
            return vendor;
        }

        public int getUnits()
        {
            return units;
        }

        public double getShare()
        {
            return share;
        }
        
        
    }

    public QuarterTable()
    {

    }

    public QuarterTable(InputTable in, Timescale t, String country)
    {
        // TODO Auto-generated constructor stub
    }

    private String createFirstRow()
    {
        return null;
    }

    public class SORT_BY_VENDOR implements Comparator<QuarterRow>
    {
        @Override
        public int compare(QuarterRow r1, QuarterRow r2)
        {
            return r1.vendor.compareTo(r2.vendor);
        }
    }

    public class SORT_BY_SHARE implements Comparator<QuarterRow>
    {
        @Override
        public int compare(QuarterRow r1, QuarterRow r2)
        {
            if (r1.share == r2.share)
                return 0;
            if (r1.share < r2.share)
                return -1;
            return 1;
        }
    }

    @Override
    public void printTable()
    {
        for (QuarterRow r : listOfEntries)
        {
            r.printRow();
        }
    }
    
    private void generateHTML(){
        
    }
    
    public void exportToHTML()
    {
        
        try
        {
            FileOutputStream fos = new FileOutputStream("test.txt");
            Writer out = new OutputStreamWriter(fos, "UTF8");
            out.write(output);
            out.close();
           
        } catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        // phrase.replace(' ', '_');
       
        StringBuilder output = new StringBuilder();
        output.append("<html><body>\n");
        output.append("<table border=\"1\"\n");
        for (QuarterRow r : listOfEntries)
        {
            r.printRow();
        }
        // <tr>
        // <th>Month</th>
        // <th>Savings</th>
        // </tr>
        // <tr>
        // <td>January</td>
        // <td>$100</td>
        // </tr>
        // <tr>
        // <td>February</td>
        // <td>$80</td>
        // </tr>
        // </table>
        //
        // </body>
        // </html>
        output.append("</html></body>\n");
        System.out.println(output);
    }

}
