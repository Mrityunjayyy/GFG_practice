//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[]=in.readLine().trim().split(" ");
            String a = s[0];
            String b = s[1];
            Solution g = new Solution();
            if(g.isScramble(a,b)){
                out.println("Yes");
            }
            else{
                out.println("No");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static HashMap<String , Boolean> map = new HashMap<>();
    static boolean isScramble(String S1,String S2)
    { 
        if(S1.length() != S2.length()) return false;
        
        return solve(S1, S2);
    }
    
    public static boolean solve(String a , String b)
    {
        if(a.equals(b) == true) return true;
        
        if(a.length() <= 1) return false; // any one string becomes empty question constraints
         
        String key = a + " " + b;
        
        if(map.containsKey(key))
        return map.get(key);
        
        
        int n = a.length();
        boolean flag = false;
        
        for(int i = 1 ; i <= n-1 ; i++)
        { 
            //condition1 gr_ate --- ate_gr
            if( solve(a.substring(0 , i) , b.substring(n-i))
            && solve(a.substring(i) , b.substring(0 , n-i))
            
            ||
            
            //condition2  gr__eat -- gr__ate
            solve( a.substring(0 , i) , b.substring(0 , i))
            && solve(a.substring(i) , b.substring(i))
            )
            
            {
              flag = true;
              break;
            }
        }
        
        map.put(key , flag);
        return flag;
        
    }
}
  