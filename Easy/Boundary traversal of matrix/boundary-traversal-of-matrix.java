//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            s = in.readLine().trim().split(" ");
            int ind=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[ind++]);
                }
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.boundaryTraversal(a, n, m);
            for (int i : ans) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        
        int top  = 0 ;
        int left = 0;
        int bottom = n-1;
        int right = m-1;
        
        ArrayList<Integer> ans = new ArrayList();
        
        
        for(int i = left ; i <= right ; i++)
        {
            ans.add(matrix[top][i]);
        }
        top++;
        
        for(int i = top ; i <= bottom ; i++)
        {
            ans.add(matrix[i][right]);
        }
        right--;
        
        if(top <= bottom)
        {
            //right to left
            for(int i = right ; i >= left ; i--)
            {
                ans.add(matrix[bottom][i]);
            }
            bottom--;
        }
        
        if(left <= right)
        {
            //bottom to top
            for(int i = bottom ; i >= top ; i--)
            {
                ans.add(matrix[i][left]);
            }
            left++;
        }
        
        
        return ans;
    }
}
