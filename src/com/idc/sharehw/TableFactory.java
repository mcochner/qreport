/**
 * 
 */
package com.idc.sharehw;


/**
 * @author martin
 *
 */
public class TableFactory
{
    private Timescale timetable;
    private String country;
    
    TableFactory(String country){
        country = new String("Czech republic");
    }
    
    TableFactory(String sTimescale, String country){
        timetable = new Timescale(sTimescale);
        this.country = new String(country);  
    }
    
    QuarterTable generateTable(InputTable in, String timetable){
        // idem po riadkoch out
        return new QuarterTable();
    }

}
