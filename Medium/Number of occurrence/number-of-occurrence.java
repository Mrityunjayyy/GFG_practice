//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        int i;
      int j;
          
     
      i = first(arr, 0, n-1, x, n);
      
      /* If x doesn't exist in arr[] then return -1 */
      if(i == -1)
        return 0;
         
      j = last(arr, i, n-1, x, n);    
         
      /* return count */
      return j-i+1;
    }
    
     static int first(int arr[], int low, int high, int x, int n)
    {
      if(high >= low)
      {
        /*low + (high - low)/2;*/ 
        int mid = (low + high)/2; 
        if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x)
          return mid;
        else if(x > arr[mid])
          return first(arr, (mid + 1), high, x, n);
        else
          return first(arr, low, (mid -1), x, n);
      }
      return -1;
    }
     
     
      public int last(int arr[], int low, int high, int x, int n)
    {
      if(high >= low)
      {
        /*low + (high - low)/2;*/     
        int mid = (low + high)/2;
        if( ( mid == n-1 || x < arr[mid+1]) && arr[mid] == x )
          return mid;
        else if(x < arr[mid])
          return last(arr, low, (mid -1), x, n);
        else
          return last(arr, (mid + 1), high, x, n);     
      }
      return -1;
    }
}