//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
       if(arr[0] < arr[n-1]) return 0; 
       return indexOfSmallestElement(arr , n);
    }
    
    
    public int indexOfSmallestElement(int[] arr, int n)
    {
       int low  = 0; 
       int high = n-1;
       while(low <= high)
       {
           int mid = low + (high - low)/2;
           int prev = (mid + n -1)%n;
           int next = (mid + 1) %n;
           
           if(arr[mid] <= arr[next] && arr[mid] <= arr[prev])
           {
              return mid;
           }
           
           else if(arr[mid] <=  arr[high]) //right array is shoifted move left
           high = mid -1;
           
           else if(arr[low] <= arr[mid]) //left array is sorted move right
           low = mid +1;
           
       }
       
       return -1;
    }
}