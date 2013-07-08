/**
 * 
 */
package qreport.elements;

import java.util.ArrayList;

/**
 * @author martin
 * 
 */
public interface Table extends Iterable<Row> {
    /**
     * Print table to the console. 
     */
    public void printTable();
    
    /** What kind of data are in each column. 
     * @return List of the names of the columns. Can be used 
     *          for generating the first row of the Outputing Table.      
     */
    public ArrayList<String> getColumnNames();
    
    /** Creates summary for the table. 
     * @return Place for the last row that can be used during exporting.
     */
    public ArrayList<String> getLastRow();
}
