//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String S){
       int n = S.length();
       String ans = "";
       Deque<Integer> dq = new ArrayDeque<Integer>();
       
       for(int i = 0 ; i <= n ; i++)
       { 
           dq.push(i+1);
           
           
           if(i == n || S.charAt(i) == 'I')
           { 
               while(!dq.isEmpty())
               ans = ans + dq.pop();
           }
           
       }
       
       
       return ans;
    }
}
