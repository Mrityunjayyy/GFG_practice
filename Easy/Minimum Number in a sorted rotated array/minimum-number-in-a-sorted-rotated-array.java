//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Array
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");
            
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(st[i]);
              
            System.out.println(new Solution().minNumber(arr,0,n-1));
        }
    }
    
}
// } Driver Code Ends


class Solution
{
    //Function to find the minimum element in sorted and rotated array.
    static int minNumber(int arr[], int low, int high)
    { 
       int n =  arr.length;
       while(low <= high)
       {
           int mid = low + (high - low)/2;
           int prev = (mid + n -1)%n;
           int next = (mid + 1) %n;
           
           if(arr[mid] <= arr[next] && arr[mid] <= arr[prev])
           {
              return arr[mid];
           }
           
           else if(arr[mid] <=  arr[high]) //right array is shoifted move left
           high = mid -1;
           
           else if(arr[low] <= arr[mid]) //left array is sorted move right
           low = mid +1;
           
       }
       
       return -1;
    }
}