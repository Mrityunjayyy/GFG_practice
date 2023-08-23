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
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        int max = Integer.MIN_VALUE;
        int ans = -1;
        for(int i = 0 ; i < n ; i++)
        {
            int a = firstOccurence(arr[i]);
       //     System.out.println(a);
            int count = (a == -1)?0 : m - a;
            if(max < count)
            { 
                max = count;
                ans = (max == 0) ? -1 : i;
            }
        }
        
        return ans;
    }
    
    public int firstOccurence(int[] arr)
    {
        int res = -1;
        int low = 0 ;
        int high = arr.length -1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            
            if(arr[mid] == 1)
            {
               res = mid;
               high = mid -1;
            }
            else 
            low = mid +1;
        }
        
        return res;
    }
}