//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    { 
        // number of students > numbers of books available 
        if(N < M) return -1;
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int a : A)
        {
            if(a > max)
            max = a;
            
            sum += a;
        }
        
        
        int low  = max;
        int high = sum;
        int res = -1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            
            if(isValid(A , N , M , mid))
            {
                res = mid;
                high = mid -1;
            }
            else 
            low = mid +1;
        }
        
        return res;
    }
    
    
    public static boolean isValid(int[] arr , int n , int k , int max)
    {
        int students = 1;
        int sum = 0;
        for(int i = 0 ; i < n ; i++)
        {
            sum += arr[i];
            
            if(sum > max)
            {
                students++;
                sum = arr[i];
            }
            
            if(students > k)
            {
                return false;
            }
        }
        
        return true;
    }
};