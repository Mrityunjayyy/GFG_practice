//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int k = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.safePos(n,k));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int safePos(int n, int k) {
        ArrayList<Integer> al = new ArrayList();
        for(int i = 1 ; i <= n ; i++)
        {
            al.add(i);
        }
        
        --k;
        
        solve(al  , 0 , k);
        
        return al.get(0);
    }
    
    public static void solve(ArrayList<Integer> al , int index ,int k)
    {
        if(al.size() == 1)
        {
            return;
        }
        
        index = (index + k)%al.size();
        al.remove(index);
        solve(al , index , k);
    }
};