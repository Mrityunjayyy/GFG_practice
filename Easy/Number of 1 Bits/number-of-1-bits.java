//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();

            Solution ob = new Solution();
            int cnt = ob.setBits(N);
            System.out.println(cnt);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static int setBits(int N) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int count = 0;
        while(N > 0)
        { 
            al.add(N%2);
            N = N/2 ; 
        } 
        
        for(int i  = 0 ; i < al.size() ; i++)
        { 
            if(al.get(i) == 1)
            count++;
        }
        
        
        return count;
    }
}