//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

//standard BFS time complexity (N*M)
//Mrityunjay
class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
       Queue<Pair> q = new LinkedList<>();
       boolean[][] vis = new boolean[N][M];
       
       int[] dx = {-1,0,1,0}; // up right down left
       int[] dy = {0,1,0,-1};
       
       q.add(new Pair(0,0,0));  // source destination distance
       vis[0][0] = true;
       
       while(!q.isEmpty())
       {
           Pair curr = q.poll();
           
           if(curr.x == X && curr.y == Y)
           return curr.d;
           
           for(int i = 0 ; i < 4 ; i++)
           {
               int nX = dx[i] + curr.x;
               int nY = dy[i] + curr.y;
               
               if(nX>-1 && nX < N && nY > -1 && nY < M &&
               vis[nX][nY] == false &&
               A[nX][nY] == 1)
               {
                   vis[nX][nY] = true;
                   q.add(new Pair(nX , nY , curr.d +1));
               }
           }
       }
       
       return -1;
    }
}


class Pair 
{
    int x,y,d;
    
    Pair(int x , int y , int d )
    {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}