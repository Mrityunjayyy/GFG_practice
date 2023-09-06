//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution
{ 
    
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack();
        
        for(int i = 0 ; i < V ; i++)
        {
            if(vis[i] == false)
            dfs1(adj  , i , stack , vis);
        }
        
        int ans = stack.pop();
        
        int[] count = new int[1];
        
        vis = new boolean[V];
        dfs2(adj , ans , vis , count);
        
        return (count[0] == V) ? ans : -1; 
    }
        
        
        public void dfs1(ArrayList<ArrayList<Integer>>adj , 
        int vertex ,Stack<Integer> stack , boolean[] vis)
        {
            vis[vertex] = true;
            
            for(int neighbour : adj.get(vertex))
            {
                if(vis[neighbour] == false)
                {
                    dfs1(adj , neighbour , stack , vis);
                }
            }
            
            stack.push(vertex);
        }
        
         public void dfs2(ArrayList<ArrayList<Integer>>adj , 
        int vertex ,boolean[] vis , int[] count)
        {
            vis[vertex] = true;
            count[0]++;
            
            for(int neighbour : adj.get(vertex))
            {
                if(vis[neighbour] == false)
                {
                    dfs2(adj , neighbour ,  vis , count);
                }
            }
            
        }
        
        
    
}