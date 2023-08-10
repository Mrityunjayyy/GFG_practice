//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends


class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) 
	{
	     int[][] t = new int[n+1][k+1];
        for(int[] a : t)
        {
            Arrays.fill(a , -1);
        }
        return solve(n , k , t);
	}
	
	
	 public static int solve(int e , int f , int[][] t)
    {
        if(e == 1)
        return f;
        
        if(f == 0 || f ==1)
        return f;

        if(t[e][f] != -1)
        return t[e][f];

       

        int min = Integer.MAX_VALUE;

        for(int k = 1; k <= f ; k++)
        { 
        
        int low;
            if(t[e-1][k-1] != -1)
            {
                low = t[e-1][k-1];
            }
            else 
            {
                low = solve(e-1, k-1 ,t);
                t[e-1][k-1] = low;
            }

        int high;
        if(t[e][f-k] != -1)
        {
            high = t[e][f-k];
        }
        else 
        {
            high = solve(e, f-k, t);
            t[e][f-k] = high;
        }


            int temp_ans = 1 +  Math.max(low , high) ;

            min = Math.min(min , temp_ans);
        }

        return t[e][f] = min;
    }
}