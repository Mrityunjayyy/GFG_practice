//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
       int ans = partition(arr , l , r , k);
       return arr[ans];
       
    } 
    
    
    
    public static int partition(int[] arr , int low , int high, int k)
    { 
       int m = findPivot(arr ,  low , high);
            
            
        if(m == k-1)
        { 
            return m;
        }
        
        else if(m < k-1) //right search
        { 
           return partition(arr , m+1 , high ,k);
        }
        
        else //left search
        { 
             return partition(arr , low , m-1 , k);
        }
        
  
    }
    
    
    
    public static int findPivot(int[] arr , int low , int high)
    { 
        //randomized quick sort
        int random = low + (int)Math.random() % (high - low +1);
        int tem = arr[random];
        arr[random] = arr[low];
        arr[low] = tem;
        
        
        int i = low;
        int pivot = arr[low];
        
        for(int j = low + 1 ; j <= high ; j++)
        { 
            if(arr[j] <= pivot)
            { 
                i = i+1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        
        int temp = arr[i];
        arr[i] =arr[low];
        arr[low] =temp;
        
        
        return i;
    }
}
