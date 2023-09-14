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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    long t[][];
    int mod = 1_000_000_00_7;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    t = new long[n+1][sum+1];
	    t[0][0] =1l; //initialization
	    
	    for(int i = 1 ; i < n+1; i++)
	    {
	        for(int j = 0 ; j < sum+1 ; j++)
	        {
	            if(arr[i-1] <= j)
	            {
	                t[i][j] = ( t[i-1][j] %mod + t[i-1][j - arr[i-1]]%mod ) %mod;
	            }
	            else 
	            {
	                t[i][j] = t[i-1][j] % mod;
	            }
	        }
	    }
	    
	    
	    return (int)t[n][sum];
	} 
	
}