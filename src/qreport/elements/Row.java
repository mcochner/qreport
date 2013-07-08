package qreport.elements;

import java.util.ArrayList;

public interface Row
{
    /** This method returns Row as list of Strings.
     * @return arraylist of string that holds result of toString() method
     *          applied on each datafield in the row.
     */
    public ArrayList<String> getRowAsStrings();
    public void printRow();
    
}
