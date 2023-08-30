//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 2);
            
            Solution obj = new Solution();
            String res = obj.kthPermutation(a[0],a[1]);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
     static int count;
    public static String kthPermutation(int n,int k) {
        count = k;
      char[] arr = new char[n];
      for(int i = 1 ; i <= n ; i++)
      {
          arr[i-1] =(char)(i  + 48);
      }
      List<String> ans = new ArrayList();
      String s = new String(arr);
      solve(ans , s , new boolean[s.length()] , new StringBuilder());
      return ans.get(k-1);
      
        
    }
    
   
    public static void solve(List<String> ans , String s , boolean[] vis , StringBuilder sb)
    {
        if(ans.size() > count)
        return;
        
        if(sb.length() == s.length())
        {
            ans.add(sb.toString());
            return;
        }
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            if(vis[i] == true || (i > 0 && s.charAt(i) == s.charAt(i-1) && vis[i-1] == true) )
            continue;
            
            
            vis[i] = true;
            sb.append(s.charAt(i));
            solve(ans , s , vis , sb);
            sb.deleteCharAt(sb.length() -1);
            vis[i] = false;
        }
    }
}
        
