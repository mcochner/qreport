/**
 * 
 */
package qreport.elements;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author martin
 * 
 */
public interface Table extends Iterable<Row> {
    public void printTable();
    public ArrayList<String> getColumnNames();
}
