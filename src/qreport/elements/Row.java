package qreport.elements;

import java.util.ArrayList;

/**
 * Provides an abstraction for any particular Row regardless of type and amount
 * of columns it has.
 * 
 * @author Martin Cochner
 * 
 */
public interface Row {
    /**
     * This method returns Row as list of Strings.
     * 
     * @return arraylist of string that holds result of toString() method
     *         applied on each datafield in the row.
     */
    public ArrayList<String> getRowAsStrings();

    public void printRow();

}
