//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    boolean[] vis = new boolean[V];
	    PriorityQueue<Pair> pq = new PriorityQueue<>();
	    
	    int[][] graph = new int[V][V];
	    
	    for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            graph[u][v] = graph[v][u] = wt; // Assuming undirected graph
        }
	    
	    pq.add(new Pair(0,0));
	    int ans = 0; // minimum cost to attach all the cities
	    
	    while(!pq.isEmpty())
	    {
	        Pair curr = pq.remove();
	        
	        int u = curr.v; //The current vertex data
	        
	        if(vis[u])
	        {
	            continue;
	        }
	        
	            ans += curr.wt;
	            vis[u] = true;
	        
	        
	       // ArrayList<ArrayList<Integer>> neighbours = adj.get(u);
	        
	       // for(ArrayList<Integer> list : neighbours)
	       // {
	       //     int vertex = list.get(0);
	       //     int wt = list.get(1);
	            
	       //     if(vis[vertex] == false )
	       //     {
	       //         pq.add(new Pair(vertex , wt));
	       //     }
	       // }
	        
	         for (int v = 0; v < V; v++) 
	         {
                if (!vis[v] && graph[u][v] != 0)
                {
                    pq.add(new Pair(graph[u][v], v));
                }
             }
	        
	    }
	    
	    return ans;
	}
	
}


class Pair implements Comparable<Pair>
{
    int wt ; //weight 
    int v; //vertex value
    
    
    Pair(int wt , int v)
    {
        this.wt = wt;
        this.v = v;
    }
    
    public int compareTo(Pair that)
    {
        return  this.wt - that.wt;
    }
    
} 
