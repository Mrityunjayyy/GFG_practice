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
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int mod  = 1_000_000_00_7;
    static int nthFibonacci(int n){
        if(n <=2) return 1;
        int first = 1; 
        int second = 1;
        int third = 0;
        for(int i = 0 ; i < n -2 ; i++)
        {
            third = (first%mod + second%mod)%mod;
            first = second;
            second  = third;
        }
        
        return third%mod;
    }
}