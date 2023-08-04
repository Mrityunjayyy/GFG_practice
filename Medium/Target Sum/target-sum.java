//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A,N, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTargetSumWays(int[] A , int N, int target) {
        int sum = 0;
        for(int i : A)
        {
            sum += i;
        }
        
        int check =sum + target;
        
        if(check < 0) return 0;  // if target is large negative value not possible
        if ( (check & 1) != 0) return 0;  // if sum + diff is a negative value (sum+diff)/2 will be a decimal 
        
        int s1 = check >> 1; // right shift by 1 divide by 2
        return subsetSum(A , s1 ,N);
        
    }
    
    public static int subsetSum(int[] arr, int sum , int n)
    {
        int[][] t = new int[n+1][sum+1];
        
        t[0][0] =1; 
        
        for(int i =1 ;i < n+1 ; i++)
        {
            for(int j = 0 ; j < sum +1 ; j++)
            {
                if(arr[i-1] <= j)
                {
                    t[i][j] = t[i-1][j - arr[i-1]] + t[i-1][j];
                }
                else 
                {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        
        return t[n][sum];
    }
}