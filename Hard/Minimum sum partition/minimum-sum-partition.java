//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    int sum = 0 ;
	    for(int i  : arr)
	    {
	        sum += i;
	    }
	    
	    boolean[][] t = new boolean[n+1][sum+1];
	    subsetSum(arr, sum , n , t);
	    
	   // ArrayList<Integer> al = new ArrayList<>();
	    
	    int min = 0;
	    
	    for(int i = 0 ; i < (sum/2) +1  ; i++)
	    {
	       if(t[n][i] == true)
	       {
	           min = i;
	       }
	    }
	    
	   
	   // for(int i = 0 ; i < al.size() ; i++)
	   // {
	   //    min = Math.min(min , sum - (2*al.get(i)) ); 
	   // }
	    
	    return sum - 2*min;
	} 
	
	public void subsetSum(int[] arr , int sum  , int n , boolean[][] t )
	{
	   
	    for(int i = 0 ; i < n +1 ; i++)
	    {
	        t[i][0] = true;
	    }
	    
	    for(int i = 1 ; i < n+1 ; i++)
	    {
	        for(int j = 1 ; j < sum +1 ; j++)
	        {
	            if(arr[i-1] <= j)
	            {
	                t[i][j] = t[i-1][j - arr[i-1]]  || t[i-1][j] ;
	            }
	            else 
	            {
	                t[i][j] = t[i-1][j];
	            }
	        }
	    }
	}
	
}
