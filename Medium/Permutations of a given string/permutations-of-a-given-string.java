//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        char[] arr = S.toCharArray();
        Arrays.sort(arr);
        S = new String(arr);
        List<String> ans = new ArrayList<String>();
       solve(ans , S , new boolean[S.length()] , new StringBuilder());
      return ans;
    }
    
    public void solve(List<String> ans , String s , boolean[] vis , StringBuilder sb)
    {
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