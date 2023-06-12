//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static long nthFibonacci(long n){
        if(n <= 1) return n;
         long first = 0 , second = 1 , next = 0 ;
         
         for(int i = 0 ; i <= n -2   ; i++)
         { 
             next = (first  + second)% 1000000007; 
             first = second;
             second = next; 
             
         }
         
         return next ;
    }
}