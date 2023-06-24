//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
       ArrayList<String> al = new ArrayList<String>(); 
        
        makeVisit(al , m , n);
        
        return al;
    }
    
    //This method just creates a 2d visited element array of size n*n with all entry zero and calls pathFinder
    public static void makeVisit(ArrayList<String> al ,int[][] maze , int n)
    {
        int[][] visit = new int[n][n];
        for(int i = 0 ; i < n ; i++)
        { 
            for(int j = 0 ; j < n ;j ++)
            { 
                visit[i][j] = 0;
            }
        }
        
        if(maze[0][0] == 1)
        pathFinder(al , maze , visit , 0 , 0 , n , "");
        
    }
    
    
    
    public static void pathFinder(ArrayList<String> al , int[][] maze , int[][] visit , int  i , int j , int n , String ans )
    { 
    if(i == n-1 && j ==n-1)
        { 
             al.add(ans);
             return;
        }
    
    
      
        //lexicographical order DLRU
        
        //down
        if(i + 1 < n && visit[i+1][j] == 0 && maze[i+1][j] == 1)
        { 
            visit[i][j] = 1;
            pathFinder(al, maze , visit , i +1 , j , n ,ans + "D");
            visit[i][j] = 0;
        }
        
        
        //left 
        if(j -1 >= 0 && visit[i][j-1] ==0 && maze[i][j-1] == 1)
        { 
            visit[i][j] = 1;
            pathFinder(al, maze , visit , i  , j-1 , n ,ans + "L");
            visit[i][j] =0;
        }
        
        //right
        if(j+1 < n && visit[i][j+1] == 0 && maze[i][j+1] == 1)
        { 
            visit[i][j] =1;
            pathFinder(al, maze , visit , i , j +1  , n ,ans + "R");
            visit[i][j] = 0;
        }
        
        
        //Up
        if(i-1 >= 0 && visit[i-1][j] == 0 && maze[i-1][j] == 1)
        { 
            visit[i ][j] = 1;
            pathFinder(al, maze , visit , i -1 , j , n ,ans + "U");
            visit[i ][j] = 0;
        }
        
        
       
    }
    
}