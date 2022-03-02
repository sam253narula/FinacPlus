package com.interview;


/*Write a program that finds the most optimized set of 6 units to shop with for values under
100. Example: Units used are 1, 2, 5, 10, 20, 50 1: 1 (1 unit used) 2: 2 (1 unit used) 3: 1+2 (2
units used) 4: 2+2 (2 units used) … 98: 1+2+5+20+20+50 (6 units used) 99:
2+2+5+20+20+50 (6 units used) AVG of units = 3.4*/

public class OptimisedUseOfUnits {

	
	 static int minUnits(int unitss[], int m, int V)
	    {
	       // base case
	       if (V == 0) return 0;
	      
	       // Initialize result
	       int res = Integer.MAX_VALUE;
	      
	       // Try every unit that has smaller value than V
	       for (int i=0; i<m; i++)
	       {
	         if (unitss[i] <= V)
	         {
	             int sub_res = minUnits(unitss, m, V-unitss[i]);
	      
	             // Check for INT_MAX to avoid overflow and see if
	             // result can minimized
	             if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
	                res = sub_res + 1;
	         }
	       }
	       return res;
	    }
	    public static void main(String args[])
	    {
	       int unitss[] =  {9, 6, 5, 1};
	       int m = unitss.length;
	       int V = 11;
	       System.out.println("Minimum unitss required is "+ minUnits(unitss, m, V) );
	    }
}
