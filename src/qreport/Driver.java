/**
 * 
 */
package qreport;

/**
 * @author Martin Cochner
 * Priklad pouziti InputTable a QuarterTable
 */
public class Driver {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// Nacteme data ze souboru   
	InputTable inputTable = new InputTable("data.csv");
	
	// Vygeneruje report pro danou zemi a kvartal	
	QuarterTable quarterTable = inputTable.transformTable("Czech Republic", "2010 Q3");
	
	
	// Vygeneruje report pro danou zemi a kvartal	
	quarterTable.sortByShare();

    }

}
