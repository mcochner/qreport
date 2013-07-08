package qreport.utils;

/** Interface for Exporter classes
 * @author martin
 *
 */
public interface IExporter {
    
    /**
     * This method writes string to file by calling helper class StringToFile
     */
    public void writeFile();
   
    /**
     * This method generates file.
     */
    public void generateFile();
    
}
