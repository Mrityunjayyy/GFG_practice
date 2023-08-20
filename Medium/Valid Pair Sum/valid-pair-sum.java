//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int array[] = new int[n];
        	for (int i=0; i<n ;i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            System.out.println(ob.ValidPair(array,n));
            t--;
        }
    } 
} 

// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static long ValidPair(int a[], int n) 
	{ 
	   Arrays.sort(a); //N(logn)
	   int left = 0;
	   long count = 0;
	   int right =  n-1;
	   while(left < right)
	   {
	       if(a[left] + a[right] > 0)
	       {
	           count += right - left;
	           right--;
	       }
	       else 
	       {
	            left++;
	       }
	   }
	   
	   return count;
	}
} 
