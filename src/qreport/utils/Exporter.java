package qreport.utils;
import qreport.utils.HTMLExporter;

public class Exporter {
    public Exporter(String typeOfExport, String filename) {
	if (typeOfExport.equals("HTML"))
		new HTMLExporter(filename);
    }
    
    
    
    
    
    
    


    public Exporter(){
        this("HTML", "output.html");
    }

    public Exporter(String typeOfExport){
        this(typeOfExport, "out" );
    }
}