/**
 *  Simple datastructure that implements Timescale columns  
 */
package com.idc.sharehw;

/**
 * @author Martin Cochner
 *
 */
public class Timescale implements Comparable<Timescale>
{

    private String quarter;
    
    public Timescale(String s){
        quarter = new String(s);
    }
    @Override
    public int compareTo(Timescale o)
    {
        String[] s1 = this.quarter.split(" ");
        String[] s2 = o.quarter.split(" ");
        int year1 = Integer.parseInt(s1[0]);
        int year2 = Integer.parseInt(s2[0]);

        if (year1<year2) return -1;
        if (year1>year2) return 1;
        
        // year1 == year2             
        String q1 = s1[1];  // q1, q2 = {Q1,Q2,Q3,Q4}
        String q2 = s2[1];         
        
        return q1.compareTo(q2);
    }
    
    @Override
    public boolean equals(Object obj)
    {
        // TODO Auto-generated method stub
        return this.quarter.equals(obj);
    }
    
    @Override
    public String toString(){
        return quarter;               
    }
}
