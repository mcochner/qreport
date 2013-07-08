/**
 * 
 */
package qreport.elements;

import java.util.ArrayList;

/**
 * @author martin
 *
 */
public class InputRow implements Row
{
    private final String country;
    private final Timescale timescale;
    private final String vendor;
    private final String units;
    
    public String getCountry()
    {
        return country;
    }

    public Timescale getTimescale()
    {
        return timescale;
    }

    public String getVendor()
    {
        return vendor;
    }

    public String getUnits()
    {
        return units;
    }
  
    /**
     * @param country 
     *
     */
    public InputRow(String country, String timescale, String vendor,
            String units)
    {
        this.country = country;
        this.timescale = new Timescale(timescale);
        this.vendor = vendor;
        this.units = units;
    }

    @Override
    public void printRow()
    {
        System.out.println(country + " " + timescale + " " + vendor + " "
                + units);
    }

    @Override
    public ArrayList<String> getRowAsStrings()
    {
        ArrayList<String> rowAsStrings = new ArrayList<String>(4);
        rowAsStrings.add(this.getCountry());
        rowAsStrings.add(this.getTimescale().toString());
        rowAsStrings.add(this.getVendor());
        rowAsStrings.add(this.getUnits()); 
        return rowAsStrings;
    }
    

    public static ArrayList<String> getColumnNames() {
 	ArrayList<String> columnNames = new ArrayList<String>();
 	columnNames.add("Country");
 	columnNames.add("Timescale");
 	columnNames.add("Vendor");
 	columnNames.add("Units");
 	
 	return columnNames;
     }
    
}
