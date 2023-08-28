//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();//total testcases
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            int N;
            
            //taking input N
            N = sc.nextInt();

            //calling toh() method 
            System.out.println(obj.toh(N, 1, 3, 2));
        }
    }
}






// } Driver Code Ends


// User function Template for Java


// avoid space at the starting of the string in "move disk....."
class Hanoi {
    int count = 0;
    public long toh(int N, int from, int to, int aux) {
        solve(from , to , aux , N);
        return count;
    }
    
    public void solve(int s , int d , int h , int n)
    {
        if(n == 1)
        {
            System.out.println("move disk " + n + " from rod "+  s+ " to rod " +  d);
            count++;
            return;
        }
        
        
        solve(s , h , d , n-1);
        System.out.println("move disk " + n + " from rod "+  s+ " to rod " +  d);
        count++;
        solve(h , d , s , n-1);
        return;
        
    }
}
