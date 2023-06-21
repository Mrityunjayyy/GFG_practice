//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfWays(N));
        }
    }
}
// } Driver Code Ends


class Solution {
    static Long numberOfWays(int N) {
        int n =  1000000007;
        if(N <= 3)
        return (long)N ;
        
        
       long first = 1 , second = 2 , next = 0;
       for(int i = 0 ; i < N - 2 ; i++)
       { 
           next = (first %n + second % n ) %n;  
           first = second;
           second = next;
       }
       
       
       return next ;
    }
};