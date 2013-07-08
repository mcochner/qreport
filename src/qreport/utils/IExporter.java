package qreport.utils;

public interface IExporter {
    
    /**
     * this method write string to file by calling helper class StringToFile
     */
    public void writeFile();
   
    /**
     * this method write generate file.
     */
    public void generateFile();
    
}
