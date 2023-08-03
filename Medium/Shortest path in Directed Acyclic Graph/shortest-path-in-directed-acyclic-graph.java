//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
	    int[][] graph = new int[N][N];
	    
	    for(int[] edge : edges) 
	    {
	            int source = edge[0];
	            int destination = edge[1];
	            int weight = edge[2];
	            graph[source][destination]  =  weight;
	    }
	    
	    
		
		 int[] ans = new int[N];
		 Arrays.fill(ans , Integer.MAX_VALUE);
		 ans[0] = 0;
		 
		 
		  PriorityQueue<Pair> pq = new PriorityQueue<>();
		  pq.add(new Pair(0 , 0));
		 
		 while(!pq.isEmpty())
		 {
		     Pair curr = pq.remove();
		     int currentVertex = curr.v;
		     int currentDistance = curr.wt;
		     
		     if(currentDistance > ans[currentVertex])
		     continue;
		     
		     
		     for(int neighbour = 0 ; neighbour < N  ; neighbour++)
		     {
		         int weight = graph[currentVertex][neighbour];
		         if(weight > 0) //valid edge
		         {
		             int distance = currentDistance  + weight;
		              if (distance < ans[neighbour]) {
                        ans[neighbour] = distance;
                        pq.add(new Pair(neighbour, distance) );
                    }
		         }
		     }
		 }
		 
		 
		 for(int i = 0 ; i < ans.length ; i++)
		 {
		     if(ans[i] == Integer.MAX_VALUE)
		     {
		         ans[i] = -1;
		     }
		 }
		 
		 
		 return ans;
	}
}


class Pair implements Comparable<Pair>
{
    int v;
    int wt;
    
    
    Pair(int v , int wt)
    {
        this.v = v;
        this.wt = wt;
    }
    
    
    public int compareTo(Pair that)
    {
        return this.wt - that.wt;
    }
}