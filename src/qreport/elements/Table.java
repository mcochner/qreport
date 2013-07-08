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
     * Method that can be used for debugging purpuses.
     */
    public void printTable();
    
    /**
     * @return List of the names of the columns. Can be used 
     *          can be used for generating the first row of the Outputing Table.      
     */
    public ArrayList<String> getColumnNames();
    
    /** Generate some special last Row on any table.
     * @return
     */
    public ArrayList<String> getLastRow();
}
