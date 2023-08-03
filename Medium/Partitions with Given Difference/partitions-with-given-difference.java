//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{
    
    static int mod = 1_000_000_00_7;
    public int countPartitions(int n, int d, int arr[]){
    
     int sum = 0;
     for(int i : arr)
     {
         sum += i;
     }
     
     int case_check = sum + d;
     
     if( (case_check & 1 ) != 0 )  //if sum + d is odd then (sum+d)/2 will not be a whole number so no way to solve the problem
     return 0;
     
     
     int s1 = (case_check)/2;  //subset sum 1 derived from the 2 equations
     
     return subsetS(arr , s1 , arr.length);
     
    }
    
    
     public int subsetS(int[] arr , int sum ,int n)  
     {
         int[][] t = new int[n+1][sum+1];
         t[0][0] = 1;
         
         
         for(int i = 1 ; i < n+1 ; i++)
         {
             for(int j = 0 ; j < sum +1 ; j++)
             {
                 if(arr[i-1] <= j)
                 {
                     t[i][j] = ((t[i-1][j - arr[i-1]] % mod) + (t[i-1][j] %mod) ) %mod;
                 }
                 else 
                 {
                     t[i][j] = t[i-1][j];
                 }
             }
         }
         
         return (int)t[n][sum]%mod;
     }
    
}