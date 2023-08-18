//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.searchInsertK(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int searchInsertK(int Arr[], int N, int k)
    {
        int low = 0;
        int high = N -1;
        int res = -1;
        
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            
            if(Arr[mid] == k)
            return mid;
            
            else if(Arr[mid] > k)
            {
                res = mid;
                high = mid -1;
            }
            
            else 
            low = mid +1 ;
        }
        
        if(res != -1) return res;
        
        int res2 = findCeil(Arr , Arr.length , k);
        return res2+1;
    }
    
    public static int findCeil(int[] a , int n , int target)
    {
        int low = 0 ;
        int high = n-1;
        int res = -1;
        
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            
            if(a[mid] == target)
            return mid;
            
            else if(a[mid] < target)
            {
                res = mid;
                low = mid + 1;
            }
            
            else 
            high = mid -1 ;
        }
        
        return res;
    }
}